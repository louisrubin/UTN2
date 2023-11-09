import java.util.ArrayList;

// https://docs.google.com/document/d/129jn4i_uvzkT1SyUb-AAr63MUdk4ScwRs8z_8QSLjww/edit
// https://classroom.google.com/w/NTA1NjEyNzgwNTU0/t/all

public class Modelo2doExamen {
    private ArrayList<Paciente> listaPacientes;
    private ArrayList<Doctor> listaDoctores;

    private String url = "jdbc:mysql://localhost:3306/hospital_db";
    private String usuario = "root";
    private String passw = "";

    public Modelo2doExamen(){
        listaDoctores = new ArrayList <>();
        listaPacientes = new ArrayList <>();
    }

    public void guardarenBD(){

    }

    public ArrayList <Doctor> getListaDoctores() {
        return listaDoctores;
    }

    public ArrayList <Paciente> getListaPacientes() {
        return listaPacientes;
    }
}

abstract class Persona {
    protected String nombre;
    protected int edad;
    public Persona() {
        //..
    }
    public Persona(String nombre, int edad){
        this.nombre = nombre;
        this.edad = edad;
    }
}

class Paciente extends Persona {
    private String historialMedico;

    public Paciente() {
        // ..
    }
    public Paciente(String nombre, int edad){
        super(nombre, edad);
    }
    public Paciente(String nombre, int edad, String historial){
        super(nombre, edad);
        this.historialMedico = historial;
    }

    public String getHistorialMedico() {
        return historialMedico;
    }

    public void setHistorialMedico(String historialMedico) {
        this.historialMedico = historialMedico;
    }
}

class Doctor extends Persona {
    private String especialidad;

    public Doctor () {
        // ..
    }
    public Doctor (String nombre, int edad) {
        super(nombre, edad);
    }
    public Doctor (String nombre, int edad, String especialidad) {
        super(nombre, edad);
        this.especialidad = especialidad;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }
}
