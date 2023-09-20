package POO.TrabajoIntegradorP1;

public class Perro  extends Animal implements Mascota, Terrestre{
    private String nombre="", comidaFav="";
    private int cantPatas = 4;
    protected final String tipoHabitat = listaHabitats[0];  // terrestre

    public Perro(){
        // ..
    }
    public Perro(double peso){
        this.peso = peso;
    }
    public Perro(String nombre){
        this.nombre = nombre;
    }
    public Perro(String nombre, double peso){
        this.nombre = nombre;
        this.peso = peso;
    }
    public Perro(String nombre, String comidaFav){
        this.comidaFav = comidaFav;
        this.nombre = nombre;
    }
    public Perro(String nombre, String comidaFav, double peso){
        this.comidaFav = comidaFav;
        this.nombre = nombre;
        this.peso = peso;
    }

    @Override
    public void hacerRuido() {
        if (nombre.isBlank()){
            System.out.println("El PERRO ladra*");
        } else System.out.println(this.nombre + " ladra*");
    }

    @Override
    public void comer() {
        if (comidaFav.isBlank() && nombre.isBlank()){
            System.out.println("El PERRO está comiendo*");
        }
        else if (comidaFav.isBlank() && ! nombre.isBlank()) {
            System.out.println(nombre+ " está comiendo "+comidaFav+ "*");
        }
        else if (nombre.isBlank() && ! comidaFav.isBlank()){
            System.out.println("El PERRO está comiendo "+ comidaFav);
        }
    }

    @Override
    public void acariciar() {
        if (nombre.isBlank()){
            System.out.println("Acariciando al PERRO*");
        } else  System.out.println("Acariciando a "+this.nombre +"*");
    }

    @Override
    public void alimentar() {
        // verifica los campos 'nombre' y 'comidaFav' y muestra un mensaje correspondiente
        if (comidaFav.isBlank() && nombre.isBlank()){
            System.out.println("Alimentando al PERRO*");
        }
        else if (comidaFav.isBlank() && ! nombre.isBlank()) {
            // si solo comidaFav está vacio
            System.out.println("Alimentando a "+nombre+ "*");
        }
        else if (nombre.isBlank() && ! comidaFav.isBlank()){
            System.out.println("El PERRO está comiendo "+ comidaFav + "*");
        }
    }

    @Override
    public void bañarlo() {
        if (nombre.isBlank()){
            System.out.println("Bañando al PERRO*");
        } else System.out.println("Bañando a "+this.nombre +" y lo disfruta*");
    }

    @Override
    public void jugarConEl() {
        if (nombre.isBlank()){
            System.out.println("Lanzando una pelota y el PERRO lo trae*");
        } else  System.out.println("Lanzando una pelota y "+this.nombre +" lo devuelve*");
    }

    @Override
    public void correr() {
        if (nombre.isBlank()){
            System.out.println("El PERRO está corriendo*");
        } else System.out.println(nombre + " está corriendo*");
    }

    @Override
    public void saltar() {
        if (nombre.isBlank()){
            System.out.println("El PERRO acaba de saltar*");
        } else System.out.println(nombre + " acaba de saltar*");
    }

    @Override
    public void mojarse() {
        if (nombre.isBlank()){
            System.out.println("El PERRO ama mojarse*");
        } else System.out.println(nombre + " ama mojarse*");
    }
    @Override
    public void pierdeUnaPata() {
        if (this.cantPatas > 0) this.cantPatas--;
    }
    public String getNombre() {
        return nombre;
    }

    public String getComidaFav() {
        return comidaFav;
    }

    public int getCantPatas() {
        return cantPatas;
    }
    public String getHabitat(){
        return this.tipoHabitat;
    }
    public double getPeso(){
        return this.peso;
    }

    public void setComidaFav(String comidaFav) {
        this.comidaFav = comidaFav;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public static void main(String[] args) {
        Perro p = new Perro(8.3);
        p.hacerRuido();
    }
}
