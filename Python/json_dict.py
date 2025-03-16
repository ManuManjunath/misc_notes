import json

JsonFile = open("JsonFile.txt", 'r')
dict = json.load(JsonFile)
JsonFile.close()
print(dict)

#Convert back to Json - 
JsonFile2 = open("JsonFile2.txt", 'w')
json.dump(dict, JsonFile2)
JsonFile.close()
