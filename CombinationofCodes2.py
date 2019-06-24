#==========================================
# Name: cnt_occur
# Purpose: Given a list of integers and/or string, compare it to another integer
#   or string and if the number or letter is the same, count the number of times it
#   occurs in the list. 
# Precondition: The list will only contain integers and/or strings.
# Input Parameter(s)
#       mylist: a list containing integers and/or string
#       x: an integer or string
# Return Value(s)
#       -- Return value will always be an integer          
#==========================================
def cnt_occur(mylist, x):
    if mylist == [ ]:
        return 0 
    elif mylist[0] == x:
        return 1 + cnt_occur(mylist[1:],x)
    elif type(mylist[0]) == list:
        return cnt_occur(mylist[0], x) + cnt_occur(mylist[1:], x)
    else:
        return cnt_occur(mylist[1:],x)

#==========================================
# Name: helper 
# Purpose: Given an integer, find the integer that matches in the 
#   list given and then return the index of these integers that match
# Precondition: The list will only contain integers or empty lists  
# Input Parameter(s)
#       mylist: a list containing integers 
#       element: an integer being compared to mylist values 
#       count: keeping track of how many integers in mylist are matches to element 
# Return Value(s)
#       -- Return value will either be an integer or an empty list       
#==========================================

#==========================================
# Name: position
# Purpose: The purpose of this function is to use the helper function to compute the position
#          of the integers while comparing it to the element
# Precondition: The list will only contain integers or empty lists 
# Input Parameter(s)
#       mylist: a list containing integers 
#       element: an integer being compared to mylist values  
# Return Value(s)
#       -- Return value will be using the helper function to compute the list needed    
#==========================================
def helper(mylist, element, count):
    if mylist == [ ]:
        return [ ]
    elif mylist [0] == element:
        return [count] + helper(mylist[1:],element,count+1)
    else:
        return helper(mylist[1:],element,count+1)
def position(mylist,element):
    return helper(mylist,element,0)

#==========================================
# Name: rm_conseq_dups
# Purpose: Given a list of integers, remove any integers that repeat in said list,
#   returning a list of integers that are not duplicates in a row. 
# Precondition: There will be no embedded lists, and there will only be integers or strings in the list 
# Input Parameter(s)
#       mylist: a list containing integers or strings 
# Return Value(s)
#       -- Return value will be a list of integers or strings      
#==========================================
def rm_conseq_dups(mylist):
    if len(mylist) <= 1:
        return mylist
    elif mylist[0] == mylist[1]:
        return rm_conseq_dups(mylist[1:])
    else:
        return [mylist[0]] + rm_conseq_dups(mylist[1:])
    
#==========================================
# Name: sequence
# Purpose: Given an integer, find the integer to the nth value in the sequence 
# Precondition: The sequence must start at 3; Input parameter will always be an integer 
# Input Parameter(s)
#       n: an integer being used to find the sequence 
# Return Value(s)
#       -- Return value will be an integer from the sequence using the nth power      
#==========================================
def sequence(n):
    if n==1:
        return 3
    else:
        return sequence(n-1) * 2
    
#==========================================
# Name: rangeIt
# Purpose: Creates a list of integers using a range that is given
#   and the integers in between will be returned including the range given
# Precondition: The x integer will always be less than or equal to the y integer;
#   Inputs will always be an integer 
# Input Parameter(s)
#       x: an integer 
#       y: an integer 
# Return Value(s)
#       -- Return value will be a list of integer(s) in between two integers        
#==========================================
def rangeIt(x,y):
    if x==y:
        return [y]
    else:
        return [x] + rangeIt(x+1,y)
