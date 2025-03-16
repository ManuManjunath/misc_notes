### Lists:
##### Get all the keys added so far
```
127.0.0.1:6379> keys *
1) "name"
2) "fullname"
3) "longstr"
4) "fname"
5) "lname"
6) "location"
7) "count"
8) "pi"
```
##### To clear all keys
```
127.0.0.1:6379> flushall
OK
127.0.0.1:6379> keys *
(empty list or set)
```
##### Create a new list
##### lpush adds elements in the beginning of the list
```
127.0.0.1:6379> lpush country India
(integer) 1
127.0.0.1:6379> lpush country Kenya
(integer) 2
127.0.0.1:6379> lpush country France
(integer) 3
127.0.0.1:6379> rpush country Australia
(integer) 4
```
##### Retrieve full list
127.0.0.1:6379> lrange country 0 -1
1) "France"
2) "Kenya"
3) "India"
4) "Australia"
##### Get length of a list
```
127.0.0.1:6379> llen country
(integer) 4
```
##### Remove elements by position using lpop / rpop (Removes from right and left end)
```
127.0.0.1:6379> lpop country
"France"
127.0.0.1:6379> rpop country
"Australia"
127.0.0.1:6379> lrange country 0 -1
1) "Kenya"
2) "India"
```
##### Update a value by key
```
127.0.0.1:6379> lset country 0 "Sri Lanka"
OK
127.0.0.1:6379> lgange country 0 -1
1) "Sri Lanka"
2) "India"
```
##### To insert values
```
127.0.0.1:6379> linsert country before India Germany
(integer) 3
127.0.0.1:6379> linsert country after India China
(integer) 4
127.0.0.1:6379> lrange country 0 -1
1) "Sri Lanka"
2) "Germany"
3) "India"
4) "China"
```
### To retrieve elements by index (Index starts at 0)
```
127.0.0.1:6379> lindex country 3
"China"
```
##### To sort alphabetically
```
127.0.0.1:6379> sort country ALPHA
1) "China"
2) "Germany"
3) "India"
4) "Sri Lanka"
127.0.0.1:6379> sort country desc ALPHA
1) "Sri Lanka"
2) "India"
3) "Germany"
4) "China"
```
##### Add element to list ONLY if list exists
```
127.0.0.1:6379> lpushx city Bangalore
(integer) 0
127.0.0.1:6379> rpushx city Mumbai
(integer) 0
127.0.0.1:6379> lrange city 0 -1
(empty array)
```
##### WIP - blpop / brpop
