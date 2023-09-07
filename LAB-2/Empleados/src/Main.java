/*
6. Implementa un programa principal (`main`) que permita al usuario agregar, modificar o editar empleados y calcular
sus sueldos e impuestos. Asegúrate de manejar las excepciones adecuadamente, por ejemplo, si el usuario ingresa
un valor no válido para horas trabajadas o ventas realizadas o cualquier otra posibilidad de error. */

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        GestorEmpleados gEmpleado = new GestorEmpleados();
        Scanner sc = new Scanner(System.in);

        int opc, tipoEmpleado;
        do {
            System.out.println("\n---------------------------------------------");
            System.out.println(" 1- Agregar Empleado\n 2- Modificar Empleado\n 3- Calcular Sueldo Empleado" +
                    "\n 4- Calcular Impuesto Empleado\n 5- Salir");
            System.out.print("---------------------------------------------\n Opcion --> ");

            opc = sc.nextInt();
        } while (opc <= 0 && opc > 5);


        switch (opc){
            case 1:
                System.out.println(" Tipo Empleado: 1- Empleado Asalariado 2- Empleado Comision 3- Empleado Por Horas: ");
                tipoEmpleado = sc.nextInt();
                if (tipoEmpleado == 1){
                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();
                    System.out.print("Sueldo: $");
                    double sueldo = sc.nextDouble();
                    EmpleadoAsalariado empAsalariado = new EmpleadoAsalariado(nombre, sueldo);
                    gEmpleado.addEmpleado(empAsalariado);
                }
                if( tipoEmpleado == 2){
                    // (String nombre, double sueldo, int ventasRealizadas, double comisionXventas)
                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();
                    System.out.print("Sueldo: $");
                    double sueldo = sc.nextDouble();
                    System.out.print("Ventas Realizadas: ");
                    int cantVentas = sc.nextInt();
                    System.out.print("Comisión Ventas: %");
                    double comisionVenta = sc.nextDouble();
                    EmpleadoComision empleadoComision = new EmpleadoComision(nombre, sueldo, cantVentas, comisionVenta);
                    gEmpleado.addEmpleado(empleadoComision);
                }
                if (tipoEmpleado == 3){
                    // (String nombre, int horasTrabajadas, double pagoXhoras)
                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();
                    System.out.print("Sueldo: $");
                    double sueldo = sc.nextDouble();
                    System.out.print("Horas trabajadas: ");
                    int cantHoras = sc.nextInt();
                    System.out.print("Pago por Horas: $");
                    double pagoHoras = sc.nextDouble();

                    EmpleadoPorHoras empleadoPorHoras = new EmpleadoPorHoras(nombre, cantHoras, pagoHoras);
                    gEmpleado.addEmpleado(empleadoPorHoras);
                }
        }

        gEmpleado.toString();
    }
}
