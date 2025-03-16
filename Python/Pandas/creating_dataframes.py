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
# Create df from another df - copy certain rows and columns
df2 = df.iloc[0:4, :].copy()
# ^^ Copies all columns for 5 rows starting 1st row
# Specify Index column
df = pd.read_csv("your_file.csv", index_col='col_1')
# df with specific columns from file
df = pd.read_csv("your_file.csv", index_col='col_1', usecols=['col_1', 'col_2'])
