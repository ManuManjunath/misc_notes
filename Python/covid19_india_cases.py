import requests
import json
import pandas as pd

data_source = "https://pomber.github.io/covid19/timeseries.json"
response = requests.get(data_source).text
india_cases = json.loads(response)["India"]

df = pd.DataFrame(india_cases)
df['date'] = pd.to_datetime(df['date'])
df = df.set_index('date')
# print(df.dtypes)
df.plot(figsize=(10, 5), title="Covid19 cases in India")
