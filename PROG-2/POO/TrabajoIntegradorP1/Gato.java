package POO.TrabajoIntegradorP1;

public class Gato extends Animal implements Terrestre, Mascota{
    private String nombre="", comidaFav="";
    private int cantPatas = 4;
    protected final String tipoHabitat = listaHabitats[0];  // terrestre

    public Gato(){
        // ..
    }
    public Gato(double peso){
        this.peso = peso;
    }
    public Gato(String nombre){
        this.nombre = nombre;
    }
    public Gato(String nombre, double peso){
        this.nombre = nombre;
        this.peso = peso;
    }
    public Gato(String nombre, String comidaFav){
        this.comidaFav = comidaFav;
        this.nombre = nombre;
    }
    public Gato(String nombre, String comidaFav, double peso){
        this.comidaFav = comidaFav;
        this.nombre = nombre;
        this.peso = peso;
    }

    @Override
    public void hacerRuido() {
        if (nombre.isBlank()){
            System.out.println("El GATO maulla*");
        } else System.out.println(nombre + " maulla*");
    }

    @Override
    public void comer() {
        // verifica los campos 'nombre' y 'comidaFav' y muestra un mensaje correspondiente
        if (comidaFav.isBlank() && nombre.isBlank()){
            System.out.println("El GATO está comiendo*");
        }
        else if (comidaFav.isBlank() && ! nombre.isBlank()) {
            System.out.println(nombre+ " está comiendo "+comidaFav+ "*");
        }
        else if (nombre.isBlank() && ! comidaFav.isBlank()){
            System.out.println("El GATO está comiendo "+ comidaFav);
        }
    }

    @Override
    public void correr() {
        if (nombre.isBlank()){
            System.out.println("El GATO está corriendo*");
        }else System.out.println(nombre + " está corriendo*");
    }

    @Override
    public void saltar() {
        if (nombre.isBlank()){
            System.out.println("El GATO acaba de saltar*");
        } else System.out.println(nombre + " acaba de saltar*");
    }

    @Override
    public void mojarse() {
        if (nombre.isBlank()){
            System.out.println("El GATO huyó del agua*");
        } System.out.println(nombre + " huyó del agua*");
    }

    @Override
    public void acariciar() {
        if (nombre.isBlank()){
            System.out.println("Acariciando al GATO*");
        } System.out.println("Acariciando a "+this.nombre +"*");
    }

    @Override
    public void alimentar() {
        // verifica los campos 'nombre' y 'comidaFav' y muestra un mensaje correspondiente
        if (comidaFav.isBlank() && nombre.isBlank()){
            System.out.println("Alimentando al GATO*");
        }
        else if (comidaFav.isBlank() && ! nombre.isBlank()) {
            // si solo comidaFav está vacio
            System.out.println("Alimentando a "+nombre+ "*");
        }
        else if (nombre.isBlank() && ! comidaFav.isBlank()){
            System.out.println("El GATO está comiendo "+ comidaFav + "*");
        }
    }

    @Override
    public void bañarlo() {
        if (nombre.isBlank()){
            System.out.println("Bañando al GATO con dificultad*");
        } else System.out.println("Bañando a "+this.nombre +" con dificultad*");
    }

    @Override
    public void jugarConEl() {
        if (nombre.isBlank()){
            System.out.println("Jugando con un laser mientras el GATO lo persigue*");
        } System.out.println("Jugando con un laser mientras "+this.nombre +" lo persigue*");
    }
    @Override
    public void pierdeUnaPata(){
        if (this.cantPatas > 0) this.cantPatas--;
    }
    public String getNombre() {
        return nombre;
    }

    public int getCantPatas() {
        return cantPatas;
    }

    public String getComidaFav() {
        return comidaFav;
    }
    public String getHabitat(){
        return this.tipoHabitat;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setComidaFav(String comidaFav) {
        this.comidaFav = comidaFav;
    }


    public static void main(String[] args) {
        Gato gato = new Gato("minina");
        gato.acariciar();
        System.out.println(gato.tipoHabitat);
    }
}
