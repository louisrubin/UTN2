package POO.Ejer3_4y5;

public class Account {
    private String id, name;
    private int balance=0;
    public static int sigId = 0;

    public Account(String id, String name, int balance) {
        this.balance = balance;
        this.id = Integer.toString(sigId++);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getBalance() {
        return balance;
    }

    public String getId() {
        return id;
    }

    public int credit(int amount){
        if (amount > 0) {
            this.balance += amount;
            return this.balance;
        }
        System.out.println("Ingrese un valor positivo.");
        return this.balance;
    }

    public int debit(int amount){
        // retirar
        if (amount <= balance){
            this.balance -= amount;
        } else {
            System.out.println("La Cantidad supera el balance.");
        }
        return balance;
    }

    public int transferTo(Account anotherAcc, int amount){
        if (amount <= balance){
            anotherAcc.balance += amount;
            this.balance -= amount;
        } else {
            System.out.println("La Cantidad supera el balance.");
        }
        return balance;
    }

    @Override
    public String toString() {
        return "Account=[id="+this.id+",name="+this.name+",balance=$"+this.balance+"]";
    }
}
