package EjemParcial1;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

public interface Serializable {
    String archivo =  "LAB-2" + File.separator + "EjemParcial1" + File.separator + "concesionaria.txt";

    void serializar(Concesionaria concesionaria);  // guardar concesionaria
    Concesionaria deserializar();    // cargar concesionaria
}
