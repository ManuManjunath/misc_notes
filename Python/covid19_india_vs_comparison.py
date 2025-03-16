import requests
import json
import pandas as pd

comp_country = 'Portugal'

data_source = "https://pomber.github.io/covid19/timeseries.json"
response = requests.get(data_source).text
india_cases = json.loads(response)["India"]
comp_cases = json.loads(response)[comp_country]

india_df = pd.DataFrame(india_cases)
india_df['date'] = pd.to_datetime(india_df['date'])
india_df = india_df.set_index('date')
comp_df = pd.DataFrame(comp_cases)
comp_df['date'] = pd.to_datetime(comp_df['date'])
comp_df = comp_df.set_index('date')
join_df = pd.merge(india_df, comp_df, on='date')
new_df = join_df[['confirmed_x', 'confirmed_y']]
new_df = new_df.rename(columns={'confirmed_x': 'India', 'confirmed_y': comp_country})
new_df.plot(figsize=(20, 5), title="Covid19 cases in India and US")
