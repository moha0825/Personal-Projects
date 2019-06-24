# CSCI 1133, Lab Section 011, HW 2 Lubna Mohamed Abdirahman, Problem B
import turtle
def fourSidedStar(lengthOfSide):
    turtle.showturtle()
    turtle.left(75)
    turtle.forward(float(lengthOfSide))
    turtle.right(60)
    turtle.forward(float(lengthOfSide))
    turtle.left(150)
    turtle.forward(float(lengthOfSide))
    turtle.right(60)
    turtle.forward(float(lengthOfSide))
    turtle.left(150)
    turtle.forward(float(lengthOfSide))
    turtle.right(60)
    turtle.forward(float(lengthOfSide))
    turtle.left(150)
    turtle.forward(float(lengthOfSide))
    turtle.right(60)
    turtle.forward(float(lengthOfSide))

def main():
    lengthOfSide = float(input("Enter length of side: "))
    fourSidedStar(lengthOfSide)

if __name__ == "__main__":
    main()
    
    
