#!/bin/bash

MAIL="yourmail@enterprise.com"
wrk_dir=/path/to/script

systemctl status httpd | head -n +3 | tail -n 1 > $wrk_dir/chk_sts_1.txt
sts=`sed 's/(/)/g' $wrk_dir/chk_sts_1.txt | cut -d')' -f2`
sts_r="running"

if 
    ( [ "$sts" != $sts_r ] )
then
    systemctl start httpd
    sleep 10
    systemctl status httpd | head -n +3 | tail -n 1 > $wrk_dir/chk_sts_2.txt
    sts2=`sed 's/(/)/g' $wrk_dir/chk_sts_2.txt | cut -d')' -f2`
        if ( [ "$sts2" != $sts_r ] )
        then
            echo "HTTPD service $HOSTNAME is down. Unable to auto restart" > $wrk_dir/output.txt
            mailx -s "Alert from $HOSTNAME" $MAIL < $wrk_dir/output.txt
        else
            echo "HTTPD service $HOSTNAME was down and it was auto restarted" > $wrk_dir/output.txt
            mailx -s "Alert from $HOSTNAME" $MAIL < $wrk_dir/output.txt
        fi
else
    echo "HTTP service running on $HOSTNAME" > $wrk_dir/output.txt
fi
