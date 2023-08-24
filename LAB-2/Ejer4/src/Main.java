public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Account acc1 = new Account("3jau2", "luis", 500);
        Account acc2 = new Account("ks82a", "pedro", 120);


        System.out.println(acc1.toString());
        System.out.println(acc2.toString());

        acc1.transferTo(acc2, 400);
        System.out.println(acc1.toString());
        System.out.println(acc2.toString());

        acc2.transferTo(acc1, 200);
        System.out.println(acc1.toString());
        System.out.println(acc2.toString());
    }
}