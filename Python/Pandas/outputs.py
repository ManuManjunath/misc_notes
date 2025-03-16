# To excel -
df.to_excel("simple.xlsx")
df.to_excel("without_index.xlsx", index=False)
df.to_excel("specific_columns.xlsx", columns=["Col_1", "Col_2","Col_3"])

# For multiple worksheets in excel -
writer = pd.ExcelWriter('multiple_worksheets.xlsx', engine='xlsxwriter')
df.to_excel(writer, sheet_name="Sheet1")
df2.to_excel(writer, sheet_name="Sheet2")
writer.save()

# To JSON -
df.to_json('simple.json')
df.to_json('orients.json', orient='table / split / records / index / columns / values')
