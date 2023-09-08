import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class Archivos {

    public static void main(String[] args) {
        String nombreArchivo = "pruebaDeArchivo.txt";
        Scanner sc = new Scanner(System.in);

        try{
            File archivo = new File("LAB-2" + File.separator + "Archivos" +File.separator+ "src" + File.separator );

            if (archivo.exists()){
                System.out.println(" - ARCHIVO ENCONTRADO -");
                System.out.print(" 1- LEER ARCHIVO\n 2- ESCRIBIR ARCHIVO\n --> ");
                try {
                    int opc = sc.nextInt();
                    if(opc == 1 ){
                        //   LECTURA
                        leerArchivo(archivo.getAbsolutePath() + File.separator + nombreArchivo);
                    } else if (opc == 2) {
                        crearEscribir(archivo.getAbsolutePath() + File.separator + nombreArchivo);
                    } else {
                        System.out.println(" OPCION INCORRECTA.");
                    }
                } catch (Exception e){
                    System.out.println("TIPO DE DATO INCORRECTO.");
                }


            } else {
                crearEscribir(archivo.getAbsolutePath() + File.separator + nombreArchivo);
                System.out.println("ARCHIVO CREADO.");
            }
        } catch (Exception e ){
            e.printStackTrace();
        }
    }
    private static void crearEscribir(String pathParam ){
        // metodo para crear el archivo
        Scanner sc = new Scanner(System.in);
        try{
            FileWriter fwriter = new FileWriter(pathParam, true);
                                                    // true: 'si no existe crear,
                                                    // sino agrega el texto al final
            System.out.println(pathParam);
            // ESCRITURA
            System.out.print("INGRESE TEXTO: ");
            String texto = " - " + sc.nextLine();

            for (int x =0; x < texto.length(); x++){
                fwriter.write(texto.charAt(x));
            }
            fwriter.close();        // debo cerrar el primer buffer para que funcione el siguiente (?
        } catch (Exception e){
            System.out.println("HUBO UN ERROR AL ESCRIBIR EL ARCHIVO.\n " + e.getMessage());
        }
    }
    private static void leerArchivo(String pathParam){
        try{
            // un buffer "FileReader"
            FileReader file = new FileReader(pathParam);
            int caracter = file.read();     // obtenemos el codigo del caracter actual (int)
            char letra = (char)caracter;    /* acá transformamos el codigo del caracter en
                                                el caracter propimamente dicho  */
            while (caracter != -1){
                System.out.print(letra);
                caracter = file.read(); // de nuevo hacemos la lectura del código
                // del SIGUIENTE CARACTER y avanza
                letra = (char)caracter; // transformamos el codigo en el caracter
            }
            System.out.println();
            file.close();
        } catch (Exception e){
            System.out.println("HUBO UN ERROR AL LEER EL ARCHIVO.\n " + e.getMessage());
        }
    }
}
