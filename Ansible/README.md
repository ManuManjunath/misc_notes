# AnsibleTest

Testing simple playbooks - 

## To install ##
Debian system --     `$ sudo apt-get install ansible`

Centos system --     `$ sudo yum install epel-release` and `$ sudo yum install ansible`

Using PIP  --        `$ sudo pip install ansible`


####Next steps#### - test with module parametrers, include, register, tempates, when condition

To run - 
`absible-playbook playbooks/sample.yml`

To run a single module without playbook - 
`ansible <server> -i <inventory_file> -u <user> -m <module> -k <prompt for password> -v`

i --> inventory file, m --> module, u --> username, k --> prompt for password, a --> pass parameters for a module within "<here", v --> verbose debug (vv / vvv --> debug level 2/3)

`--sudo` --> To run as sudo

### Modules ###

To list all the available modules - `ansible -doc -l`

To get more details on a specific module - `ansible-doc <name>`

To get a playbook example - `ansible-doc -s <name>`
