# update df set col_1 = col_1 * 5 where col_1 < 2
df.loc[df['col_1'] < 2, 'col_1'] *= 5
# Update all column values for a given row -
df.iloc[2] = ['col_1_value', 'col_2_valye', 'col_3_value']
# To update a specific column value for a given row -
df.iloc[2, 1] = 'column_1_value'
# update df set col_1 = 'this' where col_2 = 'that'
fltr = (df['col_2'] == 'that')
df.loc[fltr, 'col_1'] = 'this'

# Update all values of a column to lower case -
df['col_1'] = df['col_1'].str.lower()
# You can also use "Apply"
# Apply - applies a function to every value
# Apply on a series -
df['col_1'].apply(len)
# ^^ Counts the number of characters for each value in col_1
# Using Apply to update values of a column -
def make_upper(col_1):
    return col_1.upper()
df['col_1'] = df['col_1'].apply(make_upper)
# Using lambda functions -
df['col_1'] = df['col_1'].apply(lambda x: x.lower())
# To update using replace -
df['col_1'] = df['col_1'].replace({'original1': 'new1', 'original2': new2})
