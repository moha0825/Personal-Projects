# Lubna Mohamed Abdirahman, moha0825, Lab Section 011, HW 4

#==========================================
# Name: separate_int_and_str
# Purpose: Given a list of integer and strings, create two new lists. One
#   list will contain the integers and the other list will contain the strings.
# Precondition: The list will only contain ints and strings
# Input Parameter(s)
#       my_list: a list containing integers and strings
# Return Value(s)
#       -- if the input parameter is an empty list, return a list
#           with two empty lists: [ [ ], [ ] ]
#       -- else return a list with the 0th index position containing the
#           list of integers, and the 1st index position containing the
#           list of strings. If there are no ints or strings, return
#           an empty list in that position
#==========================================
def separate_int_and_str(mylist):
    integer = [ ]
    string = [ ]
    together = [integer, string]
    for i in mylist:
        if isinstance(i, str) == True:
            string.append(i)
        elif isinstance(i, int) == True:
            integer.append(i)
    if mylist == [ ]:
        return together 
    return together
    separate_int_and_str(mylist)

#==========================================
# Name: average_of_lists
# Purpose: Given a number of lists, create a list of sums from the separate lists. If the list
#   is empty, return an empty list. 
# Precondition: The list will only contain numbers 
# Input Parameter(s) 
#       average: a list containing the sum of different lists
# Return Value(s)
#       -- if the input parameter is an empty list, return a list
#           with an empty list
#       -- else return a list with the average of multiple lists 
#           separately, and if there are no integers, return an empty
#           list in that position.
#==========================================
def average_of_lists(mylist):
    average = [ ]
    if mylist == [ ]:
        return [ ]
    else:
        for i in mylist:
            average1 = round((sum(i))/(len(i)))
            average.append(average1) 
    return average

#==========================================
# Name: min_of_lists
# Purpose: Given a list of lists, find the minimum value of  
#   all of the lists combined. Do not use any built in functions. 
# Precondition: The list will contain the minimum value of any list in lists
# Input Parameter(s)
#       minimum: a list containing the minimum value in a list
# Return Value(s)
#       -- if the input parameter is an empty list, return an integer
#           0 (zero)
#       -- else return an integer that is the minimum value of any list        
#==========================================
def min_of_lists(mylist):
    if mylist == [ ]:
        return 0
    minimum = mylist[0][0]
    for i in mylist:
        for x in i:
            if x < minimum:
                minimum = x
    return minimum 

#==========================================
# Name: greater_than
# Purpose: Given a list of numbers, compare it to another integer
#   and if the number(x) is less than the list, return True.
# Precondition: 
# Input Parameter(s)
#       mylist: a list containing integers being compared to x
#       x: an integer 
# Return Value(s)
#       -- if the input parameter x is less than i, return True.
#       -- if the input parameter is an empty list, return True.
#       -- else return False, for an integer greater than those in the list
#==========================================
def greater_than(mylist,x):
    if mylist == []:
        return True 
    for i in mylist:
        if x < i:
            return True
        else:
            return False
        
#==========================================
# Name: selection_sort
# Purpose: Given a list, sort unarranged integers from least to greatest.
#   Reordered integers will then be presented as a result. 
# Precondition: The list will contain random integers 
# Input Parameter(s)
#       mylist: a list that will be reordereding integers from least to
#           greatest 
# Return Value(s)
#       -- if the input parameter ind is greater than i, swap ind and i       
#==========================================
def selection_sort(mylist):
    for x in range(len(mylist)):
        ind = x
        for i in range(x, len(mylist)):
            if mylist[ind] > mylist[i]:
                ind = i
        mylist[x], mylist[ind] = mylist[ind], mylist[x]
