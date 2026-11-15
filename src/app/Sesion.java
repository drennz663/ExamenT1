package app;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Sesion {
    private String codigo;
    private LocalDate fecha;
    private int duracion_minutos;
    private String estado;
    private Cliente cliente;
    private Entrenador entrenador;
    private static final int duracion_maxima = 120;
    private static ArrayList<Sesion> sesiones = new ArrayList<>();

    public Sesion(String codigo, LocalDate fecha, int duracion_minutos, String estado, Cliente client, Entrenador entrenador) {
        this.codigo = codigo;
        this.fecha = fecha;
        this.duracion_minutos = duracion_minutos;
        this.estado = estado;
        this.cliente = client;
        this.entrenador = entrenador;
    }

    public Sesion() {
    }

    public Entrenador getEntrenador() {
        return entrenador;
    }

    public void setEntrenador(Entrenador entrenador) {
        this.entrenador = entrenador;
    }

    public Cliente getClient() {
        return cliente;
    }

    public void setClient(Cliente client) {
        this.cliente = cliente;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getDuracion_minutos() {
        return duracion_minutos;
    }

    public void setDuracion_minutos(int duracion_minutos) {
        if (duracion_minutos > 120) {
            throw new IllegalArgumentException("La duración no puede  ser mas  de 120 minutos.");
        }
        this.duracion_minutos = duracion_minutos;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public static void registrarSesion(Scanner sc) {
        System.out.println("Registrar Sesion");

        System.out.print("Codigo: ");
        String codigo = sc.nextLine();

        System.out.print("Fecha (AAAA-MM-DD): ");
        LocalDate fecha = LocalDate.parse(sc.nextLine());

        System.out.print("Duracion en minutos: ");
        int duracion = Integer.parseInt(sc.nextLine());
        if (duracion > duracion_maxima) {
            System.out.println("la duracion maxima es de 120 minutos.");
            return;
        }

        Sesion nuevaSesion = new Sesion(codigo, fecha, duracion, null, null, null);

        sesiones.add(nuevaSesion);

        System.out.println("Sesion registrada correctamente.");
    }

    public static void consultarSesion(Scanner sc) {
        System.out.println("Ingrese el codigo de la sesion:");
        String codigo = sc.nextLine();

        for (Sesion sesion : sesiones) {

            if (sesion.getCodigo().equalsIgnoreCase(codigo)) {

                System.out.println("===== DETALLES DE LA SESION =====");
                System.out.println("Codigo: " + sesion.getCodigo());
                System.out.println("Fecha: " + sesion.getFecha());
                System.out.println("Duracion: " + sesion.getDuracion_minutos() + " minutos");
                System.out.println("Estado: " + sesion.getEstado());
                return;
            }
        }
        System.out.println("No se encontro una sesion con ese codigo.");
    }

    public static void completarSesion(Scanner sc) {

        System.out.println("Ingrese el codigo de la sesion:");
        String codigo = sc.nextLine();

        for (Sesion sesion : sesiones) {

            if (sesion.getCodigo().equalsIgnoreCase(codigo)) {

                sesion.setEstado("Completada");

                System.out.println("Sesion marcada como completada.");
                return;
            }
        }

        System.out.println("No se encontro una sesion con ese codigo.");
    }

}