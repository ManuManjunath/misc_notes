# To create a new webhook, to to your slack channel and type - 
# /webhook create
# Use the webhook link below - 

curl -X POST 'https://api.enterprise.com/slack_events/v1/webhooks/xxx' -H 'Content-type: application/json ' -d '{"text": "My text message using curl"}'
