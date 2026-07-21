def build_prompt(metrics):

    return f"""
You are a Senior Corporate Credit Risk Analyst.

Assess the risk of approving the requested loan.

Credit Guidelines:

- Higher revenue and asset growth reduce risk.
- Rapid liability growth increases risk.
- High utilization (>85%) increases risk.
- Requested loan should be reasonable compared to assets and revenue.
- High debt-to-asset ratio increases risk.
- Low available limit increases risk.

Financial Summary

Revenue Growth: {metrics['revenue_growth_pct']:.2f}%

Asset Growth: {metrics['asset_growth_pct']:.2f}%

Liability Growth: {metrics['liability_growth_pct']:.2f}%

Contingent Growth: {metrics['contingent_growth_pct']:.2f}%

Average Utilization: {metrics['avg_utilization_pct']:.2f}

Maximum Utilization: {metrics['max_utilization_pct']:.2f}

Available Limit: {metrics['available_limit']:.2f}

Debt/Asset Ratio: {metrics['debt_asset_ratio']:.2f}

Contingent/Asset Ratio: {metrics['contingent_asset_ratio']:.2f}

Requested Loan: {metrics['requested_loan']}

Requested Loan / Assets: {metrics['request_to_assets_pct']:.2f}%

Requested Loan / Revenue: {metrics['request_to_revenue_pct']:.2f}%

Requested Loan / Limit: {metrics['request_to_limit_pct']:.2f}%

Return ONLY valid JSON.

{{
    "risk":"LOW|MEDIUM|HIGH",
    "confidence":0-100,
    "reason":"Maximum two sentences."
}}
"""
