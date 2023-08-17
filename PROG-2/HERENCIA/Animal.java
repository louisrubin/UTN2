/*
* 17/08/23 - HERENCIA (POO)
* */
public class Animal {
    protected String picture;
    protected String food;
    protected String hunger;
    protected String boundaries;
    protected String location;

    public Animal(){
        System.out.println("Animal instanciado.");
    }

    // METHODS
    public void makeNoise(){
        System.out.println("*Ruido*");
    }
    public void eat(){
        System.out.println("*Comiendo*");
    }
    public void sleep(){
        System.out.println("*Durmiendo*");
    }
    public void roam(){
        System.out.println("*Moviendose*");
    }
}
