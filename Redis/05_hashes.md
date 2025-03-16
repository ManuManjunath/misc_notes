### Hashe - Like a json but without any nesting
##### To create
```
127.0.0.1:6379> hset person name Manu
(integer) 1
127.0.0.1:6379> hget person name
"Manu"
127.0.0.1:6379> hset person age 33
(integer) 1
127.0.0.1:6379> hset person location Bangalore
(integer) 1
127.0.0.1:6379> hgetall person
1) "name"
2) "Manu"
3) "age"
4) "33"
5) "location"
6) "Bangalore"
```
##### To delete
```
127.0.0.1:6379> hdel person location
(integer) 1
127.0.0.1:6379> hget person location
(nil)
```
##### To check if a key exists - 1 is true and 0 is false
```
127.0.0.1:6379> hexists person location
(integer) 0
```
##### To update a value
```
127.0.0.1:6379> hset person age 34
(integer) 0
127.0.0.1:6379> hgetall person
1) "name"
2) "Manu"
3) "age"
4) "35"
127.0.0.1:6379> hincrby person age 2
(integer) 37
127.0.0.1:6379> hincrbyfloat person age 2.5
"37.5"
```
##### To check the length (number of key-value pairs in the hash)
```
127.0.0.1:6379> hlen person
(integer) 2
```
##### To retrieve multiple values, you can also specify the keys
```
127.0.0.1:6379> hmget person name age
1) "Manu"
2) "37"
```
##### Get length of a value
```
127.0.0.1:6379> hstrlen person name
(integer) 4
```
##### To set only if key does not exist already - 1 if successful, 0 if fails
```
127.0.0.1:6379> hsetnx person name someoneelse
(integer) 0
127.0.0.1:6379> hgetall person
1) "name"
2) "Manu"
3) "age"
4) "37.5"
5) "location"
6) "Bangalore"
127.0.0.1:6379> hsetnx person email something@domain.com
(integer) 1
127.0.0.1:6379> hgetall person
1) "name"
2) "Manu"
3) "age"
4) "37.5"
5) "location"
6) "Bangalore"
7) "email"
8) "something@domain.com"
```
