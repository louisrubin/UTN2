package ExamenParcial1;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Hospital {
    String nombreHospital = "Hospital Julio C. Perrando";
    String direccion = "Av. 9 de Julio 1100", tel = "0362 444-2399";


    ArrayList<Doctor> doctores = new ArrayList<Doctor>();
    ArrayList<Paciente> pacientes = new ArrayList <Paciente>();

    public Hospital(){
        doctores.add(Doctor.doc1);
        doctores.add(Doctor.doc2);
        doctores.add(Doctor.doc3);
    }

    public void listarDoctores(){
        for (Doctor d : doctores){
            System.out.println("\t" +d.toString());
        }
    }

    public void registrarPaciente(Scanner sc){
        try {
            System.out.print("DNI paciente: ");
            int dni = sc.nextInt();
            sc.nextLine();  // limpiar buffer

            System.out.print("Nombre Paciente: ");
            String nombre = sc.nextLine();

            System.out.print("Fecha Nacimiento: ");
            String fechaNac = sc.nextLine();
            pacientes.add( new Paciente(dni, nombre, fechaNac) );

        } catch (Exception e){
            System.out.println("No se pudo registrar al paciente.");
        }
    }

    public void listarPacientes(){
        for (Paciente p : pacientes){
            System.out.println("\t" +p.toString());
        }
    }

    public void updateInfoPaciente(Scanner sc) {
        System.out.print("Ingrese el DNI del paciente: ");
        int dniPaciente = sc.nextInt();
        sc.nextLine();  // limpiar buffer

        for (Paciente p : pacientes){
            if (p.dni == dniPaciente){
                System.out.println(" Enter y 0 para omitir");

                System.out.print("Nuevo nombre: ");
                String nuevoNombre = sc.nextLine();

                System.out.print("Nueva fecha Nacimiento: ");
                String nuevoFechaNac = sc.nextLine();


                sc.nextLine();  // limpiar buffer

                p.setNombre(nuevoNombre);
                p.setFechaNac(nuevoFechaNac);

                return;

            } else System.out.println(" No existe ese DNI. ");
        }

    }
    public void consultarHistorial(Scanner sc){
        System.out.print("Ingrese ID de paciente: ");
        int idBuscado = sc.nextInt();
        sc.nextLine();
        for (Paciente p : pacientes){
            if (p.dni == idBuscado) {
                System.out.println("HISTORIAL MEDICO:");
                for (HistorialClin histClin : p.historialClins) histClin.toString();
                return;
            } else System.out.println("No existe esa ID de paciente.");
        }
    }

    public void newHistorialMed(Scanner sc){
        System.out.print("DNI del paciente: ");
        int dniPac = sc.nextInt();
        sc.nextLine();
        System.out.print("Fecha: ");
        String fechaHist = sc.nextLine();
        System.out.print("Observacion: ");
        String observ = sc.nextLine();

        for (Paciente p : pacientes){
            if (p.dni == dniPac) {
                p.addHistorial( new HistorialClin(fechaHist, observ) );
                System.out.println("historia clinica agregada.");
                return;
            } else System.out.println("no existe un paciente con ese DNI");
        }
    }



    public static void main(String[] args) {
        Hospital hospital = new Hospital();
        Scanner sc = new Scanner(System.in);


        while (true) {
            System.out.println("-----------------------------------------------");
            System.out.println(hospital.nombreHospital + " - "+
                    hospital.direccion + " · "+ hospital.tel);
            System.out.println("Menu:");
            System.out.print(" 1. Listar Doctores\n" +
                            " 2. Registrar un nuevo paciente.\n" +
                            " 3. Actualizar información personal de un paciente\n" +
                            " 4. Consultar el historial medico de un paciente\n" +
                            " 5. Nuevo historial para un paciente.\n" +
                            " 6. Guardar Historial de pacientes en archivo.\n" +
                            " 7. Cargar Historial de pacientes desde archivo.\n" +
                            " 8. Salir.\n" +
                            " ->> "
                    );
            int opc = sc.nextInt();

            System.out.println("-----------------------------------------------");
            sc.nextLine();

            switch (opc) {
                case 1:
                    hospital.listarDoctores();
                    break;
                case 2:
                    hospital.registrarPaciente(sc);
                    // todo kjsadsadasdsadasd
                    break;
                case 3:
                    hospital.updateInfoPaciente(sc);
                    break;
                case 4:
                    break;

                case 5:
                    hospital.newHistorialMed(sc);
                    break;

                case 6:
                    try{

                        ObjectOutputStream objectOutputStream = new ObjectOutputStream( new FileOutputStream("hospital.txt"));
                        objectOutputStream.writeObject(hospital);
                        System.out.println("serializado con exito.");
                    }
                    catch (Exception e){
                        System.out.println("Error al guardar las reservas. ->> "+ e.getMessage());
                    }

                    break;

                case 7:
                    try {
                        ObjectInputStream objectInputStream = new ObjectInputStream( new FileInputStream("hospital.txt"));
                        Hospital deserializado = (Hospital) objectInputStream.readObject();

                        hospital = deserializado;
                        System.out.println("hospital deserializado con exito.");
                    }catch (Exception e){
                        System.out.println("Error al cargar las reservas. ->> "+ e.getMessage());
                    }

                    break;

                case 8:
                    System.exit(0);
                    break;
            }
        }

    }

}

