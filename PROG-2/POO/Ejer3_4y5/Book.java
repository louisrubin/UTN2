package POO.Ejer3_4y5;

public class Book {
    private String name;
    private Author authors[];
    private double price;
    private int qty = 0;
    public static int sigIdLibro = 1000;

    public Book(String name, Author[] authors, double price){
        this.authors = authors;
        this.name = name;
        this.price = price;
        this.qty = sigIdLibro++;
    }
    public Book(String name, Author[] authors, double price, int qty){
        this.authors = authors;
        this.name = name;
        this.price = price;
        this.qty = qty;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQty() {
        return qty;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    @Override
    public String toString() {
        return "Book=[name="+ name + ",authors= {\n"+ printAuthors(authors) + "}, price=$"
                +price +",qty=" + qty  +"]";
    }

    public String printAuthors(Author[] authorsParam){
        String stringReturn = "\t";
        for (Author a : authorsParam){
            stringReturn += a.toString() + ",\n\t";
        }
        return stringReturn;
    }

    public String getAuthorNames(){
        String stringReturn = "";
        for (Author a : this.authors){
            stringReturn += a.getName() + ",";
        }
        return stringReturn;
    }

    public static void main(String[] args) {
        Author a1 = new Author("pepito", "pepito@gmail.com", 'm');
        Author a2 = new Author("camila", "camila22@gmail.com", 'f');
        Author a3 = new Author("sofia", "sofia1@gmail.com", 'f');

        Author[] authors = {a1, a2, a3};

        Book book = new Book("las venturas de pepito", authors,250, 10225);

        //System.out.println(book.printAuthors(authors));
        System.out.println(book.toString());
    }
}
