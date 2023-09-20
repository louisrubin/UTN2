package POO.TrabajoIntegradorP1;

// interface mascotas
public abstract class Animal {
    protected double peso;
    public static String[] listaHabitats = {"terrestre", "acuatico", "aereo", "hibrido"};

    public abstract void hacerRuido();
    public abstract void comer();
    public abstract void pierdeUnaPata();
}
