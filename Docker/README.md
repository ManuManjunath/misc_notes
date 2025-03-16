# docker_notes

docker container run -d --name web -p 8080:8080 user/image:1
>> You get a unique ID
^^ Started a web server
Stop it -  docker stop web
Start it - docker container start web
d - start container in detach mode (open in background)

docker run -it --name temp ubuntu:latest /bin/bash
^ Runs Ubuntu container in interactive mode
Runs bash on it

Exit the above Ubuntu containr without killing it - 
Ctrl P+Q


docker image build -t  user/image:2 .

Go to hub.docker.com and see all images

Create new container - 
docker run hello-world

Images ~ Stopped Containers
Containers ~ Running Images

docker pull alpine
docker pull ubuntu
^^ Pulls latest Images without starting the container
to pull older version - docker pull ubuntu 14.04

docker build -t name:version .

docker exec -it ImageName:version bash

docker cp files container /path/to/file

To build docker image from a Dockerfile
docker image build -t given_name .![image](https://user-images.githubusercontent.com/52904203/179686247-02c35636-599e-4e09-ab9c-bb59f288e5fe.png)


Other commands

docker version
docker info
docker images
docker ps
^^ Shows all running containers
docker ps -a
List - docker images ls

To remove - 
docker rmi imageName

Push to doker hub - 
docker image push user/image

Only show the Image ID - 
docker ps -aq

docker rm name
removes the container

Install docker on Linux - 
wget -q0- https://get.docker.com/ | sh![image](https://user-images.githubusercontent.com/52904203/179686265-27b00c9a-29f0-4fbf-9f11-900012af0131.png)


Swarm
Needs Docker 1.12 and above
Swarm = a collection of docker engines in a cluster
Engines in a Swarm run in Swarm mode
Manager nodes and worker nodes
Recommended - 3 or 5 manager nodes
Service is a declarative way of running and scaling tasks
Services work only in service mode

Create a service 
docker service create --name web-fe --replica 5
^^ Will always have 5 tasks or 5 containers![image](https://user-images.githubusercontent.com/52904203/179686290-a075f89e-e4ed-434d-a09d-a3a7c3357016.png)


Build a swarm - 3 managers and 3 workers
Go to Manager 1 node and initialize swarm
docker swarm init --advertise-addr IP_addr_MGR1:2377 --listn-addr IP_addr_MGR1:2377
Same IP_address for advertise and listner
2377 - swarm port
^^ Makes this IP as the manager
Also displays a token you can use to join other nodes to the swarm
docker swarm join \ --token xxxx \ IP_adde:2377
To add a manager to this swarm - Copy the token
docker swarm join-token manager
To add worker - Copy the token
docker swarm join-tocken worker
Add manager - 
docker swarm join \
 --token XXX_MANAGER_TOKEN_XXX \
IP_ADDR_MGR1:2377
 --advertise-addr IP_addr_MGR2:2377 \
 -- liten-addr IP_addr_MGR2:2377
To validate - docker node ls
Add worker - 
docker swarm join \
 --token XXX_MANAGER_TOKEN_XXX \
IP_ADDR_MGR1:2377
 --advertise-addr IP_addr_MGR3:2377 \
 -- liten-addr IP_addr_MGR3:2377
To promote worker to manager - docker node promote IMAGE_ID <or IP>
Add worker - 
docker swarm join \
 --token XXX_WRK_XXX \
IP_addr_MGR1:2377
 --advertise-addr IP_addr_WRK1:2377 \
 -- liten-addr IP_addr_WRK1:2377
To validate - docker node ls![image](https://user-images.githubusercontent.com/52904203/179686314-8b4331f1-480b-4070-9399-be0171eeafb2.png)

Services
Create new
docker service create --name giveName -p 8080:8080 --replicas 5 user/service
Check if its created
docker service ls
Check configurations
docker service inspect![image](https://user-images.githubusercontent.com/52904203/179686343-490585af-85af-47f3-b46f-584a7eea6427.png)
