import java.awt.Color;
import java.util.Scanner;
public class Fractals {
    private static double Area;
    private Color color;
    public void circleFrac(Circle myCircle, Canvas drawing, int level, Color cir){
        if (level < 8) {
            myCircle.setColor(cir);
            drawing.drawShape(myCircle);
            if (cir == Color.BLUE){
                cir = Color.RED;
            }
            else if (cir == (Color.RED)){
                cir = Color.GREEN;
            }
            else if (cir == (Color.GREEN)){
                cir = Color.BLUE;
            }
            Circle c1 = new Circle(myCircle.getXPos() + myCircle.getRadius() * 1.5, myCircle.getYPos(), myCircle.getRadius()/2);
            circleFrac(c1, drawing, level + 1, cir);
            Circle c2 = new Circle(myCircle.getXPos() - myCircle.getRadius() * 1.5, myCircle.getYPos() , myCircle.getRadius()/2);
            circleFrac(c2, drawing, level + 1, cir);
            Circle c3 = new Circle(myCircle.getXPos(), myCircle.getYPos() + myCircle.getRadius() * 1.5, myCircle.getRadius()/2);
            circleFrac(c3, drawing, level + 1, cir);
            Circle c4 = new Circle(myCircle.getXPos(), myCircle.getYPos() - myCircle.getRadius() * 1.5, myCircle.getRadius()/2);
            circleFrac(c4, drawing, level + 1, cir);
            Area += myCircle.calculateArea();
        }
}
    public void triangleFrac(Triangle myTriangle, Canvas drawing, int level, Color tri){
        if (level < 8) {
            myTriangle.setColor(tri);
            drawing.drawShape(myTriangle);
            if (tri == Color.BLUE){
                tri = Color.RED;
            }
            else if (tri == (Color.RED)){
                tri = Color.GREEN;
            }
            else if (tri == (Color.GREEN)){
                tri = Color.BLUE;
            }
            Triangle t1 = new Triangle(myTriangle.getXPos() - myTriangle.getWidth() / 2, myTriangle.getYPos(), myTriangle.getWidth() / 2, myTriangle.getHeight()/2);
            triangleFrac(t1, drawing, level + 1, tri);
            Triangle t2 = new Triangle(myTriangle.getXPos() + myTriangle.getWidth(), myTriangle.getYPos(), myTriangle.getWidth()/ 2, myTriangle.getHeight()/2);
            triangleFrac(t2, drawing, level + 1, tri);
            Triangle t3 = new Triangle(myTriangle.getXPos() + myTriangle.getWidth() / 4, myTriangle.getYPos() + myTriangle.getHeight() / 2, myTriangle.getWidth()/2, myTriangle.getHeight()/2);
            triangleFrac(t3, drawing, level + 1, tri);
            Area += myTriangle.calculateArea();
        }
    }
    public void rectangleFrac(Rectangle myRectangle, Canvas drawing, int level, Color rect){
        if (level < 8) {
            myRectangle.setColor(rect);
            drawing.drawShape(myRectangle);
            if (rect == Color.BLUE){
                rect = Color.RED;
            }
            else if (rect == (Color.RED)){
                rect = Color.GREEN;
            }
            else if (rect == (Color.GREEN)){
                rect = Color.BLUE;
            }
            Rectangle r1 = new Rectangle(myRectangle.getXPos() - myRectangle.getWidth() / 2, myRectangle.getYPos() - myRectangle.getHeight() / 2, myRectangle.getWidth() / 2, myRectangle.getHeight() / 2);
            rectangleFrac(r1, drawing, level + 1, rect);
            Rectangle r2 = new Rectangle(myRectangle.getXPos() + myRectangle.getWidth(), myRectangle.getYPos() - myRectangle.getHeight() / 2, myRectangle.getWidth()/2, myRectangle.getHeight()/2);
            rectangleFrac(r2, drawing, level + 1, rect);
            Rectangle r3 = new Rectangle(myRectangle.getXPos() + myRectangle.getWidth(), myRectangle.getYPos() + myRectangle.getHeight(), myRectangle.getWidth()/2, myRectangle.getHeight()/2);
            rectangleFrac(r3, drawing, level + 1, rect);
            Rectangle r4 = new Rectangle(myRectangle.getXPos() - myRectangle.getWidth() / 2, myRectangle.getYPos() + myRectangle.getHeight(), myRectangle.getWidth()/2, myRectangle.getHeight()/2);
            rectangleFrac(r4, drawing, level + 1, rect);
            Area = myRectangle.calculateArea();
        }
    }
    public static void main(String [] args){
        Fractals f = new Fractals();
        String shape;
        boolean go = true;
        Scanner s = new Scanner(System.in);
        System.out.println("Please input your shape choice (Circle, Triangle, or Rectangle): ");
        shape = s.nextLine();
        while (go){
            if (shape.equals("Circle")){
                f.circleFrac(new Circle(500,375,100), new Canvas(1000,1000),0, Color.BLUE);
                go = false;
            }
           else if (shape.equals("Triangle")){
               f.triangleFrac(new Triangle(500,375, 100, 100), new Canvas(1000,1000), 0, Color.BLUE);
               go = false;
            }
           else if (shape.equals("Rectangle")) {
               f.rectangleFrac(new Rectangle(500,375,100, 50), new Canvas(1000,1000), 0, Color.BLUE);
               go = false;
            }
            else{
                System.out.println("Error, please enter a valid input.");
                shape = s.nextLine();
            }
        }
        System.out.println("Area of shape equals: " + Area);
    }
}
