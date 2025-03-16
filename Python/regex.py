import re
Nameage = "Gabriel is 44, Joey is 21, Janice is 22 and Theon is 33"

ages = re.findall(r'\d{1,3}', Nameage)
names = re.findall(r'[A-Z][a-z]*', Nameage)
ageDict = {}
x = 0
for eachname in names:
    ageDict[eachname] = ages[x]
    x+=1
print(ageDict)
