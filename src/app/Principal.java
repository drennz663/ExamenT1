package app;

import java.util.ArrayList;
import java.util.Scanner;

public class Principal {

    static Scanner sc = new Scanner(System.in);
    static ArrayList<Cliente> clientes = new ArrayList<>();
    static ArrayList<Entrenador> entrenadores = new ArrayList<>();
    public static void main(String[] args) {
        int opcion;
        do {
            System.out.println("=====Inicio de Sesion====");
            System.out.println("1._ Iniciar Sesion");
            System.out.println("0._ Salir");
            opcion = leerEntero("Opcion: ");
            switch(opcion) {
                case 1 :
                    //IniciarSesion();
                    break;
                case 0 :
                    System.out.println("Vuelve pronto!");
                    break;
                default :
                    System.out.println("Opcion no valida");
            }
        } while (opcion != 0);
        sc.close();
    }

    public static void menuPrincipal(){
        int opcion;
        do {
            System.out.println("=====SmartFit360====");
            System.out.println("1._ Gestion de Clientes");
            System.out.println("2._ Gestion de Entrenadores");
            System.out.println("3._ Gestion de Planes");
            System.out.println("4._ Gestion de Sesiones");
            System.out.println("0. Cerrar programa");
            opcion = leerEntero("Opcion: ");
            switch(opcion) {
                case 1 :
                    clienteGestion();
                    break;
                case 2 :
                    entrenadoresGestion();
                    break;
                case 3 :
                    planesGestion();
                    break;
                case 4:
                    sesionGestion();
                    break;
                case 0 :
                    System.out.println("Vuelve pronto!");
                    break;
                default :
                    System.out.println("Opcion no valida");
            }
        } while (opcion != 0);
        sc.close();
    }

    public static void clienteGestion(){
        int opcion;
        do {
            System.out.println("=====Seccion de clientes====");
            System.out.println("1._ Registrar un nuevo cliente");
            System.out.println("2._ Consultar informacion de cliente");
            System.out.println("3._ Asignar cliente a un plan");
            System.out.println("4._ Consultar progreso");
            System.out.println("0. Regresar");
            opcion = leerEntero("Opcion: ");
            switch(opcion) {
                case 1 :
                	Cliente.registrarCliente(clientes, sc);
                    break;
                case 2 :
                    //Consultar
                    break;
                case 3 :
                    //Asignar
                    break;
                case 4:
                    //Progreso
                    break;
                case 0 :
                    break;
                default :
                    System.out.println("Opcion no valida");
            }
        } while (opcion != 0);
        sc.close();
    }

    public static void entrenadoresGestion(){
        int opcion;
        do {
            System.out.println("=====Seccion de Entrenadores====");
            System.out.println("1._ Registrar un nuevo entrenador");
            System.out.println("2._ Consultar informacion de entrenador");
            System.out.println("3._ Generar reportes de seguimiento");
            System.out.println("4._ Asignar Supervisor");
            System.out.println("0. Volver");
            opcion = leerEntero("Opcion: ");
            switch(opcion) {
                case 1 :
                	Entrenador.registrarEntrenador(entrenadores, sc);
                    break;
                case 2 :
                    //consultar
                    break;
                case 3 :
                    //generar
                    break;
                case 4:
                    //asignar
                    break;
                case 0 :
                    break;
                default :
                    System.out.println("Opcion no valida");
            }
        } while (opcion != 0);
        sc.close();
    }

    public static void planesGestion(){
        int opcion;
        do {
            System.out.println("=====Seccion de Planes====");
            System.out.println("1._ Registrar un nuevo plan");
            System.out.println("2._ Consultar datos del plan");
            System.out.println("0. Volver");
            opcion = leerEntero("Opcion: ");
            switch(opcion) {
                case 1 :
                    //registrar
                    break;
                case 2 :
                    //consultar
                    break;
                case 0 :
                    break;
                default :
                    System.out.println("Opcion no valida");
            }
        } while (opcion != 0);
        sc.close();
    }

    public static void sesionGestion(){
        int opcion;
        do {
            System.out.println("=====Seccion de Sesion====");
            System.out.println("1._ Registrar una nueva sesion");
            System.out.println("2._ Consultar detalles de la sesion");
            System.out.println("3._ Marcar sesion como completada");
            System.out.println("0. Volver");
            opcion = leerEntero("Opcion: ");
            switch(opcion) {
                case 1 :
                    //registrar
                    break;
                case 2 :
                    //consultar
                    break;
                case 3 :
                    //completar
                    break;
                case 0 :
                    break;
                default :
                    System.out.println("Opcion no valida");
            }
        } while (opcion != 0);
        sc.close();
    }

    public void consultarProgreso(){

    }

    public static int leerEntero(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            try {
                return Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Ingrese un numero valido");
            }
        }
    }

}
