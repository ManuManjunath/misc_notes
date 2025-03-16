const items = [
    {
        name: 'Bike', price: 100
    },
    {
        name: 'TV', price: 60
    },
    {
        name: 'Album', price: 10
    },
    {
        name: 'Phone', price: 50
    },
    {
        name: 'Car', price: 250
    },
    {
        name: 'Computer', price: 150
    },
    {
        name: 'Book', price: 8
    }
]

// Filter method
// Returns a filtered array after applying the conditions
const filteredItems = items.filter((item) => item.price <= 100)
console.log(filteredItems)

// Map method
// Returns a new array with the function applied on each element
const itemNames = items.map((item) => item.name)
console.log(itemNames)

// find method
// Gets specific object based on condition
const searchItem = items.find((item) => item.name === 'Book')
console.log(searchItem)

// some method
// Checks if atleast one element passes the test
const isCheapItem = items.some((item) => item.price <= 10)
console.log(isCheapItem)
// Returns true because atleats one of those items is < 10

// foreach method - Double the price
// Iterates over the elements and applies function
items.forEach((item) => {
    console.log(item.price * 2)
})