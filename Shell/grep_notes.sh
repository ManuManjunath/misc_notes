# Count the number of occurrences
grep -C ABCD file.txt

# To find number of occurances of a "string" in a file
grep -o 'String' filename | wc -l

# To find files with specific string:
grep -Ril "Signature Sales" /opt/scripts/prod
# R = recursive, i = ignore case
# l = stands for "show the file name, not the result itself".

# To show all lines in a file that contain "string"
cat filename | grep string

# To search for lines that contain either AA or BB
cat sample.txt | grep 'AA\|BB'

# To search for lines in a file that start with - "Simple"
cat file.txt | grep '^Simple'

# Reverse search - everything except searched item
cat file.txt | grep -v this

# Lists lines that start with One
grep '^One' file.txt
# Lists lines that end with One
grep 'One$' file.txt

# To find empty lines
grep '^$' file.txt
