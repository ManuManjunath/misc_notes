# get_api.py
from flask import Flask, jsonify, request
import requests

app = Flask(__name__)

mytest = [{'Type': 'Decimal',
           'One': 1,
           'Two': 2,
           'Three': 3,
           'Four': 4
          },
          {'Type': 'Roman',
           'One': 'I',
           'Two': 'II',
           'Three': 'III',
           'Four': 'IV'
          }
         ]

# For a simple JSON
@app.route('/mytest')
def simple():
    return jsonify({'numbers': mytest})

# JSON with filters
@app.route('/mytest/<string:Type>')
def simple_filter(Type):
    return_value = {}
    for i in mytest:
        if mytest['Type'] == Type:
           return_value = {'One': mytest['One'],
                           'Two': mytest['Two'],
                           'Three': mytest['Three']
                          }
    return jsonify(return_value)

app.run(port=5000)


# testing_get.py

url = 'http://127.0.0.1:4321'
a = requests.get(url).json()
print(a)
b = requests.get(url+'/Decimal').json()
print(b)



# put_api.py


app = Flask(__name__)

mytest = [{'Type': 'Decimal',
           'One': 1,
           'Two': 2,
           'Three': 3,
           'Four': 4
          },
          {'Type': 'Roman',
           'One': 'I',
           'Two': 'II',
           'Three': 'III',
           'Four': 'IV'
          }]

new_data = {'Type': 'Binary',
            'One': 1,
            'Two': 10,
            'Three': 11,
            'Four': 100              
           }

@app.route('/mytest', methods=['POST'])
def add_new():
    new_data = request.get_json()
    mytest.insert(0, new_data)
    return jsonify(new_data)

print(mytest)

res = requests.post('http://127.0.0.1:4321/Binary', json={"One": 1, "Two": 10, "Three": 11, "Four": 100})
if res.ok:
    print(res.json())
    
print(mytest)
