import java.awt.Color;
public class Circle {
    private double pos_x;
    private double pos_y;
    private double radius;
    private Color c;

    public Circle(double pos_x, double pos_y, double radius){
        this.pos_x = pos_x;
        this.pos_y = pos_y;
        this.radius = radius;
    }
    public double calculatePerimeter(){
        double perimeter = (2 * Math.PI) * (radius);
        return perimeter;
    }
    public double calculateArea(){
        double area = (radius * radius) * (Math.PI);
        return area;
    }
    public void setColor(Color c){
        this.c = c;
    }
    public void setPos(double pos_x, double pos_y){
        this.pos_x = pos_x;
        this.pos_y = pos_y;
    }
    public void setRadius(double radius){
        this.radius = radius;
    }
    public Color getColor(){
        return c;
    }
    public double getXPos(){
        return pos_x;
    }
    public double getYPos(){
        return pos_y;
    }
    public double getRadius(){
        return radius;
    }

}
