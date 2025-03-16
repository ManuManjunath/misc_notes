##### Databases - data set in a particular database cannot be accessed by other databases
##### Chnge databases using select
```
127.0.0.1:6379> select 0
OK
127.0.0.1:6379> set name manu
OK
127.0.0.1:6379> select 1
OK
127.0.0.1:6379[1]> get name
(nil)
127.0.0.1:6379[1]> select 0
OK
127.0.0.1:6379> get name
"manu"
```
