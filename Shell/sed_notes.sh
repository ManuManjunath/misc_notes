# Open a file
sed -n 'p' filename.txt
# "-i"  edits the main file

# To delete lines that start with "ABC"
sed ' /^ABC/ d' file.txt
# ";" for multiple conditions

# To delete lines that start with "ABC" and clear empty lines
sed ' /^ABC/ d ; /^$/ d' file.txt
# "-i.bak" edits the main file & creates a backup
sed -i.bak ' /^ABC/ d ; /^$/ d' file.txt

# To replace string text within a file
sed -i 's/original/new/g' file.txt

# To show all lines in a file that contain "string"
sed -n ' /string/ p' filename

# To search for lines that contain either AA or BB
sed -n ' /AA/ p ; /BB/ p' sample.txt

# To search for lines in a file that start with - "Simple"
sed -n ' /^Simple/ p' file.txt
# $ = end of line, ^ = beginning of line
