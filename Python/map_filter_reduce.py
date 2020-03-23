from functools import reduce

num = [1, 2, 3, 4, 5]

# Map - Apply function to all items on a list
def mapmap(a):
    return a % 2 == 0

# Filter - Create new list for items that meet certain criteria
def filfil(a):
    return a % 2 == 0

# Reduce - Performs computation on a list
def redred(a, b):
    return a + b

# Check results
print("Results for Map - ")
print(list(map(mapmap, num)))
print("Results for filter - ")
print(list(filter(filfil, num)))
print("Results for reduce - ")
print(reduce(redred, num))
