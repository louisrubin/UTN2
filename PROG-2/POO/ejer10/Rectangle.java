package ejer10;

public class Rectangle extends Shape {
    protected double width;
    protected double length;

    public Rectangle(){
        width = 12.0;
        length = 35.0;
    }
    public Rectangle(double width, double length){
        this.length = length;
        this.width = width;
    }
    public Rectangle(double width, double length, String color, boolean filled){
        this.length = length;
        this.width = width;
        this.color = color;
        this.filled = filled;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    @Override
    public double getArea() {
        return width * length;
    }

    @Override
    public double getPerimeter() {
        return length * 2 + width * 2;
    }

    @Override
    public String toString() {
        return "[width="+getWidth()+ ",length=" +this.getLength()+ ",area=" + getArea() +",perimeter=" +this.getPerimeter() +"]";
    }
}
