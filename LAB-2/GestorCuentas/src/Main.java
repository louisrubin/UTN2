import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        GestorCuentas gestorCuentas = new GestorCuentas();

        int opc, nroCuenta;
        String nombre, apellido, tipoEmpresa;

        do {
            System.out.println("-----------------------------------------------");
            System.out.print("1- Crear Cuenta Persona\n2- Crear Cuenta Sociedad\n3- Eliminar Cuenta" +
                    "\n4- Editar Cuenta\n5- Listar todas las Cuentas\n6- SALIR\n  --> ");
            opc= sc.nextInt();
            System.out.println("-----------------------------------------------");

            sc.nextLine(); // Agregar esta línea para consumir la línea vacía despues de presionar ENTER

            switch (opc){
                case 1:
                    System.out.print("Nombre: ");
                    nombre = sc.nextLine();
                    System.out.print("Apellido: ");
                    apellido = sc.nextLine();

                    gestorCuentas.agregarCuentaPersona(new CuentaPersona(nombre, apellido));
                    break;

                case 2:
                    System.out.print("Nombre: ");
                    nombre = sc.nextLine();
                    System.out.print("Tipo Empresa: ");
                    tipoEmpresa = sc.nextLine();

                    gestorCuentas.agregarCuentaSociedad(new CuentaSociedad(nombre, tipoEmpresa));
                    break;

                case 3:
                    System.out.print("Ingrese Nro Cuenta: ");
                    nroCuenta = sc.nextInt();

                    gestorCuentas.eliminarUnaCuenta(nroCuenta);
                    break;

                case 4:
                    System.out.print("Ingrese Nro Cuenta: ");
                    nroCuenta = sc.nextInt();

                    gestorCuentas.editarUnaCuenta(nroCuenta, sc);
                    break;

                case 5:
                    gestorCuentas.mostrarTodasLasCuentas();
                    break;

                case 6:
                    sc.close();
                    System.exit(0);
            }
        } while (opc > 0 && opc <=5);

    }
}