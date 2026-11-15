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

    public Sesion(String codigo, LocalDate fecha, int duracion_minutos, String estado, Cliente cliente, Entrenador entrenador) {
        this.codigo = codigo;
        this.fecha = fecha;
        this.duracion_minutos = duracion_minutos;
        this.estado = estado;
        this.cliente = cliente;
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

    public void setCliente(Cliente cliente) {
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
 //registgrar

	public static void registrarSesion(ArrayList<Sesion> sesiones, ArrayList<Cliente> clientes, ArrayList<Entrenador> entrenadores, Scanner sc) {

		System.out.print("Codigo: ");
		String codigo = sc.nextLine();

		for (Sesion s : sesiones) {
			if (s.getCodigo().equalsIgnoreCase(codigo)) {
				System.out.println("Sesion duplicada");
				return;
			}
		}

		System.out.print("Fecha (AAAA-MM-DD): ");
		LocalDate fecha;
		try {
			fecha = LocalDate.parse(sc.nextLine());
		} catch (Exception e) {
			System.out.println("Fecha invalida");
			return;
		}

		System.out.print("Duracion en minutos: ");
		int duracion;
		try {
			duracion = Integer.parseInt(sc.nextLine());
		} catch (NumberFormatException e) {
			System.out.println("Duracion invalida");
			return;
		}

		if (duracion <= 0 || duracion > duracion_maxima) {
			System.out.println("La duracion debe ser de 1 a 120 minutos");
			return;
		}

		System.out.print("Codigo del cliente: ");
		String codigoCliente = sc.nextLine();

		Cliente cliente = null;
		for (Cliente c : clientes) {
			if (c.getCodigo().equalsIgnoreCase(codigoCliente)) {
				cliente = c;
				break;
			}
		}

		System.out.print("Codigo del entrenador: ");
		String codigoEntrenador = sc.nextLine();

		Entrenador entrenador = null;
		for (Entrenador e : entrenadores) {
			if (e.getCodigo().equalsIgnoreCase(codigoEntrenador)) {
				entrenador = e;
				break;
			}
		}

		if (cliente == null || entrenador == null) {
			System.out.println("Cliente o entrenador no encontrado");
			return;
		}

		Sesion nuevaSesion = new Sesion(codigo, fecha, duracion, "PENDIENTE", cliente, entrenador);

		sesiones.add(nuevaSesion);

		System.out.println("Sesion registrada correctamente");
	}

    public static void consultarSesion(ArrayList<Sesion> sesiones, Scanner sc) {
        System.out.println("Ingrese el codigo de la sesion:");
        String codigo = sc.nextLine();

        for (Sesion sesion : sesiones) {

            if (sesion.getCodigo().equalsIgnoreCase(codigo)) {

                System.out.println("DETALLES DE LA SESION");
                System.out.println("Codigo: " + sesion.getCodigo());
                System.out.println("Fecha: " + sesion.getFecha());
                System.out.println("Duracion: " + sesion.getDuracion_minutos() + " minutos");
        		System.out.println("Estado: " + sesion.getEstado());
        		
                return;
            }
        }
        System.out.println("No se encontro una sesion con ese codigo.");
    }

    public static void completarSesion(ArrayList<Sesion> sesiones, Scanner sc) {

        System.out.println("Ingrese el codigo de la sesion:");
        String codigo = sc.nextLine();

        for (Sesion sesion : sesiones) {

            if (sesion.getCodigo().equalsIgnoreCase(codigo)) {

                sesion.setEstado("COMPLETADA");

                System.out.println("Sesion marcada como completada.");
                return;
            }
        }

        System.out.println("No se encontro una sesion con ese codigo.");
    }

}