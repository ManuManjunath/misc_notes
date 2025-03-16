# select sum(numerical columns) from df group by col_1
df.groupby(['col_1']).sum()

# select sum(numerical columns) from df group by col_1, col_2
df.groupby(['col_1', 'col_2']).sum()
