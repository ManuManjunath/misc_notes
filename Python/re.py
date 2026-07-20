import re
import fitz
import pandas as pd

####################################################
# Read PDF
####################################################

def extract_text(pdf_path):
    doc = fitz.open(pdf_path)

    text = ""

    for page in doc:
        text += page.get_text()

    return text


####################################################
# Extract values
####################################################

def extract_details(text):

    company = re.search(
        r'Company Name\s*:\s*(.*)',
        text,
        re.IGNORECASE
    )

    facility = re.search(
        r'Requested Facility\s*:\s*(.*)',
        text,
        re.IGNORECASE
    )

    amount = re.search(
        r'Additional Amount Requested\s*:\s*INR\s*([\d,]+)',
        text,
        re.IGNORECASE
    )

    return {
        "CompanyName": company.group(1).strip(),
        "LimitCategory": facility.group(1).strip(),
        "RequestedAmount": int(amount.group(1).replace(",", ""))
    }


####################################################
# Load datasets
####################################################

company_df = pd.read_excel("Dataset1.xlsx")

limits_df = pd.read_excel("Dataset2.xlsx")

####################################################
# Read PDF
####################################################

pdf_text = extract_text("LoanRequest.pdf")

request = extract_details(pdf_text)

####################################################
# Find company
####################################################

company = company_df[
    company_df["CompanyName"] == request["CompanyName"]
]

if company.empty:
    raise Exception("Company not found")

company_id = company.iloc[0]["CompanyID"]

####################################################
# Existing limit
####################################################

existing = limits_df[
    (limits_df["CompanyID"] == company_id) &
    (limits_df["LimitCategory"] == request["LimitCategory"])
]

if existing.empty:
    raise Exception("Limit category not found")

existing = existing.iloc[0]

####################################################
# Risk calculations
####################################################

sanctioned = existing["SanctionedLimit"]

outstanding = existing["Outstanding"]

requested = request["RequestedAmount"]

current_utilization = outstanding / sanctioned

future_outstanding = outstanding + requested

future_utilization = future_outstanding / sanctioned

available_limit = sanctioned - outstanding

####################################################
# Decision
####################################################

if future_utilization > 1:
    decision = "HIGH RISK - Exceeds sanctioned limit"

elif future_utilization > 0.9:
    decision = "MEDIUM RISK"

else:
    decision = "LOW RISK"

####################################################
# Output
####################################################

print("\n========== RESULT ==========\n")

print("Company :", request["CompanyName"])
print("Facility :", request["LimitCategory"])
print("Requested :", requested)

print("\nCurrent Outstanding :", outstanding)
print("Sanctioned Limit :", sanctioned)
print("Available :", available_limit)

print("\nCurrent Utilization : {:.2%}".format(current_utilization))
print("Future Utilization : {:.2%}".format(future_utilization))

print("\nDecision :", decision)
