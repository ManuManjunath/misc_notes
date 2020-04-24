"""
To see the arguments:
$ python3 filename.py -h
To do the calculation:
$ python3 filename.py --x=10 --y=4 --operation=Divide
"""

import argparse
import sys

def calc(args):
    if args.operation == 'Add':
        return args.x + args.y
    elif args.operation == 'Subtract':
        return args.x - args.y
    elif args.operation == 'Multiply':
        return args.x * args.y
    elif args.operation == 'Divide':
        if args.y == 0:
            return "Cannot divide by 0"
        else:
            return args.x / args.y
    else:
        return "Enter Add/Subtract/Multiply/Divide"

if __name__ == '__main__':
    parser = argparse.ArgumentParser(description='Calculation on 2 numbers')
    parser.add_argument('--x', type=float, default=1.0, help='Enter the 1st number')
    parser.add_argument('--y', type=float, default=1.0, help='Enter the 2nd number')
    parser.add_argument('--operation', type=str, default='Add', help='Add/Subtract/Multiply/Divide')
    # nargs
    args = parser.parse_args()
    sys.stdout.write(str(calc(args)))
    
    # operation = calc(7,3,'Divide')
    # print(operation)
