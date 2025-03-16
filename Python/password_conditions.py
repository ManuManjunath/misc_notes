import re

pwd = input("Enter a password")

"""
Conditions:
-----------
6 to 10 characters long,
Upper case
Lower case
Number
Special character
"""

sp_char = re.compile('[@_!#$%^&*()<>?/\|}{~:]')

if len(pwd) < 6 or len(pwd) > 10:
    print("Password needs to be 6 to 10 characters long")
elif not any(char.isdigit() for char in pwd):
    print("Password needs to have atleast one number")
elif not any(char.isupper() for char in pwd):
    print("Password needs to have atleast one upper case letter")
elif not any(char.islower() for char in pwd):
    print("Password needs to have atleast one lower case letter")
elif sp_char.search(pwd) == None:
    print("Password needs to have atleast one special character")
else:
    print(f"Password accepted")
