package EXAMEN2;

import java.util.ArrayList;
import java.sql.*;
import java.util.Scanner;

// https://docs.google.com/document/d/129jn4i_uvzkT1SyUb-AAr63MUdk4ScwRs8z_8QSLjww/edit
// https://classroom.google.com/w/NTA1NjEyNzgwNTU0/t/all
// https://mariadb.com/downloads/connectors/connectors-data-access/java8-connector/

public class Modelo2doExamen {  // HOSPITAL
    private ArrayList<Paciente> listaPacientes;
    private ArrayList<Doctor> listaDoctores;


    public static void main(String[] args) {        // HOSPITAL
        Modelo2doExamen hospital = new Modelo2doExamen();
        Scanner sc = new Scanner(System.in);


        try {

            hospital.cargardesdeBD();   // carga todos los doctores y pacientes desde la BD
            Paciente paci1 = new Paciente(2, "camila", 25, "historial camila",
                    "2023-03-19", hospital.listaDoctores.get(1));
            Paciente paci2 = new Paciente(3, "john", 46, "historial john",
                    "2023-07-03", hospital.listaDoctores.get(1) );
            Paciente paci3 = new Paciente(4, "flea", 56, "historial flea",
                    "2023-11-28", hospital.listaDoctores.get(1) );


            System.out.println("ENTER PARA CONTINUAR.");
            sc.nextLine();

            hospital.agregarPaciente(paci1);
            hospital.agregarPaciente(paci2);
            hospital.agregarPaciente(paci3);
            System.out.println("5- 3 Pacientes agregados a la BD.");

            System.out.println("\nENTER PARA CONTINUAR.");
            sc.nextLine();

            hospital.imprimirPacientes(null);
            System.out.println("6- Pacientes listados.");

            System.out.println("\nENTER PARA CONTINUAR.");
            sc.nextLine();

            hospital.asignarDoctorCabecera(paci2, hospital.listaDoctores.get(0));
            System.out.println("7- Doctor '"+ hospital.listaDoctores.get(0).getNombre() +
                    "' asignado al paciente '" + paci2.getNombre() +"'");

            System.out.println("\nENTER PARA CONTINUAR.");
            sc.nextLine();

            System.out.println("8- Mostrando pacientes que ingresaron entre 2023-01-01 y 2023-07-18");
            hospital.mostrarPacientesEntreFechas("2023-01-01" , "2023-07-18");

            System.out.println("\nENTER PARA CONTINUAR.");
            sc.nextLine();

            hospital.eliminarPaciente("camila");
            System.out.println("9- Paciente 'camila' eliminado de la BD.");

            System.out.println("\nENTER PARA CONTINUAR.");
            sc.nextLine();


        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("ERROR AL CONECTAR CON LA BD.");
        }
    }

    public Modelo2doExamen(){       // CONSTRUCTOR
        listaDoctores = new ArrayList <>();
        listaPacientes = new ArrayList <>();
    }

    public void agregarPaciente(Paciente paciente){
        String consulta = "INSERT INTO pacientes (id, nombre, edad, historial_medico, fecha_ingreso, doctor)" +
                " VALUES ("+ paciente.getId() + ",'" + paciente.getNombre() + "',"
                + paciente.getEdad() + ",'"+ paciente.getHistorialMedico() +
                "', '" + paciente.getFecha_ingreso() + "', " + paciente.getDoctorAsignado().getId() + ");";
        try {
            DbHelper.consultaSinRes(consulta);
            listaPacientes.add(paciente);
        } catch (Exception e) {
            System.out.println("ERROR AL AGREGAR PACIENTE.\n -> " + e.getMessage());
        }
    }

    public void imprimirPacientes(ResultSet pacientEntreFechas){
        if (pacientEntreFechas == null){
            for ( Paciente pac : listaPacientes) {
                System.out.println(pac.toString()); // imprime sus datos
            }
        }
        else {
            try {
                while (pacientEntreFechas.next()){      // imprime los pacientes pasados por parametro
                    System.out.println("[" + pacientEntreFechas.getInt("id") +
                            ", " + pacientEntreFechas.getString("nombre").toUpperCase() +
                            ", " + pacientEntreFechas.getInt("edad") +
                            ", " + pacientEntreFechas.getString("fecha_ingreso")
                            + "]"
                            );
                }
            } catch (SQLException e){
                System.out.println("ERROR AL MOSTRAR PACIENTES ENTRE FECHAS.");
            }
        }
    }

    public void asignarDoctorCabecera(Paciente paciente, Doctor nuevoDoctor) {
        String consulta = "UPDATE pacientes SET doctor = " + nuevoDoctor.getId() + " WHERE id = " +
                paciente.getId() + ";";
        DbHelper.consultaSinRes(consulta);
        paciente.setDoctorAsignado(nuevoDoctor);
    }

