# Redis

To start redis server: 
```redis-server```

Start redis cli and test
```
$ redis-cli
127.0.0.1:6379> ping
PONG
```

##### To view all config values
```
127.0.0.1:6379> config get *
```
##### To view specific config values, enter the key
```
127.0.0.1:6379> config get maxclients
1) "maxclients"
2) "10000"
```
##### To update a specific config value
```
127.0.0.1:6379> config get 5000
OK
```
##### To get all system info
```
127.0.0.1:6379> info
```
##### To get specific info
```
127.0.0.1:6379> info Server
or
127.0.0.1:6379> info CPU
or
127.0.0.1:6379> info Memory
```
