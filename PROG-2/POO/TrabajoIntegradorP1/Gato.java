package POO.TrabajoIntegradorP1;

public class Gato extends Animal implements Terrestre, Mascota{
    private String nombre, comidaFav="";
    private int cantPatas = 4;

    public Gato(String nombre){
        this.nombre = nombre;
        this.tipoHabitat = listaHabitats[0];
    }
    public Gato(String nombre, double peso){
        this.nombre = nombre;
        this.tipoHabitat = listaHabitats[0];
        this.peso = peso;
    }
    public Gato(String nombre, String comidaFav){
        this.comidaFav = comidaFav;
        this.nombre = nombre;
        this.tipoHabitat = listaHabitats[0];
    }
    public Gato(String nombre, String comidaFav, double peso){
        this.comidaFav = comidaFav;
        this.nombre = nombre;
        this.peso = peso;
        this.tipoHabitat = listaHabitats[0];
    }

    @Override
    public void hacerRuido() {
        System.out.println(nombre + " maulla*");
    }

    @Override
    public void comer() {
        if (comidaFav.isEmpty()) System.out.println(nombre + " está comiendo*");
        else System.out.println(nombre + " está comiendo "+ comidaFav);
    }

    @Override
    public void correr() {
        System.out.println(nombre + " está corriendo*");
    }

    @Override
    public void saltar() {
        System.out.println(nombre + " acaba de saltar*");
    }

    @Override
    public void mojarse() {
        System.out.println(nombre + " huyó del agua*");
    }

    @Override
    public void acariciar() {
        System.out.println("Acariciando a "+this.nombre +"*");
    }

    @Override
    public void alimentar() {
        if (this.comidaFav.isEmpty()) System.out.println("Dando de comer a "+this.nombre +"*");
        else System.out.println("Dando de comer "+ this.comidaFav+ " a "+this.nombre +"*");
    }

    @Override
    public void bañarlo() {
        System.out.println("Bañando a "+this.nombre +" con dificultad*");
    }

    @Override
    public void jugarConEl() {
        System.out.println("Jugando con un laser mientras "+this.nombre +" lo persigue*");
    }
    @Override
    public void pierdeUnaPata(){
        this.cantPatas--;
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
