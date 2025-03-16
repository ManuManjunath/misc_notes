# insert into df
df.append({'col_1': 'value', 'col_2': 'value'}, ignore_index=True)

# Insert using series
df.append(pd.Series((['Col_1_value', 'Col_2_value'], index=df.columns), ignore_index=True))

# Insert from another df -
df.append(df2, ignore_index=True)

# Insert specific row from another def -
df.append(df2.loc[10], ignore_index=True)

# update df set col_1 = col_1 * 5 where col_1 < 2
df.loc[df['col_1'] < 2, 'col_1'] *= 5

# delete from df where col_1 > 10
df = df.loc[df['col_1'] <= 10]

# To drop columns
df.drop(['col_1', 'col_2'], axis=1)
# To rename columns
df.rename(columns={'col_1': 'column_1', 'col_2': 'column_2'})

# Remove duplicates
df.drop_duplicates(inplace=True)

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

# To check the memory occupied by your Data Frame
def mmry(df):
    print("{0:2f} MiB".format(
        df.memory_usage().sum() / (1024 * 1024)
    ))

mmry(your_df)

# Long vs Wide data formats
"""
long = 
Year    Dept    Sales
----    ----    -----
2001    Books   1200
2001    Music   1500
2001    Clothes 2000
2002    Books   900
2002    Music   1100
2002    Clothes 1900
2003    Books   1300
2003    Music   1600
2003    Clothes 2200

VS
wide = 
Dept        2001    2002    2003
----        ----    ----    ----
Books       1200    900     1300
Music       1500    1100    1600
Clothes     2000    1900    2200  
"""

# Long to Wide
wide = long.pivot(index='Dept', columns='Year', values='Sales')

# Wide to Long
# First reset index
wide = wide.reset_index()
wide.columns.name = None
# Now convert to Long
long2 = wide.melt(id_vars='Dept')
# Use (value_vars=[list of specific categories only]) for filter

# To control the max number of rows and columns displayed-
pd.set_option('display.max_columns', 20)
pd.set_option('display.max_rows', 2000)

# To rename columns - 
df.columns
# Index(['col_1', 'col_2', 'col_3'], dtype='object')
df.columns = ['column_1', 'column_2', 'column_3']
df.columns
# Index(['column_1', 'column_2', 'column_3'], dtype='object')
# To rename a specific column name
df.rename(columns={'column_1': 'col_1', 'column_2': 'col_2'})
