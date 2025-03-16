"""
This may not be the ideal solution and might be lengthier than necessary.
However, I tried to code it in a way I personally think when solving Sudoku puzzles.
FYI - I cannot really solve super expert level puzzles.
I've listed my thought process below and tried to code it in a manner that I would solve manually.
1) Input board
    - Fill 0 for empty cells
2) Make 3 lists of lists of 9 rows / 9 columns / 9 sub-grids
3) Simple check - Check if any row / column / sub-grid is missing a single cell
    - Fill it up
4) Repeat step #3 until you cannot solve anymore.
5) Analyze the combination of (row, column, sub-grid) for empty cells.
    - If its one possible value, fill it up
6) Loop #5 until you cannot solve anymore.
7) Now stuck - a block can have 2 possible values?
    a) Enter one of the 2 possibilities
    b) Do steps #3, #4, #5
    c) Found an error?
    d) Change the number entered in #7-a
    f) Do step #7-b
8) Break - Stop code if > 100 steps are performed.
    - This is a placeholder to validate code.
9) If 2 empty cells can be one of 2 values, ignore these 2 values as possibilities for other empty cells.
    - Makes sense?
    - Too hard to code?
    - For expert level Sudoku
    - Same logic for 3 empty cells with one of 3 possible values
10) Still not solved?
    - Give up?
11) Final validation
    - Convert all lists to sets and validate if length == 9
Input list of rows to a pandas dataframe - easier to make list of columns and subgrids using iloc
"""

import pandas as pd

list_of_rows = [[0, 0, 0, 2, 6, 0, 7, 0, 1],
                [6, 8, 0, 0, 7, 0, 0, 9, 0],
                [1, 9, 0, 0, 0, 4, 5, 0, 0],
                [8, 2, 0, 1, 0, 0, 0, 4, 0],
                [0, 0, 4, 6, 0, 2, 9, 0, 0],
                [0, 5, 0, 0, 0, 3, 0, 2, 8],
                [0, 0, 9, 3, 2, 3, 4, 7, 4],
                [0, 4, 0, 0, 5, 0, 0, 3, 6],
                [7, 0, 3, 0, 1, 8, 0, 0, 0]
               ]

puzzle = pd.DataFrame(list_of_rows)
print("Here is the input sudoku puzzle")
print(puzzle)

required = [1, 2, 3, 4, 5, 6, 7, 8, 9]

col_1 = puzzle[0].to_list()
col_2 = puzzle[1].to_list()
col_3 = puzzle[2].to_list()
col_4 = puzzle[3].to_list()
col_5 = puzzle[4].to_list()
col_6 = puzzle[5].to_list()
col_7 = puzzle[6].to_list()
col_8 = puzzle[7].to_list()
col_9 = puzzle[8].to_list()

list_of_columns = [col_1, col_2, col_3, col_4, col_5, col_6, col_7, col_8, col_9]

# Sub-grids (3 * 3) start from top left to right and then to the bottom rows
sgrid_df_1 = puzzle.iloc[0:3, 0:3].values.tolist()
sgrid_df_2 = puzzle.iloc[0:3, 3:6].values.tolist()
sgrid_df_3 = puzzle.iloc[0:3, 6:9].values.tolist()
sgrid_df_4 = puzzle.iloc[3:6, 0:3].values.tolist()
sgrid_df_5 = puzzle.iloc[3:6, 3:6].values.tolist()
sgrid_df_6 = puzzle.iloc[3:6, 6:9].values.tolist()
sgrid_df_7 = puzzle.iloc[6:9, 0:3].values.tolist()
sgrid_df_8 = puzzle.iloc[6:9, 3:6].values.tolist()
sgrid_df_9 = puzzle.iloc[6:9, 6:9].values.tolist()
# values.to_list() --> This converts the sub-grid dataframe to a list of lists

sgrid_1 = [num for sublist in sgrid_df_1 for num in sublist]
sgrid_2 = [num for sublist in sgrid_df_2 for num in sublist]
sgrid_3 = [num for sublist in sgrid_df_3 for num in sublist]
sgrid_4 = [num for sublist in sgrid_df_4 for num in sublist]
sgrid_5 = [num for sublist in sgrid_df_5 for num in sublist]
sgrid_6 = [num for sublist in sgrid_df_6 for num in sublist]
sgrid_7 = [num for sublist in sgrid_df_7 for num in sublist]
sgrid_8 = [num for sublist in sgrid_df_8 for num in sublist]
sgrid_9 = [num for sublist in sgrid_df_9 for num in sublist]
#  [num for sublist in list_of_lists for num in sublist] --> This step flattens the list of lists

list_of_sgrids = [sgrid_1, sgrid_2, sgrid_3, sgrid_4, sgrid_5, sgrid_6, sgrid_7, sgrid_8, sgrid_9]

# Simple check - For single empty cells
all_lists = list_of_rows + list_of_columns + list_of_sgrids

def simple_check(list_items):
    """
    :parms: list of rows / columns / sub-grids
    :return: NA
    Note - Fills up cell value if the row / column / sub-grid has just one missing cell
    Note - This method will help fill up empty cells faster as the game proceeds
    """
    if list_items.count(0) == 1:
        position == list_items.index(0)
        missing_value = set(required) - set(list_items)
        list_items[position] = list(missing_value)[0]

for list_items in all_lists:
    simple_check(list_items)

# Combo check - 
# For a given empty cell, check the combination of row, column, sub-grid
# If it can have only 1 possible value, fill it up

def combo_check():
    # Get an empty cell
    # Find which row the empty cell belongs to
    # Find which column the empty cell belongs to
    # Find which subgrid the empty cell belongs to    
    # Check for possible values based on row
    # Check for possible values based on column
    # Check for possible values based on sub-grid
    # If the intersection of above 3 is one number, enter it.
    pass


# Miltiple possibilities
# Here we work on cells that can have multiple possible values

def multi_check():
    pass


# For validation
def FinalValidation(list_of_all_sets):
    """
    :parms: list of sets of rows, columns and sub-grids
    :return: True if all values are distinct, False if there are duplicates
    """
    for result in list_of_all_sets:
        if len(result) == 9:
            pass
        else:
            print("Som Ting Wong")
    
list_of_row_sets = [set(list_of_rows[0]),
                    set(list_of_rows[1]),
                    set(list_of_rows[2]),
                    set(list_of_rows[3]),
                    set(list_of_rows[4]),
                    set(list_of_rows[5]),
                    set(list_of_rows[6]),
                    set(list_of_rows[7]),
                    set(list_of_rows[8])
                   ]

list_of_col_sets = [set(col_1),
                    set(col_2),
                    set(col_3),
                    set(col_4),
                    set(col_5),
                    set(col_6),
                    set(col_7),
                    set(col_8),
                    set(col_9)
                   ]

list_of_sgrid_sets = []

list_of_all_sets = list_of_row_sets + list_of_col_sets + list_of_sgrid_sets

FinalValidation(list_of_all_sets)
