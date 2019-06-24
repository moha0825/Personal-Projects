#==========================================
# Name: __init__
# Purpose: To set both start and end times with the current time of day
# Precondition: Must set the current time of day in start and end variables
# Input Parameter(s)
#       self: accesses methods and attributes   
# Return Value(s)
#       -- Current time is return from the .time() function             
#==========================================

#==========================================
# Name: get_start
# Purpose: The purpose of this function is to get the starting values from the variable start   
# Precondition: Must return values stored in start variable
# Input Parameter(s)
#       self: acesses methods and attributes    
# Return Value(s)
#       -- Return value will be the values stored in the variable start           
#==========================================

#==========================================
# Name: get_end
# Purpose: The purpose of this function is to get the ending values from the variable end  
# Precondition: Must return values stored in end variable    
# Input Parameter(s)
#       self: acesses methods and attributes   
# Return Value(s)
#       -- Return value will be the values stored in the variable end           
#==========================================

#==========================================
# Name: current_time
# Purpose: The purpose of this function is to give the current local time in hours, minutes,
#          and seconds.  
# Precondition: It must be in the form HH:MM:SS, not H:M:S
# Input Parameter(s)
#       self: acesses methods and attributes     
# Return Value(s)
#       -- Return value will be the current local time in the form of HH:MM:SS          
#==========================================

#==========================================
# Name: set_start
# Purpose: The purpose of this function is to reset the start value to the current time   
# Precondition: The time returned will be in seconds
# Input Parameter(s)
#       self: acesses methods and attributes     
# Return Value(s)
#       -- Return value will be the current local time in seconds          
#==========================================

#==========================================
# Name: set_end
# Purpose: The purpose of this function is to reset the end value to the current time 
# Precondition: The time returned will be in seconds  
# Input Parameter(s)
#       self: acesses methods and attributes    
# Return Value(s)
#       -- Return value will be the current local time in seconds          
#==========================================

#==========================================
# Name: elapsed_time
# Purpose: The purpose of this function is to return the time elapsed for the stop watch  
# Precondition: The time elapsed that is return must be a float
# Input Parameter(s)     
#       self: acesses methods and attributes
# Return Value(s)
#       -- Return value will be the time elapsed as a float     
#==========================================
import time
import random
class StopWatch: 
    def __init__(self):
        self._start = time.time()
        self._end = time.time()
    def get_start(self):
        return self._start
    def get_end(self):
        return self._end
    def current_time(self):
        return time.strftime('%H:%M:%S', time.localtime())
    def set_start(self):
        self._start = time.time()
    def set_end(self):
        self._end = time.time()
    def elapsed_time(self):
        time_elapsed = self._end - self._start
        return time_elapsed 
if __name__ == "__main__":
    time1 = StopWatch()
    time1.set_start()
    print(time1.current_time())
    newlis1 = [ ]
    for i in range(30000):
        num = random.randint(0, 10000)
        newlis1.append(num)
    newlis1.sort()
    time1.set_end()
    print(time1.elapsed_time())
    print(time1.current_time())

    time2 = StopWatch()
    newlis2 = [ ]
    for i in range(50000):
        num = random.randint(0, 10000)
        newlis2.append(num)
    newlis2.sort()
    time2.set_end()
    print(time2.elapsed_time())
    print(time2.current_time())

#==========================================
# Name: __init__
# Purpose: The purpose of this function is to accept parameters for the game title, ESRB,
#          and list 
# Precondition: Must contain self and parameters for the game title, ESRB, and list of ratings
# Input Parameter(s)
#       self: acesses methods and attributes
#       game_title: the title of the game
#       esrb_rating: the esrb rating (E, E10+, T, M, AO, RP)
#       rating: the average rating to be determined by the get_average function
# Return Value(s)
#       -- Parameters for the game title, esrb rating, and average rating           
#==========================================

#==========================================
# Name: get_title
# Purpose: The purpose of this function is to get the title of the game
# Precondition: This function can only get the title of the game
# Input Parameter(s)
#       self: acesses methods and attributes    
# Return Value(s)
#       -- Will return the title of the game          
#==========================================

#==========================================
# Name: get_esrb
# Purpose: The purpose of this function is to get the ESRB 
# Precondition: This function can only get the esrb of the game
# Input Parameter(s)
#       self: acesses methods and attributes   
# Return Value(s)
#       -- Will return the esrb of the game          
#==========================================

#==========================================
# Name: set_title
# Purpose: The purpose of this function is to set the title of the game 
# Precondition: This function will only set the title to other
# Input Parameter(s)
#       self: acesses methods and attributes
#       other: instance of the class
# Return Value(s)
#       -- Will return the set title of the game         
#==========================================

#==========================================
# Name: set_esrb
# Purpose: The purpose of this function is to set the esrb of the game   
# Precondition: This function will only set the esrb to other
# Input Parameter(s)
#       self: acesses methods and attributes
#       other: instance of the class
# Return Value(s)
#       -- Will return the set esrb of the game           
#==========================================

#==========================================
# Name: get_average
# Purpose: The purpose of this function is to return the average of the people that have rated the 
#          game 
# Precondition: Numbers can range from 1 to 5, and depending on the index of the number, it will return
#               a truncated value 
# Input Parameter(s)
#       self: acesses methods and attributes    
# Return Value(s)
#       -- Returns a 0 if any of the ratings is 0
#       -- Returns the average of the values depending on the index and then dividing it
#          by the sum of the values in the said list 
#==========================================

#==========================================
# Name: __str__
# Purpose: The purpose of this function is to return a string containing the information for the game 
#          including the name of the game, rating, and average rating
# Precondition: Must have one space after colons and commas
# Input Parameter(s)
#       self: acesses methods and attributes 
# Return Value(s)
#       -- Returns the title of the game, esrb rating, and average rating            
#==========================================

class VideoGame: 
    def __init__(self, game_title, esrb_rating, rating = None):
        if rating == None:
            rating == [0,0,0,0,0]
        self.title = game_title 
        self.esrb = esrb_rating
        self.r = rating[:]
    def get_title(self):
        return self.title
    def get_esrb(self):
        return self.esrb
    def set_title(self, other):
        self.title = other
    def set_esrb(self, other):
        self.esrb = other
    def get_average(self):
        if any(self.r) == 0:
            return 0
        else:
            avg = round((self.r[0]*1 + self.r[1]*2 + self.r[2]*3 + self.r[3]*4 + self.r[4]*5) / sum(self.r))
            return avg
    def __str__(self):
        return ('Title: {}, ESRB Rating: {}, Average Rating: {}'.format(self.title, self.esrb, self.get_average()))
if __name__ == "__main__":
    vg1 = VideoGame("Mario Kart", "AO", [1, 2, 3, 4, 1])
    vg2 = VideoGame("Zelda", "T", [1, 2, 3, 4, 5])
    vg3 = VideoGame("Bugs Life", "E", [5, 4, 3, 2, 1])
    games = [vg1, vg2, vg3]
    for i in games:
        print(i)


