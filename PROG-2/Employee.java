/*
* Rubin Luis - 15/08/23
* POO Ejercicio 2
* */
public class Employee {
    // ATRIBUTOS
    int id, salary;
    String firstName, lastName;

    public Employee(int id, String firstName, String lastName, int salary){
        System.out.println("Nuevo Empleado cargado.");
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
    }

    public int getID(){
        System.out.println("ID: "+id);
        return id;
    }
    public String getFirstName(){
        System.out.println(firstName);
        return firstName;
    }

    public String getLastName(){
        System.out.println(lastName);
        return lastName;
    }

    public String getName(){
        System.out.println(firstName + lastName);
        return firstName + lastName;
    }
    public int getSalary(){
        System.out.println("Salario: $"+salary);
        return salary;
    }
    public void setSalary(int salary){
        this.salary = salary;
    }
    public int getAnnualSalary(){
        System.out.println("Salario anual: $"+ salary*12);
        return salary*12;
    }
    public int raiseSalary(int percent){
        int inc = salary * percent / 100;
        salary += inc;
        System.out.println("Salario incrementado: $"+ salary);
        return salary;
    }
    public String toString(){
        System.out.println("Employee[id="+id +",name="+firstName+" "+lastName+",salary=$"+salary+"]");
        return "Employee[id="+id +",name="+firstName+" "+lastName+",salary=$"+salary+"]";
    }

    public static void main(String[] args) {
        Employee e = new Employee(10,"luis","rubin",200);
        e.toString();
        e.raiseSalary(10);
        e.setSalary(90);
        e.getSalary();
        e.toString();
        e.getAnnualSalary();
    }
}
