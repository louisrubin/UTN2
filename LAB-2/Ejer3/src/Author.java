import java.lang.runtime.ObjectMethods;
import java.util.Objects;

public class Author {
    private String name, email;
    private Character gender;

    public Author(String name, String email, Character gender){
        this.name = name;
        this.email = email;
        this.gender = (gender == 'm' || gender == 'f') ? gender : null;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public Character getGender() {
        return gender;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Author[name="+this.name+",email="+this.email+",gender="+this.gender+"]";
    }

    public static void main(String[] args) {
        Author a = new Author("luis", "luis@gmail.com", 'm');
        System.out.println(a.toString());
        System.out.print("gender: " + a.getGender());
    }
}
