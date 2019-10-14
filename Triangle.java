import java.awt.Color;
public class Triangle{
    private double pos_x;
    private double pos_y;
    private double width;
    private double height;
    private Color c;

    public Triangle(double pos_x, double pos_y, double width, double height){
        this.pos_x = pos_x;
        this.pos_y = pos_y;
        this.width = width;
        this.height = height;
    }
    public double calculatePerimeter(){
        double perimeter = Math.sqrt(((width/2) * (width/2)) + (height * height)) + width + Math.sqrt(((width/2) * (width/2)) + (height * height));
        return perimeter;
    }
    public double calculateArea(){
            double area = (width * height) / 2;
            return area;
    }
    public void setColor(Color c){
        this.c = c;
    }
    public void setPos(double pos_x, double pos_y){
        this.pos_x = pos_x;
        this.pos_y = pos_y;
    }
    public void setHeight(double height){
        this.height = height;
    }
    public void setWidth(double width){
        this.width = width;
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
    public double getHeight(){
        return height;
    }
    public double getWidth(){
        return width;
    }
}
