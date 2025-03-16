line=a,b,c,d,e
echo $line
# a.b.c.d.e
echo $line | awk -F ',' '{print $1}'
# a
echo $line | awk -F ',' '{print $3}'
# c

# Open file
awk ' { print } ' file.txt

# Add header and last line
awk ' BEGIN { print "This is a file" } { print } END { print NR } ' new.txt
# NR is line number

# Add line numbers to file
awk ' { print NR , $0 } ' file.txt
# $0 means print the whole line

# Conditions
cat test.txt
Word1,1,Line1,100
Word2,2,Line2,200
Word3,2,Line1,100

awk -F "," ' { if ( $4 != "100" ) { $2 = 0 } print } ' test.txt
Word1,1,Line1,100
Word2 0 Line2 200
Word3,2,Line1,100

awk -F "," ' { if ( $4 != "100" ) { $2 = 0 } print } ' OFS="," test.txt
Word1,1,Line1,100
Word2,0,Line2,200
Word3,2,Line1,100
