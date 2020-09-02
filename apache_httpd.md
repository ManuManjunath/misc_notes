To install - 
```yum install httpd```

To start service - 
``` service httpd start```

To check status - 
```systemctl status httpd```
 or - 
 ```ps -ef | grep httpd```

or to check if the service is listening - 
```lsof -i | grep http```

or open the UTl - ```http://localhost``` to see the default page
