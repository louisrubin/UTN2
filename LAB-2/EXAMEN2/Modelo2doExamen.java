package EXAMEN2;
import java.util.ArrayList;
import java.sql.*;
import java.util.Scanner;

// https://docs.google.com/document/d/129jn4i_uvzkT1SyUb-AAr63MUdk4ScwRs8z_8QSLjww/edit
// https://classroom.google.com/w/NTA1NjEyNzgwNTU0/t/all

public class Modelo2doExamen {  // HOSPITAL
    private ArrayList<Paciente> listaPacientes;
    private ArrayList<Doctor> listaDoctores;


    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/hospital_db";
        String usuario = "root";
        String passw = "";

        try {
            Connection conexion = DriverManager.getConnection(url, usuario, passw);
            Statement statement = conexion.createStatement();

            String consulta = "select * from pacientes";
            ResultSet result = statement.executeQuery(consulta);

            while (result.next()) {
                System.out.println("ID: "+ result.getString("id") +
                        ", nombre: " + result.getString("nombre") +
                        ", edad: " + result.getString("edad") +
                        ", fecha Ingreso: " + result.getString("fecha_ingreso") +
                        ", doctorID: " + result.getString("doctor")
                );
            }

            result.close();
            statement.close();
            conexion.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Modelo2doExamen(){
        listaDoctores = new ArrayList <>();
        listaPacientes = new ArrayList <>();
    }

    public void agregarPaciente(Paciente paciente){
        listaPacientes.add(paciente);

    }

    public void listarPacientes(){
        for ( Paciente pac : listaPacientes) {
            System.out.println(pac.toString()); // imprime sus datos
        }
    }

    public void asignarDoctorCabecera(Paciente paciente, Doctor nuevoDoctor) {
        paciente.setDoctorAsignado(nuevoDoctor);
    }

    public void mostrarPacientesEntreFechas(String fechaInicio, String fechaFin) {
        // select * from pacientes where fecha_ingreso >= '2011/02/25' and fecha_ingreso <= '2024/02/27'
        String consulta = "select * from pacientes where fecha_ingreso >= " + fechaInicio +
                " and fecha_ingreso <= " + fechaFin ;

    }

    public ArrayList <Doctor> getListaDoctores() {
        return listaDoctores;
    }

    public ArrayList <Paciente> getListaPacientes() {
        return listaPacientes;
    }
}

abstract class Persona {
    private int id, edad;
    private String nombre;

    public static int sigId = 0;

    public Persona() {
        //..
    }
    public Persona(String nombre){
        this.id = sigId++;
        this.nombre = nombre;
    }
    public Persona(String nombre, int edad){
        this.id = sigId++;
        this.nombre = nombre;
        this.edad = edad;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }


    @Override
    public String toString() {
        return id + ", " + nombre.toUpperCase() + ", " + edad;
    }
}

class Paciente extends Persona {
    private String historialMedico;
    private Doctor doctorAsignado;

    public Paciente() {
        // ..
    }
    public Paciente(String nombre){
        super(nombre);
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

    @Override
    public String toString() {
        return "[" + super.toString() + ", "+ historialMedico + "]";
    }

    public void setDoctorAsignado(Doctor doctorAsignado) {
        this.doctorAsignado = doctorAsignado;
    }

    public Doctor getDoctorAsignado() {
        return doctorAsignado;
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

    @Override
    public String toString() {
        return "[" + super.toString() + ", " + especialidad.toUpperCase() + "]";
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }
}
