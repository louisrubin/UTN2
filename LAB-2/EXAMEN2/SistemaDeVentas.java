package Examen2LAB;

import java.sql.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

// Vendedor vendedorBuscado = new Vendedor("SELECT * FROM `vendedores` WHERE `vendedor_id` = 3");

public class SistemaDeVentas {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Producto prod2 = Productos.obtenerProductoMasVendido();
        System.out.println(prod2);

        System.out.println(Comerciales.listadoDeVendedores());

    }


}

class Productos {
    public static void generarInforme(){
        String consulta = "SELECT * FROM productos";

        ResultSet resul = DBHelper.consultaConRes(consulta);
        System.out.println("Informe de Productos en Stock:");
        System.out.println("Producto\t\t\t\tStock\tPrecio\tTotal");
        System.out.println("--------------------------------------------------------------");

        double total = 0, precioUnid, valorTotalUnid;
        DecimalFormat df = new DecimalFormat("#.##");

        try {
            while (resul.next()){
                precioUnid = resul.getDouble("precio_por_unidad");
                valorTotalUnid = precioUnid * resul.getInt("stock");

                System.out.println(resul.getString("nombre") + "\t\t\t" +
                        resul.getInt("stock") + "\t" + precioUnid +
                        "\t" + df.format(valorTotalUnid)
                );
                total += valorTotalUnid;    // acumulador
            }
            System.out.println("--------------------------------------------------------------");
            System.out.println("\t\t\t\t\t" + "Total:" + "\t\t\t" + df.format(total));

        } catch (SQLException e ){
            System.out.println("Error (SistemaDeVentas) en la DB -> " + e.getMessage());
        }
    }

    public static Producto obtenerProducto(int productoID){
        // SELECT * FROM productos WHERE producto_id = 12
        String consulta = "SELECT * FROM productos WHERE producto_id = " + productoID +";";
        Producto producto = new Producto(consulta);

        if (producto.getNombre() == null) return null;
        return producto;
    }

    public static Producto obtenerProductoMasVendido() {
        ResultSet masVend = DBHelper.consultaConRes("SELECT producto_id, SUM(cantidad_vendida) as total_vendido" +
                " FROM ventas" +
                " GROUP BY producto_id" +
                " ORDER BY total_vendido DESC" +
                " LIMIT 1");

        try{
            if (masVend.next()){
                return Productos.obtenerProducto(masVend.getInt("producto_id"));
            }
        } catch (SQLException e){
            System.out.println("error -> "+e.getMessage());
        }
        return null;
    }
}

class Comerciales {

    public static Vendedor obtenerVendedorPorID(int vendedorID) {
        String consulta = "SELECT * FROM vendedores WHERE vendedor_id =" + vendedorID + ";";
        //ResultSet result = DBHelper.consultaConRes(consulta);
        Vendedor vendedor = new Vendedor(consulta);

        if (vendedor.getNombre() == null ) return null;
        return vendedor; // en caso de que la consulta sea opuesta a resultado != null && resultado.next()
    }

    public static ArrayList<Vendedor> listadoDeVendedores() {
        ArrayList<Vendedor> vendedores = new ArrayList<Vendedor>();
        String consulta = "SELECT * FROM vendedores";
        ResultSet res = DBHelper.consultaConRes(consulta);

        try {
            while (res.next()){
                vendedores.add(new Vendedor(
                        res.getInt("vendedor_id"),
                        res.getString("nombre"),
                        res.getString("apellido"),
                        res.getInt("dni"),
                        res.getString("fecha_nacimiento"),
                        res.getString("fecha_contratacion")
                ));
            }
        }catch (SQLException e ){
            System.out.println("Error ArrayList VENDEDOR -> " + e.getMessage());
         }
         return vendedores;
    }
}

class Vendedor {
    private int id, dni;
    private String nombre, apellido, fecha_nac, fecha_contrat;

    public Vendedor(int id, String nombre, String apellido, int dni, String fecha_nac, String fecha_contrat){
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.fecha_nac = fecha_nac;
        this.fecha_contrat = fecha_contrat;

    }

    public Vendedor(String consultaBusqueda){
        try {
            ResultSet res = DBHelper.consultaConRes(consultaBusqueda);

            if (res.next()){
                this.id = res.getInt("vendedor_id");
                this.nombre = res.getString("nombre");
                this.apellido = res.getString("apellido");
                this.dni = res.getInt("dni");
                this.fecha_nac = res.getString("fecha_nacimiento");
                this.fecha_contrat = res.getString("fecha_contratacion");
            } else {
                return;
            }

        } catch (SQLException e ){
            System.out.println("Error (Class Vendedor) en la BD -> " + e.getMessage());
        }
    }

    @Override
    public String toString() {
        return "[" + id + ", "+nombre.toUpperCase()+", " + apellido.toUpperCase()+", " + dni +", " + fecha_nac +", " + fecha_contrat + "]";
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public int getDni() {
        return dni;
    }

    public String getApellido() {
        return apellido;
    }

    public String getFecha_contrat() {
        return fecha_contrat;
    }

    public String getFecha_nac() {
        return fecha_nac;
    }
}

class Producto {

    private int id, stock;
    private double precio_por_unidad;
    private String nombre;

    public Producto(int id, String nombre, double precio_por_unidad, int stock) {
        this.id = id;
        this.nombre = nombre;
        this.precio_por_unidad = precio_por_unidad;
        this.stock = stock;
    }

    public Producto(String consultaBusqueda){
        try {
            ResultSet res = DBHelper.consultaConRes(consultaBusqueda);

            if (res.next()){
                this.id = res.getInt("producto_id");
                this.nombre = res.getString("nombre");
                this.precio_por_unidad = res.getDouble("precio_por_unidad");
                this.stock = res.getInt("stock");

            } else {
                return;
            }

        } catch (SQLException e ){
            System.out.println("Error (Class Producto) en la BD -> " + e.getMessage());
        }
    }

    @Override
    public String toString() {
        return "[" + id + ", " + nombre + ", $" + precio_por_unidad + ", " + stock + "]";
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio_por_unidad() {
        return precio_por_unidad;
    }

    public int getId() {
        return id;
    }

    public int getStock() {
        return stock;
    }
}


class DBHelper {
    //                                          PUERTO 33061
    private static String url = "jdbc:mysql://localhost:33061/ventas";
    private static String usuario = "root";
    private static String passw = "";

    private static Connection conex;
    private static Statement stat;

    public static void consultaSinRes(String consultaParam) {
        try {
            conex = DriverManager.getConnection(url, usuario, passw);
            stat = conex.createStatement();
            stat.executeUpdate(consultaParam);

        } catch (SQLException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }
    public static ResultSet consultaConRes(String consultaParam){
        ResultSet result = null;
        try {
            conex = DriverManager.getConnection(url, usuario, passw);
            stat = conex.createStatement();
            result = stat.executeQuery(consultaParam);

        } catch (SQLException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
        return result;
    }

}