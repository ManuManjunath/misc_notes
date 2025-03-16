##### transactions start with "multi"
```
127.0.0.1:6379> multi
OK
127.0.0.1:6379(TX)> set name Manu
QUEUED
127.0.0.1:6379(TX)> get name
QUEUED
127.0.0.1:6379(TX)> set a 1
QUEUED
127.0.0.1:6379(TX)> set b 2
QUEUED
127.0.0.1:6379(TX)> exec
1) OK
2) "Manu"
3) OK
4) OK
```
##### To discard a transaction
```
127.0.0.1:6379> multi
OK
127.0.0.1:6379(TX)> set a 1
QUEUED
127.0.0.1:6379(TX)> hset person name Manu age 33 location Bangalore
QUEUED
127.0.0.1:6379(TX)> hgetall person
QUEUED
127.0.0.1:6379(TX)> discard
OK
127.0.0.1:6379> hgetall person
(empty array)
```
##### Conditional transactions - based on watch
``` 
WIP 
```
