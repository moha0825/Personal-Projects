# This code is designed to use the turtle function in python to return a four sided star. 
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
    
    
