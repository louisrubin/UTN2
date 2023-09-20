package POO.TrabajoIntegradorP1;

public class Delfin extends Animal implements Acuatico {
    protected final String tipoHabitat = listaHabitats[1];
    private String nombre="", comidaFav="";
    public Delfin(){

    }
    public Delfin(String nombre){
        this.nombre = nombre;
    }
    public Delfin(String nombre, double peso){
        this.nombre = nombre;
        this.peso = peso;
    }
    public Delfin(String nombre, String comidaFav){
        this.comidaFav = comidaFav;
        this.nombre = nombre;
    }
    public Delfin(String nombre, String comidaFav, double peso){
        this.comidaFav = comidaFav;
        this.nombre = nombre;
        this.peso = peso;
    }


    @Override
    public void nadar() {
        if (nombre.isBlank()) System.out.println("El delfin empieza a nadar*");
        else System.out.println(nombre + " empieza a nadar*");
    }

    @Override
    public void mantenerseBajoAgua() {
        if (nombre.isBlank()) System.out.println("El delfin se mantiene bajo el agua*");
        else System.out.println(nombre + " se mantiene bajo el agua*");
    }

    @Override
    public void hacerRuido() {
        if (nombre.isBlank()) System.out.println("El delfin hace ruido*");
        else System.out.println(nombre + " hace ruido*");
    }

    @Override
    public void comer() {
        // verifica los campos 'nombre' y 'comidaFav' y muestra un mensaje correspondiente
        if (comidaFav.isBlank() && nombre.isBlank()){
            System.out.println("El delfin está comiendo*");
        }
        else if (comidaFav.isBlank() && ! nombre.isBlank()) {
            System.out.println(nombre+ " está comiendo "+comidaFav+ "*");
        }
        else if (nombre.isBlank() && ! comidaFav.isBlank()){
            System.out.println("El delfin está comiendo "+ comidaFav);
        }
    }


    @Override
    public void pierdeUnaPata() {
        // tiene aletas, no patas
        //if (this.cantPatas > 0) this.cantPatas--;
    }

    public String getComidaFav() {
        return comidaFav;
    }

    public String getNombre() {
        return nombre;
    }
    /*
    public int getCantPatas() {
        return cantPatas;
    }
    */
    public String getTipoHabitat() {
        return tipoHabitat;
    }

    public void setComidaFav(String comidaFav) {
        this.comidaFav = comidaFav;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    /*  NO PUEDE CAMBIAR LA CANTIDAD DE PATAS POR TECLADO --> pierdeUnaPata()

    public void setCantPatas(int cantPatas) {
        this.cantPatas = cantPatas;
    }
     */
}
