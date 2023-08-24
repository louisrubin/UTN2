/*
    EJECUTAR EL ARCHIVO 'Main.java'
* */
public class Account {
    private String id, name;
    private int balance = 0;

    public Account(String id, String name){
        this.id = id;
        this.name = name;
    }
    public Account(String id, String name, int balance){
        this.id = id;
        this.name = name;
        this.balance = balance;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getBalance() {
        return balance;
    }
    public int credit(int amount){
        this.balance += amount;
        return balance;
    }
    public int debit(int amount){
        if (amount <= balance){
            balance -= amount;
        } else {
            System.out.println("Amount Exceeded Balance");
        }
        return balance;
    }
    public int transferTo(Account acc, int amount){
        if (amount <= balance){
            this.balance -= amount;
            acc.balance += amount;
            System.out.println("Transferido $"+ amount +".");
        } else {
            System.out.println("Amount Exceeded Balance");
        }
        return balance;
    }

    @Override
    public String toString() {
        return "Account[id=" +this.id+ ",name="+ this.name + ",balance="+ this.balance+ "]";
    }
}
