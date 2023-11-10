//package EXAMEN2;
import java.util.ArrayList;
import java.sql.*;
// import java.util.Scanner;

// https://docs.google.com/document/d/129jn4i_uvzkT1SyUb-AAr63MUdk4ScwRs8z_8QSLjww/edit
// https://classroom.google.com/w/NTA1NjEyNzgwNTU0/t/all
// https://mariadb.com/downloads/connectors/connectors-data-access/java8-connector/

public class Modelo2doExamen {  // HOSPITAL
    private ArrayList<Paciente> listaPacientes;
    private ArrayList<Doctor> listaDoctores;


    public static void main(String[] args) {
        String url = "jdbc:mariadb://localhost:33061/hospital_db";
        String usuario = "root";
        String passw = "";

        Modelo2doExamen hospital = new Modelo2doExamen();

        // todo AGREGAR CONSTRUCTORES QUE NO ACEPTEN ID PARA AL AGREGAR EN LA BD SE ASIGNE AUTO

        Paciente paciente = new Paciente(4, "juan", 27);

        try {
            Connection conexion = DriverManager.getConnection(url, usuario, passw);

            hospital.cargardesdeBD(conexion);
            // hospital.imprimirPacientes();
            hospital.asignarDoctorCabecera(paciente, hospital.listaDoctores.get(1));
            //hospital.agregarPaciente(paciente, conexion);
            hospital.imprimirPacientes();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Modelo2doExamen(){
        listaDoctores = new ArrayList <>();
        listaPacientes = new ArrayList <>();
    }

    public void agregarPaciente(Paciente paciente, Connection conex){
        String consulta = "INSERT INTO pacientes (id, nombre, edad, historial_medico, doctor)" +
                " VALUES ("+ paciente.getId() + ",'" + paciente.getNombre() + "',"
                + paciente.getEdad() + ",'"+ paciente.getHistorialMedico() +
                "'," + paciente.getDoctorAsignado().getId() + ");";
        System.out.println(consulta);

        try {
            Statement stat = conex.createStatement();
            stat.executeUpdate(consulta);      // executeUpdate
            listaPacientes.add(paciente);

            stat.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void imprimirPacientes(){
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

    public void cargardesdeBD(Connection conex){
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

    private static String consulta;

    private static Connection conex;
    private static Statement stat;

    public static void consultaSinRes(String consultaParam) {
        try {
            conex = DriverManager.getConnection(url, usuario, passw);
            stat = conex.createStatement();
            stat.executeUpdate(consultaParam);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static ResultSet consultaConRes(String consultaParam){
        ResultSet result = null;
        try {
            conex = DriverManager.getConnection(url, usuario, passw);
            stat = conex.createStatement();
            result = stat.executeQuery(consultaParam);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}