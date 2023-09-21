package POO.TrabajoIntegradorP1;

public class Alcon extends Animal implements Aereo {
    private int cantPatas = 2;
    private String color="";
    private final String tipoHabitat = listaHabitats[2];    // aereo
    private boolean enLasAlturas = false;

    public Alcon(){
        // ..
    }
    public Alcon(String color){
        this.color = color;
    }


    @Override
    public void elevarse() {
        String cadena, cadena2;
        if (color.isBlank()) {
            cadena = "El ALCÓN se elevó a las alturas*";
            cadena2 = "El ALCÓN ya se encuentra en las alturas";
        }
        else{
            cadena = "El ALCÓN "+ color +" se elevó a las alturas*";
            cadena2 = "El ALCÓN "+ color +" ya se encuentra en las alturas";
        }

        // si no está en las alturas
        if (! enLasAlturas){
            System.out.println(cadena);
            enLasAlturas = true;
        } else {
            System.out.println(cadena2);
        }
    }

    @Override
    public void caerEnPicada() {
        String cadena, cadena2;
        if (color.isBlank()) {
            cadena = "El ALCÓN cae en picada*";
            cadena2 = "El ALCÓN no se encuentra en las alturas";
        }
        else{
            cadena = "El ALCÓN "+ color +" cae en picada*";
            cadena2 = "El ALCÓN "+ color +" no se encuentra en las alturas";
        }

        // si no está en las alturas
        if (enLasAlturas){
            System.out.println(cadena);
            enLasAlturas = false;
        } else {
            System.out.println(cadena2);
        }
    }

    @Override
    public void mantenerseEnAire() {
        String cadena;
        if (color.isBlank()) cadena = "El ALCÓN se mantiene en el aire*";
        else cadena = "El ALCÓN "+ color +" se mantiene en el aire*";

        System.out.println(cadena);
    }

    @Override
    public void hacerRuido() {
        String cadena;
        if (color.isBlank()) cadena = "El ALCÓN hace ruido*";
        else cadena = "El ALCÓN "+ color +" hace ruido*";

        System.out.println(cadena);
    }

    @Override
    public void comer() {
        String cadena;
        if (color.isBlank()) cadena = "El ALCÓN está comiendo*";
        else cadena = "El ALCÓN "+ color +" está comiendo*";

        System.out.println(cadena);
    }

    @Override
    public void pierdeUnaPata() {
        if (this.cantPatas > 0) this.cantPatas--;
    }

    public int getCantPatas() {
        return cantPatas;
    }

    public String getTipoHabitat() {
        return tipoHabitat;
    }

    public String getColor() {
        return color;
    }

    public static void main(String[] args) {
        Alcon a = new Alcon();
        Alcon a2 = new Alcon("blanco");
        a.elevarse();
        a.caerEnPicada();
        a.caerEnPicada();

        System.out.println();

        a2.mantenerseEnAire();
        a2.caerEnPicada();
        a2.elevarse();
        a2.mantenerseEnAire();
        a2.hacerRuido();
        a2.caerEnPicada();
    }
}
