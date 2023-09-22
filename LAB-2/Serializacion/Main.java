package Serializacion;

import java.io.*;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Alumno a1 = new Alumno("pepito", 44332214);
        Alumno a2 = new Alumno("chakira", 32548871);
        Alumno a3 = new Alumno("juan carlo bodoque", 15885204);

        Curso curso = new Curso("2°2da IPP");
        curso.agregarAlumno(a1,a2,a3);  // sobrecarga de metodos

        Serializador serial = new Serializador();
        serial.serializar(curso);

        Curso curso2 = serial.deserializar();       // deserializa lo que hay en el archivo "Serializacion.txt"

        System.out.println(curso2.nombreCurso);
        curso2.setNombreCurso("1°6ta CB");

        //System.out.println(curso2.getAlumnos());

        System.out.println(curso2.nombreCurso + "\n"+ curso2.alumnos);
    }


}

class Serializador {
    // funciona con variable tipo "Curso"
    private final String archivo =  "LAB-2" + File.separator + "Serializacion" + File.separator + "serializacion.txt";
    public void serializar(Curso curso) throws IOException{
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(archivo));
        objectOutputStream.writeObject(curso);
        objectOutputStream.close();
    }
    public Curso deserializar() throws IOException, ClassNotFoundException{
        Curso curso = null;
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(archivo));
        curso = (Curso) objectInputStream.readObject(); // casteo el return "Objet" del metodo a "Curso"
        objectInputStream.close();
        return curso;
    }
}

class Curso implements Serializable {
    LinkedList<Alumno> alumnos;
    String nombreCurso;

    public Curso(String nombreCurso){
        this.nombreCurso = nombreCurso;
        alumnos = new LinkedList<>();
    }

    public void setNombreCurso(String nombreCurso) {
        this.nombreCurso = nombreCurso;
    }

    public void agregarAlumno(Alumno alum){
        // sobrecarga de metodos 1
        alumnos.add(alum);
    }
    public void agregarAlumno(Alumno alum, Alumno alum2){
        // sobrecarga de metodos 2
        alumnos.add(alum);
        alumnos.add(alum2);
    }
    public void agregarAlumno(Alumno alum, Alumno alum2, Alumno alum3){
        // sobrecarga de metodos 3
        alumnos.add(alum);
        alumnos.add(alum2);
        alumnos.add(alum3);
    }
    public LinkedList<Alumno> getAlumnos() {
        return alumnos;
    }
}

class Alumno implements Serializable{
    private String nombre;
    private int dni;
    public Alumno(String nombre, int dni){
        this.nombre = nombre;
        this.dni = dni;
    }

    public String toString() {
        return "Alumno{" +
                "nombre='" + nombre + '\'' +
                ", dni=" + dni +
                '}';
    }

    public String getNombre() {
        return nombre;
    }

    public int getDni() {
        return dni;
    }
}