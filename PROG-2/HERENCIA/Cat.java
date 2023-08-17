/*
* 17/08/23 - HERENCIA (POO)
* */
public class Cat extends Animal {

    public Cat(String name, String food, String location){
        this.name = name;
        this.food = food;
        this.location = location;
    }

    @Override
    public void eat(){
        System.out.println(super.getName() + " está comiendo..");
    }

    public static void main(String[] args) {
        Animal c = new Cat("Rodrigo", "alimento balanceado", "Resistencia, Chaco");
        c.eat();
        //System.out.println(c.food);
    }
}
