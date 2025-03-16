### Sets - unordered and unique elements
##### To create a set
```
127.0.0.1:6379> sadd country India
(integer) 1
127.0.0.1:6379> sadd country China
(integer) 1
127.0.0.1:6379> sadd country Spain
(integer) 1
```
##### To view the members
```
127.0.0.1:6379> smembers country
1) "India"
2) "China"
3) "Spain"
```
##### To check if an element is present in set - 0 is false and 1 is true
```
127.0.0.1:6379> sismember country USA
(integer) 0
127.0.0.1:6379> sismember country Spain
(integer) 1
```
##### To get number of elements in set
```
127.0.0.1:6379> scard country
(integer) 3

```
##### Try to add a duplicate and it returns 0
```
127.0.0.1:6379> sadd country India
(integer) 0
```
##### To remove an element
```
127.0.0.1:6379> srem country China
(integer) 1
127.0.0.1:6379> smembers country
1) "Spain"
2) "India"
```
##### Difference between 2 sets
```
127.0.0.1:6379> sadd countries India China "Sri Lanka" France Germany USA UAE
(integer) 7
127.0.0.1:6379> sadd asia India China Korea "Sri Lanka" UAE Japan
(integer) 6
127.0.0.1:6379> sdiff countries asia
1) "USA"
2) "Germany"
3) "France"
```
##### Store this difference in a new set
```
127.0.0.1:6379> sdiffstore newset countries asia
(integer) 3
127.0.0.1:6379> smembers newset
1) "USA"
2) "Germany"
3) "France"
```
##### Common elements between 2 sets
```
127.0.0.1:6379> sinter countries asia
1) "India"
2) "Sri Lanka"
3) "China"
4) "UAE"
127.0.0.1:6379> sinterstore intersect countries asia
(integer) 4
127.0.0.1:6379> smembers intersect
1) "India"
2) "China"
3) "UAE"
4) "Sri Lanka"
```
##### Union of 2 sets
```
127.0.0.1:6379> sunion countries asia
1) "France"
2) "China"
3) "Germany"
4) "UAE"
5) "Korea"
6) "India"
7) "USA"
8) "Sri Lanka"
9) "Japan"
127.0.0.1:6379> sunionstore union countries asia
(integer) 9
127.0.0.1:6379> smembers union
1) "France"
2) "China"
3) "Germany"
4) "UAE"
5) "Korea"
6) "India"
7) "USA"
8) "Sri Lanka"
9) "Japan"
```

##### Sorted Sets
```
127.0.0.1:6379> zadd cities 1 Bangalore
(integer) 1
127.0.0.1:6379> zadd cities 2 Mumbai
(integer) 1
127.0.0.1:6379> zadd cities 3 Chennai
(integer) 1
127.0.0.1:6379> zadd cities 4 Kolkotta
(integer) 1
127.0.0.1:6379> zadd cities 5 Delhi
(integer) 1
127.0.0.1:6379> zadd cities 5 Bhopal
(integer) 1
127.0.0.1:6379> zrange cities 0 -1
1) "Bangalore"
2) "Mumbai"
3) "Chennai"
4) "Kolkotta"
5) "Bhopal"
6) "Delhi"
```
##### To update
```
127.0.0.1:6379> zadd cities 3 Hyderabad
(integer) 1
127.0.0.1:6379> zrange cities 0 -1
1) "Bangalore"
2) "Mumbai"
3) "Chennai"
4) "Hyderabad"
5) "Kolkotta"
6) "Bhopal"
7) "Delhi"
```
##### Check the number of elements
```
127.0.0.1:6379> zcard cities
(integer) 7
```
##### To remove an element
```
127.0.0.1:6379> zrem cities Bhopal
(integer) 1
```
##### To remove elements by position - give start and end position
```
127.0.0.1:6379> zremrangebyrank cities 0 2
(integer) 3
127.0.0.1:6379> zrange cities 0 -1
1) "Hyderabad"
2) "Kolkotta"
3) "Delhi"
```
##### To view elements in reverse order
```
127.0.0.1:6379> zrevrange cities 0 -1
1) "Delhi"
2) "Kolkotta"
3) "Chennai"
4) "Hyderabad"
5) "Mumbai"
6) "Bangalore"
```
##### To get the position of an element
```
127.0.0.1:6379> zscore cities Bangalore
"1"
```
