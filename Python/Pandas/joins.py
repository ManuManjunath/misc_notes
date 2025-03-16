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
