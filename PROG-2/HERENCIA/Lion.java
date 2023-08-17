/*
* 17/08/23 - HERENCIA (POO)
* */
public class Lion extends Animal {

    @Override
    public void makeNoise() {
        System.out.println("*Leon Rugiendo*");
    }

    public static void main(String[] args) {
        Animal l = new Lion();
        l.makeNoise();
    }
}