abstract class Persona {
    public String nombre, fechaNac;
    public int dni;


    public Persona () {
    }

    public Persona(int dni, String nombre, String fechaNac ) {
        this.dni = dni;
        this.nombre = nombre;
        this.fechaNac = fechaNac;
    }
    public Persona(int dni, String nombre) {
        this.dni = dni;
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setFechaNac(String fechaNac) {
        this.fechaNac = fechaNac;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    @Override
    public String toString() {
        return dni + ", nombre=" +nombre + ", nacimiento="+ fechaNac ;
    }
}

class Doctor extends Persona {
    String especialidad;

    public static Doctor doc1 = new Doctor(13526852, "Juan", "18/06/1985" , "Cardiologo");
    public static Doctor doc2 = new Doctor(24526395, "Samanta", "01/11/1997" ,"Enfermera");
    public static Doctor doc3 = new Doctor(20879526, "Jose", "28/09/1990" ,"Cirujano");


    public Doctor(int dni, String nombre, String fechaNac,  String especialidad) {
        this.dni = dni;
        this.nombre = nombre;
        this.fechaNac = fechaNac;
        this.especialidad = especialidad;

    }

    @Override
    public String toString() {
        return "[" + super.toString() + ", especialidad=" + especialidad + "]";
    }
}

class Paciente extends Persona implements Informacion {
    int telefono, tipoSangre;
    ArrayList<HistorialClin> historialClins = new ArrayList<HistorialClin>();

    public Paciente(int dni, String nombre, String fechaNac, int tel, int tipoSangre) {
        this.dni = dni;
        this.nombre = nombre;
        this.fechaNac = fechaNac;
        this.telefono = tel;
        this.tipoSangre = tipoSangre;
    }
    public Paciente(int dni, String nombre, String fechaNac) {
        this.dni = dni;
        this.nombre = nombre;
        this.fechaNac = fechaNac;
    }

    public void addHistorial( HistorialClin newHistorial ) {
        historialClins.add(newHistorial);
    }

    @Override
    public String toString() {
        return "[" + super.toString() + ", telefono="+telefono+", tipoSangre=" + tipoSangre +"]";
    }

    @Override
    public void verHistorialDeEventos() {
        for (HistorialClin historialClin : historialClins) historialClin.toString();
    }
}

class HistorialClin {
    String fecha, observ;

    public HistorialClin (String fecha) {
        this.fecha = fecha;
    }
    public HistorialClin (String fecha, String observ) {
        this.fecha = fecha;
        this.observ = observ;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return fecha + " - " +observ ;
    }
}

interface Informacion {
    void verHistorialDeEventos();
}