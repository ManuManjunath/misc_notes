"""
Simple scrapper of an amazon product
"""

import requests
from bs4 import BeautifulSoup
import re

#URL = 'https://www.amazon.in/Kodak-inches-Smart-43FHDXPRO-Black/dp/B081B8TRGF/'
URL = 'https://www.amazon.in/Sony-inches-Bravia-Android-KDL-43W800D/dp/B01CE4FXUG/'
header = {"User-Agent": 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_5) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/81.0.4044.122 Safari/537.36'}

response = requests.get(URL, headers=header, verify=False)

soup = BeautifulSoup(response.content, 'html.parser')
availability = soup.find(id='availability').get_text()

if "In stock" in availability:
    print("Its available. Lets check the price")
    price = soup.find(id='priceblock_ourprice').get_text()
    # Remove currency sign and comma
    price_float = float(re.sub(',', '', price[1:].strip()))
    print("Item is priced at:", price_float)
else:
    print("Wait. It's not available yet.")
