import requests

"""
To create a new webhook, to to your slack channel and type - 
/webhook create
Use the webhook link below - 
"""

slack_webhook = "https://api.enterprise.com/slack_events/v1/webhooks/xxx"

head={'Content-type': 'application/json'}
myText = '{"text": "My text content"}'

response = requests.post(slack_webhook, headers=head, data=myText)
