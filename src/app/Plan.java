package app;

import java.util.ArrayList;
import java.util.Scanner;

public class Plan {
	protected String codigo;
	protected String nombre;
	protected String nivel_dificultad;
	protected int cantidad_sesiones;

    public Plan(String codigo, String nombre, String nivel_dificultad, int cantidad_sesiones) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.nivel_dificultad = nivel_dificultad;
        this.cantidad_sesiones = cantidad_sesiones;
    }

    public Plan() {
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNivel_dificultad() {
        return nivel_dificultad;
    }

    public void setNivel_dificultad(String nivel_dificultad) {
        this.nivel_dificultad = nivel_dificultad;
    }

    public int getCantidad_sesiones() {
        return cantidad_sesiones;
    }

    public void setCantidad_sesiones(int cantidad_sesiones) {
        this.cantidad_sesiones = cantidad_sesiones;
    }

    public void consultarDatos() {
    	System.out.println("---------------------------");
        System.out.println("Código: " + codigo);
        System.out.println("Nombre: " + nombre);
        System.out.println("Nivel de dificultad: " + nivel_dificultad);
        System.out.println("Cantidad de sesiones: " + cantidad_sesiones);
    }

    public static void registrarPlan(ArrayList<Plan> planes, Scanner sc) {
        System.out.print("Codigo: "); 
        String codigo = sc.nextLine();

        for (Plan p : planes) {
            if (p.codigo.equalsIgnoreCase(codigo)) {
                System.out.println("Plan duplicado");
                return;
            }
        }

        System.out.print("Nombre: ");
        String nombre = sc.nextLine();

        System.out.print("Nivel de dificultad: ");
        String nivel = sc.nextLine();

        int sesiones;
        try {
            System.out.print("Cantidad de sesiones: ");
            sesiones = Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Cantidad invalida");
            return;
        }

        if (sesiones <= 0) {
            System.out.println("Cantidad invalida");
            return;
        }

        planes.add(new Plan(codigo, nombre, nivel, sesiones));
        System.out.println("Plan agregado correctamente");
    }
}
