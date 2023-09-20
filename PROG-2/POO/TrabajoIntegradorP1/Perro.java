package POO.TrabajoIntegradorP1;

public class Perro  extends Animal implements Mascota, Terrestre{
    private String nombre, comidaFav="";
    private int cantPatas = 4;

    public Perro(String nombre){
        this.nombre = nombre;
        this.tipoHabitat = listaHabitats[0];
    }
    public Perro(String nombre, double peso){
        this.nombre = nombre;
        this.tipoHabitat = listaHabitats[0];
        this.peso = peso;
    }
    public Perro(String nombre, String comidaFav){
        this.comidaFav = comidaFav;
        this.nombre = nombre;
        this.tipoHabitat = listaHabitats[0];
    }
    public Perro(String nombre, String comidaFav, double peso){
        this.comidaFav = comidaFav;
        this.nombre = nombre;
        this.peso = peso;
        this.tipoHabitat = listaHabitats[0];
    }

    @Override
    public void hacerRuido() {
        System.out.println(this.nombre + " ladra*");
    }

    @Override
    public void comer() {
        if (comidaFav.isEmpty()) System.out.println(nombre + " está comiendo*");
        else System.out.println(nombre + " está comiendo "+ comidaFav);
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
        System.out.println("Bañando a "+this.nombre +" y lo disfruta*");
    }

    @Override
    public void jugarConEl() {
        System.out.println("Lanzando una pelota y "+this.nombre +" lo devuelve*");
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
        System.out.println(nombre + " ama el agua*");
    }
    @Override
    public void pierdeUnaPata() {
        this.cantPatas--;
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
        Perro p = new Perro("colita", 8.3);
        p.hacerRuido();
        p.alimentar();
        System.out.println(p.getPeso());
        System.out.println(p.getCantPatas());
        p.pierdeUnaPata();
        System.out.println(p.getCantPatas());
        p.setNombre("goku");
        p.hacerRuido();
    }
}
