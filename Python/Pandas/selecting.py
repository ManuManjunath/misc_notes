# To see the number of rows and columns
df.shape

# See columns in df
df.columns

# select * from df
df

# For high level summary - mean, max, min, std_dev, percentiles
df.describe()

# select col_1, col_2 from df
df['col_1', 'col_2']

# select distinct col_1 from df
df['col_1'].unique()

# select avg(col_1)
df['col_1'].mean()

# select max(col_1)
df['col_1'].max()

# select count(distinct col_01)
len(pd.unique(df2['col_01']))

# select col_1 * col_2 from df
df['col_1'] * df['col_2']
# If column is identified as object (not number), try using -
pd.to_numeic(df['col_1'], errors='coerce')
# coerce --> To ignore errors

# select *, col_1/col_2 as new_col from df
df.assign(new_col=df['col_1'] / df['col_2'])

# select * from df limit 5
df.head(5)

# To see the last 5 rows
df.tail()

# To see rows 2 to 4
df(2:5)

# select * from df1 union all select * from df2
pd.concat([df1, df2])

# select * from df1 union select * from df2
pd.concat([df1, df2]).drop_duplicates()
