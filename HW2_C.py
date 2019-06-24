# CSCI 1133, Lab Section 011, HW 2 Lubna Mohamed Abdirahman, Problem C
def calories_short(age, weight, heart_rate, time):
    calories_short = ((age * float(0.074)) + (heart_rate * float(0.4472)) - (weight * float(0.05741)) - 20.4022) * (time / float(4.184))
    return calories_short

def calories_tall(age, weight, heart_rate, time):
    calories_tall = ((age * 0.2017) + (heart_rate * 0.6309) - (weight * 0.09036) - 55.0969) * (time / 4.184)
    return calories_tall

def main():
    height = float(input("Please input the height of the person (for example, 5.6 means 5 feet 6 inches): "))
    weight = int(input("Please input the body weight of person, in pounds: "))
    heart_rate = int(input("Please input the average heart rate of the person during the workout, in beats per minute: "))
    age = int(input("Please input the age of the person, in years: "))
    time = int(input("Please input the duration of the workout of the person, in minutes: "))
    print("\n")
    print("You enterted the following information: ")
    print("Height: ", '{0:.1f}'.format(height))
    print("Body weight: ", weight)
    print("Average heart rate: ", heart_rate)
    print("Age: ", age)
    print("Duration of workout: ", time)
    if height <= float(5.6):
        print("The number of calories burned for this short person is", int(calories_short(age, weight, heart_rate, time)), "calories.")
    else:
        print("The number of calories burned for this tall person is", int(calories_tall(age, weight, heart_rate, time)), "calories.")

if __name__ == "__main__":
    main()

