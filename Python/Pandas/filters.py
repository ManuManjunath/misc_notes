# select * from df where col_1 = 'this'
df[df['col_1'] == 'this']

# select * from df where col_2 > 100
df[df['col_1'] > 100]

# Select row with max col_1
df[df.col_1 == df['col_1'].max()]

# select count(col_1) where col_1 = 'this'
df['two'].value_counts()['this']

# select count(col_2) where col_1 = 'this'
df2 = df[df['col_1'] == 'this']
df2['col_2'].value_counts()

# select * from df where col_1 = 'this' and 'col_2' = 'that'
df[(df['col_1'] == 'this') & (df['col_2'] == 'that')]

# select * from df where col_1 = 'this' or 'col_2' = 'that'
df[(df['col_1'] == 'this') | (df['col_2'] == 'that')]

# select * from df where col_1 is null
df[df['col_1'].isna()]

# select * from df where col_1 is not null
df[df['col_1'].notna()]
