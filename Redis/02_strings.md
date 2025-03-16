### Strings:
```
127.0.0.1:6379> set name Manu
OK
127.0.0.1:6379> get name
"Manu"
```
##### String with space
```
127.0.0.1:6379> set fullname "Manu Manjunath"
OK
```
##### Sub strings
```
127.0.0.1:6379> set longstr abcdefghijklmnop
OK
127.0.0.1:6379> get longstr 0 4
"abcde"
```
##### Set multiple strings
```
127.0.0.1:6379> mset fname Manu lname Manjunath location Bangalore
OK
127.0.0.1:6379> mget fname location
1) "Manu"
2) "Bangalore"
```
##### To get length of a string
```
127.0.0.1:6379> strlen location
(integer) 9
```
##### Get string length of a key that does not exist
```
127.0.0.1:6379> strlen abcde
(integer) 0
```
##### To increment/decrement a value
```
127.0.0.1:6379> set count 1
OK
127.0.0.1:6379> incr count
(integer) 2
127.0.0.1:6379> incrby count 10
(integer) 12
127.0.0.1:6379> decr count
(integer) 11
127.0.0.1:6379> decrby count 5
(integer) 6
```
##### Incrementing float values
```
127.0.0.1:6379> set pi 3.14
OK
127.0.0.1:6379> incrbyfloat pi 0.2
"3.34"
```
##### Check if a key exists - returns 1 if true
```
127.0.0.1:6379> exists pi
(integer) 1
127.0.0.1:6379> exists abcdefghij
(integer) 0
```
##### To delete a value
```
127.0.0.1:6379> del keyName
(integer) 1
```
##### To expire a value
```
127.0.0.1:6379> set a 10
OK
```
##### Expire this after 10 seconds
```
127.0.0.1:6379> expire a 10
(integer) 1
```
##### Check status of the key. Use ttl to see how many seconds are left to expire
```
127.0.0.1:6379> ttl a
(integer) 5
```
##### Check value after it expires
```
127.0.0.1:6379> get a
(nil)
```
##### To set a key with expiry
```
127.0.0.1:6379> setex country 10 India
OK
```
##### This will expire the key country with value India after 10 seconds
