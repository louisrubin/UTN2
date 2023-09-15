package POO.Ejer3_4y5;
public class Author {
    private byte id;
    private String name, email;
    private char gender;
    public static byte sigId = 0;

    public Author(String name, String email, char gender){
        this.id = sigId ++;
        this.email = email;
        this.gender = gender;
        this.name  = name;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public char getGender() {
        return gender;
    }

    @Override
    public String toString() {
        return "Author=[name="+this.name+",email="+this.email+",gender="+this.gender+"]";
    }
}
