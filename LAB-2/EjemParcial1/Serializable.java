package EjemParcial1;

import java.io.File;

public interface Serializable {
    String archivo =  "LAB-2" + File.separator + "EjemParcial1" + File.separator + "concesionaria.txt";

    void serializar(Concesionaria concesionaria);  // guardar concesionaria
    Concesionaria deserializar();    // cargar concesionaria
}
