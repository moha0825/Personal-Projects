# Lubna Mohamed Abdirahman, moha0825, Lab Section 011, HW 6

#==========================================
# Name: sameKeys
# Purpose: Given two dictionaries, the function will look for keys found in 
#   both dictionaries, returning a new dictionary that contains the value pairs
# Precondition: There can be any type of objects for the values of the keys and
#   the dictionary should be ordered. 
# Input Parameter(s)
#       diction1: a dictionary being compared to diction2
#       diction2: a dictionary being compared to diction1
# Return Value(s)
#       -- Return value will be a dictionary that is concatnated           
#==========================================
def sameKeys(diction1, diction2):
    new = { }
    for num in diction1:
        if num in diction2:
            new[num] = [diction1[num]] + [diction2[num]]
    return new

#==========================================
# Name: averageGrades
# Purpose: Given a dictionary, the function will return the average 
#   of all numbers given in said dictionary in a new dictionary. 
# Precondition: There will only be either a list of integers or an empty list 
# Input Parameter(s)
#       diction: a dictionary containing a list of numbers and a name to match
# Return Value(s)
#       -- Return value will be a new dictionary containing the averages that are
#          truncated. 
#==========================================
def averageGrades(diction):
    newdict = { }
    for num in diction:
        if diction == { }:
            return { }
        else:
            if diction[num] != [ ]:
                avg = int(sum(diction[num])/len(diction[num]))
                newdict[num] = avg
            else:
                newdict[num] = 0
    return newdict

#==========================================
# Name: allKeys
# Purpose: Given a dictionary of strings being compared to an integer, the function 
#   will return a new dictionary containing where the element was found to be one of the 
#   integers in the key's value. 
# Precondition: The list will be sorted and the keys of the dictionary will always be strings
# Input Parameter(s)
#       diction: a dictionary with strings as its keys and lists of integers
#                as each key's value
#       element: an integer
# Return Value(s)
#       -- Return a sorted list of string(s) where the element was found in
#          the key's value
#==========================================
def allKeys(diction,element):
    newlis = [ ]
    count = 0
    for x in diction:
        num = diction[x]
        if element in num:
            newlis.append(x)
            newlis.sort()
    return newlis
#==========================================
# Name: invertFiles
# Purpose: Given multiple text files, the function will count the number of times a word is 
#   mentioned and will then return it in a new dictionary with the words and number of times it 
#   appears in ascending order. 
# Precondition: The dictionary will be returned in ascending order
# Input Parameter(s)
#       list_of_file_names: a list of file names 
# Return Value(s)
#       -- Return a sorted dictionary of words in ascending order from the text files imported         
#==========================================
import re # REDID THIS PROBLEM 
def invertFiles(list_of_file_names):
    d = { }
    for i in list_of_file_names:
        filename = list_of_file_names.index(i) + 1
        fileopen = open(i,"r")
        myline = fileopen.readline() # reading the first line in the code
        for line in fileopen:
            data = re.split("[ .,:;!?1234567890\s\b]+|[\r\n]+", line.lower())
            data = filter(None, data)
            for word in data:
                if word in d.keys() and filename not in d[word]:
                    d[word] += [filename] 
                else:
                    if word not in d: # if the word is not in the list, it'll add it 
                        d[word] = [filename]
    newfile = open("HW6_output.txt", 'w+')
    for count,val in sorted(d.items()):
        for num in d[count]:
            newfile.write(count+' '+str(num)+"\r\n")
            
