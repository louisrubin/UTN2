package ejer10;

public class Circle extends Shape {
    protected double radius;

    public Circle(){
        radius = 5.5;
    }
    public Circle(double radius, String color, boolean filled){
        this.radius = radius;
        this.color = color;
        this.filled = filled;
    }

    public double getRadius() {
        return radius;
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public double getPerimeter() {
        return Math.PI * Math.PI * radius;
    }

    @Override
    public String toString() {
        return "[radius="+radius+ ",area=" +this.getArea()+ ",perimeter=" +this.getPerimeter() +"]";
    }
}
