import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class Archivos {

    public static void main(String[] args) {
        String archivoTxt = "prueba.txt";

        try{

            // ESCRITURA
            Scanner sc = new Scanner(System.in);
            System.out.print("TEXTO: ");
            String texto = sc.nextLine();

            FileWriter fwriter = new FileWriter("src\\" + archivoTxt, true);
                                                                            // true: 'si no existe crear,
                                                                            // sino agrega el texto al lado

            for (int x =0; x <texto.length(); x++){
                fwriter.write(texto.charAt(x));
            }
            fwriter.write("\n");
            fwriter.close();        // debo cerrar el primer buffer para que funcione el siguiente (?


            //   LECTURA
            // un buffer "FileReader"
            FileReader file = new FileReader("src\\" + archivoTxt);
            int caracter = file.read();     // obtenemos el codigo del caracter actual (int)
            char letra = (char)caracter;    /* acá transformamos el codigo del caracter en
                                                el caracter propimamente dicho

            */

            while (caracter != -1){
                System.out.print(letra);
                caracter = file.read(); // de nuevo hacemos la lectura del código
                                        // del SIGUIENTE CARACTER y avanza
                letra = (char)caracter; // transformamos el codigo en el caracter
            }
            file.close();


        } catch (Exception e ){
            e.printStackTrace();
        }

    }
}