    public void mostrarPacientesEntreFechas(String fechaInicio, String fechaFin) {
        // select * from pacientes where fecha_ingreso >= '2011/02/25' and fecha_ingreso <= '2024/02/27'
        String consulta = "select * from pacientes where fecha_ingreso >= '" + fechaInicio +
                "' and fecha_ingreso <= '" + fechaFin + "'" ;
        ResultSet resultSet = DbHelper.consultaConRes(consulta);
        imprimirPacientes(resultSet);
    }

    public void eliminarPaciente(String nombre){
        String consulta = "DELETE FROM pacientes WHERE nombre = '" + nombre + "'";
        DbHelper.consultaSinRes(consulta);
        // System.out.println("Paciente '"+ nombre.toUpperCase() +"' eliminado de la BD.");
    }

    public void cargardesdeBD(){
        String consultaDoc = "select * from doctores;";
        String consultaPac = "select * from pacientes;";

        ResultSet resultDoc = DbHelper.consultaConRes(consultaDoc);
        ResultSet resultPac = DbHelper.consultaConRes(consultaPac);

        try {
            // CARGA DE DOCTORES PRIMERO
            while (resultDoc.next()){
                listaDoctores.add( new Doctor(
                        resultDoc.getInt("id"),
                        resultDoc.getString("nombre"),
                        resultDoc.getInt("edad"),
                        resultDoc.getString("especialidad")
                ));
            }

            // CARGA DE PACIENTES
            while (resultPac.next()) {
                Paciente paci = new Paciente(resultPac.getInt("id"));  // asigno los atributos
                paci.setNombre(resultPac.getString("nombre"));         // que se suponen son obligatorios
                paci.setEdad(resultPac.getInt("edad"));

                if (resultPac.getString("historial_medico") != null ){
                    paci.setHistorialMedico(resultPac.getString("historial_medico"));
                }
                if (resultPac.getString("fecha_ingreso") != null){
                    paci.setFecha_ingreso(resultPac.getString("fecha_ingreso"));
                }

                for (Doctor doc : listaDoctores){       // asignar doctor tomando el ID
                    if (doc.getId() == resultPac.getInt("doctor") ) {
                        asignarDoctorCabecera(paci, doc);
                        break;
                    }
                }
                listaPacientes.add(paci);       // agrego el paciente con todos sus datos a la lista
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
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

    //public static int sigId = 1;

    public Persona() {
        //..
    }
    public Persona(int id) {
        this.id = id;
    }

    public Persona(int id, String nombre){
        this.id = id++;
        this.nombre = nombre;
    }
    public Persona(int id, String nombre, int edad){
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
    }
    public Persona(String nombre, int edad){
        this.nombre = nombre;
        this.edad = edad;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public int getEdad() {
        return edad;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return id + ", " + nombre.toUpperCase() + ", " + edad;
    }
}

class Paciente extends Persona {
    private String historialMedico, fecha_ingreso;
    private Doctor doctorAsignado;

    public Paciente(int id) {
        super(id);
    }
    public Paciente(int id, String nombre){
        super(id, nombre);
    }
    public Paciente(int id, String nombre, int edad){
        super(id, nombre, edad);
    }
    public Paciente(int id, String nombre, int edad, String historial){
        super(id, nombre, edad);
        this.historialMedico = historial;
    }
    public Paciente(int id, String nombre, int edad, String historial, String fecha_ingreso, Doctor doctor){
        super(id, nombre, edad);
        this.historialMedico = historial;
        this.fecha_ingreso = fecha_ingreso;
        this.doctorAsignado = doctor;
    }

    public String getHistorialMedico() {
        return historialMedico;
    }

    @Override
    public String toString() {
        return "[" + super.toString() + ", "+ historialMedico + ", " + fecha_ingreso +
                ", Doctor -> (" +  doctorAsignado.getNombre().toUpperCase() + ") ]";
    }

    public void setFecha_ingreso(String fecha_ingreso) {
        this.fecha_ingreso = fecha_ingreso;
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

    public String getFecha_ingreso() {
        return fecha_ingreso;
    }
}

class Doctor extends Persona {
    private String especialidad;

    public Doctor () {
        // ..
    }
    public Doctor (int id) {
        super(id);
    }
    public Doctor (int id, String nombre, int edad) {
        super(id, nombre, edad);
        this.setId(id);
    }
    public Doctor (int id, String nombre, int edad, String especialidad) {
        super(id, nombre, edad);
        this.setId(id);
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

class DbHelper {
    private static String url = "jdbc:mysql://localhost:3306/hospital_db";
    private static String usuario = "root";
    private static String passw = "";

    private static Connection conex;
    private static Statement stat;

    public static void consultaSinRes(String consultaParam) {
        try {
            conex = DriverManager.getConnection(url, usuario, passw);
            stat = conex.createStatement();
            stat.executeUpdate(consultaParam);

        } catch (SQLException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }
    public static ResultSet consultaConRes(String consultaParam){
        ResultSet result = null;
        try {
            conex = DriverManager.getConnection(url, usuario, passw);
            stat = conex.createStatement();
            result = stat.executeQuery(consultaParam);

        } catch (SQLException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
        return result;
    }
}