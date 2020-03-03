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

# Groups
# select sum(numerical columns) from df group by col_1
df.groupby(['col_1']).sum()
# select sum(numerical columns) from df group by col_1, col_2
df.groupby(['col_1', 'col_2']).sum()


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
