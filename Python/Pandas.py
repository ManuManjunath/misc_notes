import pandas as pd
import numpy as np

# Creating dataframes
# from CSV - 
df = pd.read_csv("your_file.csv")
# from SQL
sql = 'select * from dual'
connection = pyodbc.connect()
pd.read_sql(sql, connection)
# from a list of lists - 
list_1 = [['one', 1], ['two', 2], ['three', 3]]
df = pd.DataFrame(list_1, columns = ['In_Words', 'In_Digits']) 
# from a dictionary of lists - 
dict_1 = {'In_Words': ['One', 'Two', 'Three'], 'In_Digits': [1, 2, 3]}
df = pd.DataFrame(dict_1)
# from a list of dictionaries - 
list_2 = [{'one': 1, 'two': 2, 'three': 3}, {'one': 'I', 'two': 'II', 'three': 'III'}]
df = pd.DataFrame(list_2)
# more dictionaries
"""
split : dict like {index -> [index], columns -> [columns], data -> [values]}
records : list like [{column -> value}, ... , {column -> value}]
index : dict like {index -> {column -> value}}
columns : dict like {column -> {index -> value}}
values : just the values array
"""

# To see the number of rows and columns
df.shape
# To see the top 5 rows
df.head()
# To see the top 2 rows
df.head(2)
# To see the last 5 roiws
df.tail()
# To see rows 2 to 4
df(2:5)
# To see the column names
df.columns
# To see distinct values
df['col_1'].unique()
# For high level summary - mean, max, min, std_dev, percentiles
df.describe()
# To drop columns
df.drop(['col_1', 'col_2'], axis=1)
# To see all values of col_1
df.col_1
# To see all values of col_1 and col_2
df[['col_1', 'col_2']
# avg(col_1)
df['col_1'].mean()
# max(col_1)
df['col_1'].max()
# select * from df where col_1 > 100
df[df.col_1 > 100]
# Get row with max col_1
df[df.col_1 == df['col_1'].max()]

# Graphs
# bar graph with counts by col_1
pd.value_counts(df['col_1']).plot.bar()
