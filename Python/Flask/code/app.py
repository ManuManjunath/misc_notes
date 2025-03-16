import psycopg2
from flask import Flask, request
from flask_restful import Resource, Api, reqparse

app = Flask(__name__)
api = Api(app)

db = 'postgresql://manu_Sandbox:<pwd>@pgclx20540:5432/manu_sandbox'
conn = psycopg2.connect(db)
cursor = conn.cursor()

# Start with an empty list of items
items = []

# Code for individual items
class Item(Resource):

    # parse the input JSON for PUT/POST using reqparse
    parser = reqparse.RequestParser()
    parser.add_argument(
        "price", type=float, required=True, help="This field is mandatory"
    )

    # get
    def get(self, name):
        # Return the requested item if exists
        for item in items:
            if item["name"] == name:
                return item, 200
        # If item doesn't exist, return None and 404 - Not Found
        return {"item": None}, 404
        # or
        # item = next(filter(lambda x: x['name'] == name, items), None)
        # return {'item' : item}, 200 if item else 404

    # post
    def post(self, name):
        # Do not accept if item already exists. Return 400 - Bad request
        for item in items:
            if item["name"] == name:
                return {"message": "Item with name " + name + " already exists"}, 400
        # Get data from the input JSON
        data = Item.parser.parse_args()
        # Get the price of the item
        item = {"name": name, "price": data["price"]}
        # Add to our list of items
        items.append(item)
        return item, 201

    # put
    def put(self, name):
        # PUT can take existing entries unlike POST
        # Get data from the input JSON
        data = Item.parser.parse_args()
        # Check if the item already exists
        item = next(filter(lambda x: x["name"] == name, items), None)
        if item is None:
            # Item does not exist - Append to the list
            item = {"name": name, "price": data["price"]}
        else:
            # Item already exists. Update.
            item.update(data)
        return item

    # delete
    def delete(self, name):
        # Use the items list definied outside
        global items
        # Recreate the list without the item to be deleted
        items = list(filter(lambda x: x["name"] != name, items))
        return {"message": "Item deleted"}


# Code for all items' list
class ItemList(Resource):
    # get
    def get(self):
        return {"items": items}


# Add end points
api.add_resource(Item, "/item/<string:name>")  # http://127.0.0.1:8000/item/<name>
api.add_resource(ItemList, "/items")  # http://127.0.0.1:8000/items

# Run on port 8000 and enable debug mode to view more details during run
app.run(port=8000, debug=True)
