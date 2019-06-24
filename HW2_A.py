# CSCI 1133, Lab Section 011, HW 2 Lubna Mohamed Abdirahman, Problem A
import math
def poiseuille(length, radius, viscosity):
    Resistance = (int(8)*viscosity*length)/(math.pi*radius**(4))
    return Resistance
def main():
    length = float(input("Please enter the length: "))
    radius = float(input("Please enter the radius: "))
    viscosity = float(input("Please enter the viscosity: "))
    if length <= 0:
        print("Failed due to input error. Please make sure your inputs are all positive. Exiting program.")
    elif radius <= 0:
        print("Failed due to input error. Please make sure your inputs are all positive. Exiting program.")
    elif viscosity <= 0:
        print("Failed due to input error. Please make sure your inputs are all positive. Exiting program.")
    else:
        print("The resistance is: ", poiseuille(length, radius, viscosity))

if __name__ == "__main__":
    main()
        




