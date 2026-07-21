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
{'confidence': 65, 'pitch strategy': 'The client operates in a high-growth environment with strong revenue and asset increases, reflecting positive industry momentum. However, the rapid and substantial liability growth, coupled with very high and consistent utilization of Category 1 facilities above 90%, signals elevated financial stress and risk. It is crucial to re-inform the client about the importance of managing liabilities and utilization levels to maintain creditworthiness under the approved facility letter. Additional information on cash flow stability, detailed liability composition, and contingency plans would help tailor risk mitigation strategies. A focused revenue strategy should emphasize stabilizing cash flows, diversifying income streams, and improving operational efficiency to support sustainable growth and reduce dependency on high borrowing.'}
"""
