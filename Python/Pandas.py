import pandas as pd
import numpy as np

# Creating dataframes
# Create empty dataframe
df2 = pd.DataFrame(columns=['one', 'two', 'three'])
# Append rows to df2
df2 = df2.append({'one': 'this', 'two': 'that', 'three': 'something else'}, ignore_index=True)
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
# more dictionaries / JSON
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
# Specify Index column
df = pd.read_csv("your_file.csv", index_col='col_1')
# df with specific columns from file
df = pd.read_csv("your_file.csv", index_col='col_1', usecols=['col_1', 'col_2'])
# To see the column names
df.columns
# To see distinct values
df['col_1'].unique()
# For high level summary - mean, max, min, std_dev, percentiles
df.describe()
# To drop columns
df.drop(['col_1', 'col_2'], axis=1)
# To rename columns
df.rename(columns={'col_1': 'column_1', 'col_2': 'column_2'})
# To rename column
df = df.assign('col_2'='col_1')
# select col_1
df.col_1 """ or """ df['col_1']
# select col_1, col_2
df[['col_1', 'col_2']]
# select avg(col_1)
df['col_1'].mean()
# select max(col_1)
df['col_1'].max()
# select count(distinct col_01)
len(pd.unique(df2['col_01']))
# multiply 2 columns
df['col_1'] * df['col_2']
# If column is identified as object (not number), try using - 
pd.to_numeic(df['col_1'], errors='coerce')
# coerce --> To ignore errors
    
# Filters
# select * from df where col_1 > 100
df[df.col_1 > 100]
# Get row with max col_1
df[df.col_1 == df['col_1'].max()]
# select count(col_1) where col_1 = 'this'
df['two'].value_counts()['this']
# select count(col_2) where col_1 = 'this'
df2 = df[df['col_1'] == 'this']
df2['col_2'].value_counts()

# Groups
# select sum(numerical columns) from df group by col_1
df.groupby(['col_1']).sum()
# select sum(numerical columns) from df group by col_1, col_2
df.groupby(['col_1', 'col_2']).sum()

# Joins
# Inner Join
pd.merge(df1, df2, on='col_1')
# In case column names are different
pd.merge(df1, df2, left_on='col_1', right_on='column_1')
# To join on multiple columns
pd.merge(df1, df2, on=['col_1', 'col_2'])
# To join on index
pd.merge(df1, df2, left_index=True, right_on='col_1')
# Note: If a join is done between an index and a column, the merge will carry the index from the DF that used the column
# To see if the resultant rows are present in both tables or just 1
pd.merge(df1, df2, on='col_1', indicator=True)
# Left Join
pd.merge(df1, df2, on='col_1', how='left')
# Right join
pd.merge(df1, df2, on='col_1', how='right')
# To validate 1-m / m-1 / 1-1 / m-m (Throws an exception if validation fails)
pd.merge(df1, df2, on='col_1', validate='1:m')
# If DFs have the same index, you can join multiple DFs using - 
df1.join([df2, df3])

# Index
df.loc[row_index, col_index]
# row_index is by default --> 0, 1, 2, ..
# To specify a particular column as Index:
df = read_csv("this_file.csv", index='this_column')
# col_index is the column name
# If column_index = ":" --> Get all columns
df.iloc[10:10, [0,3]]
# Gets rows 10 to 20 and columns # 1 and 4

# Graphs
# bar graph with counts by col_1
pd.value_counts(df['col_1']).plot.bar()

# More
# serialize object to file
df.to_pickle(file.pkl)
# Read from pickle
pd.read_pickle(file.pkl)
# To HDFS
df.to_hdf('data.h5', key='df', mode='w')
# Read from HDFS
pd.read_hdf('data.h5', 'df')
# To CSV
df.to_csv(index=False)
