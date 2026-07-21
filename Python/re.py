from parse_data import send_metrics

metrics = send_metrics()

def build_prompt(metrics: dict) -> str:
    return f"""
You are Relationship manager for a major client at a global commercial bank.
Your responsibility is to evaluate whether the sanctioned lending amount poses an acceptable credit risk based solely on the financial metrics provided.
The Facility letter is already approved from the bank.
Do NOT make assumptions beyond the supplied information.
Evaluate all of the following:
- Revenue growth and stability
- Asset growth and stability
- Liability growth and stability
- Contingent liabilities
- Existing leverage
- Facility utilization
- Available borrowing capacity
- Requested loan relative to company size
- Overall financial health
Risk Guidelines:
• Higher revenue growth reduces risk.
• Stable revenue (low coefficient of variation) reduces risk.
• Declining revenue increases risk.
• Strong asset growth reduces risk.
• Rapid liability growth increases risk.
• High Debt-to-Asset ratio increases risk.
• High Contingent-to-Asset ratio increases risk.
• Average utilization above 80% indicates elevated borrowing.
• Maximum utilization above 90% indicates financial stress.
• Multiple months above 90% utilization significantly increase risk.
• Low unused borrowing capacity increases risk.
• Requested loan should be reasonable relative to:
    - Assets, Revenue.Existing limits, Available borrowing capacity
• Large month-to-month volatility indicates uncertainty and therefore increases risk.
Financial Summary
{metrics}
Return ONLY valid JSON in exactly this format:
{{
    "confidence": 0-100,
    "pitch strategy: 
        "4-5 concise sentences including Global information on Industry to click the conversation relevant and to improve revenue
        Clear plan to the client on the important info that by the facility letter needs to be re-informed.
        What additional information would the RM provide to the client to achieve the desired outcome.
        Revenue Strategy"
}}
Do not include markdown, code fences, headings, or any text outside the JSON object.
"""


"""
{'confidence': 85, 'Briefing Note': 'The client demonstrates strong revenue and asset growth, which is positive for credit risk; however, the revenue volatility is very high, indicating instability. Liability growth is extremely rapid, with a high debt-to-asset ratio, and contingent liabilities are negligible, which somewhat mitigates risk. Facility utilization for CAT1 is consistently above 90%, indicating financial stress and elevated borrowing risk, while CAT2 utilization is moderate. The requested loan amount is reasonable relative to assets but disproportionately high compared to revenue, suggesting potential cash flow concerns. The facility letter should be re-affirmed with emphasis on monitoring utilization levels and liability management. Additional information on cash flow, debt servicing capacity, and industry-specific risks would help refine risk assessment.A revenue strategy focusing on stabilizing cash flows and reducing volatility through diversified income streams and improvedreceivables management is recommended.'}
"""
