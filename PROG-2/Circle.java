/*
* Rubin Luis - 15/08/23
* POO Ejercicio 1
* */
public class Circle {
    //ATRIBUTOS
    protected double radius = 1.0;

    // CONSTRUCTORES
    public Circle(){

        System.out.println("Objeto instanciado por defecto.");
    }
    public Circle(double radius){
        this.radius = radius;
        System.out.println("Objeto instanciado con radio.");
    }

    // GETTERS
    public double getRadius(){
        System.out.println("EL radio es "+ radius);
        return radius;
    }
    public double getArea(){
        System.out.println("El área es "+ radius * Math.PI);
        return radius * Math.PI;
    }

    public double getCircumreference(){
        System.out.println("La longitud de la cirfunferencia es "+ (Math.PI * 2) * radius );
        return (Math.PI * 2) * radius;
    }

    public String toString(){
        return "Circle[radius=" + this.radius + "]";
    }

    // SETTER

    public void setRadius(double radius){
        this.radius = radius;
        System.out.println("Nuevo radio establecido.");
    }

    public static void main(String[] args) {
        Circle cir = new Circle(22);
        System.out.println(cir.toString());
        cir.getArea();
        cir.setRadius(3.3);
        System.out.println(cir.toString());
    }

}
