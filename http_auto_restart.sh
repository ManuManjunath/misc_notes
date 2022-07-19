#!/bin/bash

MAIL=""
wrk_dir=/var/scripts/chk_sts

service httpd status | head -n +3 | tail -n 1 > $wrk_dir/chk_sts_1.txt
sts=`sed 's/(/)/g' $wrk_dir/chk_sts_1.txt | cut -d')' -f2`
sts_r="running"

if 
    ( [ $sts != $sts_r ] )
then
    service httpd start
    sleep 10
    service httpd status | head -n +3 | tail -n 1 > $wrk_dir/chk_sts_2.txt
    sts2=`sed 's/(/)/g' $wrk_dir/chk_sts_2.txt | cut -d')' -f2`
        if ( [ $sts2 != $sts_r ] )
        then
            echo "HTTPD service on server $HOSTNAME is down. Unable to auto restart" > $wrk_dir/output.txt
            curl -X POST --data "{\"text\": \"HTTPD service on server $HOSTNAME is down. \nUnable to auto restart\"}" https://hooks.slack.com/services/ID/ID/ID
            mailx -s "Alert from Node" $MAIL < $wrk_dir/output.txt
        else
            echo "HTTPD service on server $HOSTNAME was down and it was auto restart" > $wrk_dir/output.txt
            curl -X POST --data "{\"text\": \"HTTPD service on server $HOSTNAME was down and it was auto restart\"}" https://hooks.slack.com/services/ID/ID/ID
            mailx -s "Alert from Node" $MAIL < $wrk_dir/output.txt
        fi
else
    echo "HTTP service running on $HOSTNAME" > $wrk_dir/output.txt
fi
