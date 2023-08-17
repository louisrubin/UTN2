/*
* 17/08/23 - HERENCIA (POO)
* */
public class Cat extends Animal {
    @Override
    public void eat(){
        System.out.println("El gato está comiendo..");
    }

    public static void main(String[] args) {
        Animal c = new Cat();
        c.eat();
    }
}
