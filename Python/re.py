import json
from openai import OpenAI
from parse_data import send_metrics
from prompt import build_prompt

class LLMService:

    def __init__(self, api_key: str, model: str = "gpt-4.1-mini"):
        self.client = OpenAI(api_key=api_key)
        self.model = model

    def get_credit_recommendation(self):
        # Read metrics from JSON
        metrics = send_metrics()
        # Build prompt
        prompt = build_prompt(metrics)
        # Call OpenAI
        response = self.client.responses.create(
            model=self.model,
            input=prompt,
            temperature=0
        )
        result = response.output_text.strip()
        # Convert JSON string to Python dict
        try:
            return json.loads(result)
        except json.JSONDecodeError:
            return {
                "error": "LLM did not return valid JSON.",
                "raw_response": result
            }

"""
{'confidence': 85, 'Briefing Note': 'The client demonstrates strong revenue and asset growth, which is positive for credit risk; however, the revenue volatility is very high, indicating instability. Liability growth is extremely rapid, with a high debt-to-asset ratio, and contingent liabilities are negligible, which somewhat mitigates risk. Facility utilization for CAT1 is consistently above 90%, indicating financial stress and elevated borrowing risk, while CAT2 utilization is moderate. The requested loan amount is reasonable relative to assets but disproportionately high compared to revenue, suggesting potential cash flow concerns. The facility letter should be re-affirmed with emphasis on monitoring utilization levels and liability management. Additional information on cash flow, debt servicing capacity, and industry-specific risks would help refine risk assessment.A revenue strategy focusing on stabilizing cash flows and reducing volatility through diversified income streams and improvedreceivables management is recommended.'}
"""
