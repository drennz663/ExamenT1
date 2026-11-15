package app;


import java.util.ArrayList;
import java.util.Scanner;

public class Entrenador extends Usuario implements Evaluable, Reporteable{
    private String especialidad;
    private int anhos_experiencia;
    private Entrenador supervisor;

    public Entrenador(String codigo, String nombre, String correoElectronico, String especialidad, int anhos_experiencia) {
        super(codigo, nombre, correoElectronico);
        this.especialidad = especialidad;
        this.anhos_experiencia = anhos_experiencia;
    }

    
    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public int getAnhos_experiencia() {
        return anhos_experiencia;
    }

    public void setAnhos_experiencia(int anhos_experiencia) {
        this.anhos_experiencia = anhos_experiencia;
    }

    @Override
    public String obtenerRol() {
        return "Entrenador";
    }
    

	public static void mostrarDatosEntrenador(ArrayList<Entrenador> entrenadores, Scanner sc) {

		System.out.print("Codigo: ");
		String codigo = sc.nextLine();

		for (Entrenador e : entrenadores) {
			if (e.getCodigo().equalsIgnoreCase(codigo)) {
				e.mostrarDatos();
				return;
			}
		}

		System.out.println("El entrenador no existe");
	}

    
    public static void registrarEntrenador(ArrayList<Entrenador> entrenadores, Scanner sc) {

        System.out.print("Codigo: ");
        String codigo = sc.nextLine();

        for (Entrenador e : entrenadores) {
            if (e.getCodigo().equalsIgnoreCase(codigo)) {
                System.out.println("Entrenador duplicado");
                return;
            }
        }

        System.out.print("Nombre: ");
        String nombre = sc.nextLine();

        System.out.print("Correo: ");
        String correo = sc.nextLine();

        System.out.print("Especialidad: ");
        String especialidad = sc.nextLine();

        System.out.print("Anios de experiencia: ");
        int experiencia;

        try {
            experiencia = Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Experiencia invalida");
            return;
        }

        if (experiencia < 0) {
            System.out.println("Experiencia invalida");
            return;
        }

        Entrenador entrenador = new Entrenador(codigo, nombre, correo, especialidad, experiencia);

        entrenadores.add(entrenador);

        System.out.println("Entrenador agregado correctamente");
    }
    // Asigno a otro entrenador como supervisor de este

	public static void asignarSupervisor(ArrayList<Entrenador> entrenadores, Scanner sc) {

		System.out.print("Codigo del entrenador: ");
		String codigo = sc.nextLine();

		System.out.print("Codigo del supervisor: ");
		String codigoSupervisor = sc.nextLine();

		Entrenador entrenador = null;
		Entrenador supervisor = null;

		for (Entrenador e : entrenadores) {
			if (e.getCodigo().equalsIgnoreCase(codigo)) {
				entrenador = e;
			}
			if (e.getCodigo().equalsIgnoreCase(codigoSupervisor)) {
				supervisor = e;
			}
		}

		if (entrenador == null || supervisor == null || entrenador == supervisor) {
			System.out.println("Entrenador o supervisor invalido");
			return;
		}

		entrenador.supervisor = supervisor;

		System.out.println(supervisor.getNombre() + " ahora supervisa a " + entrenador.getNombre());
	}


    public String consultarSupervisor() {
        if (supervisor == null) {
            return "Sin supervisor asignado";
        }
        return supervisor.nombre;
    }
 // Implementación de Evaluable
    @Override
    public void evaluarProgreso(Cliente cliente) {
        System.out.println("=== Evaluación de progreso ===");
        System.out.println("Entrenador: " + getNombre() + " (" + especialidad + ")");
        System.out.println("Cliente: " + cliente.getNombre());
        System.out.println("Objetivo: " + cliente.getObjetivoEntrenamiento());
        if (cliente.getPlanAsignado() != null) {
            System.out.println("Plan: " + cliente.getPlanAsignado().getNombre());
            System.out.println("Resultado: progreso evaluado según el plan asignado.");
        } else {
            System.out.println("Resultado: el cliente aún no tiene un plan asignado.");
        }
    }
    
	public static void reporteSeguimiento(ArrayList<Cliente> clientes, ArrayList<Entrenador> entrenadores, Scanner sc) {

		System.out.print("Codigo del entrenador: ");
		String codigoEntrenador = sc.nextLine();

		System.out.print("Codigo del cliente: ");
		String codigoCliente = sc.nextLine();

		Entrenador entrenador = null;
		Cliente cliente = null;

		for (Entrenador e : entrenadores) {
			if (e.getCodigo().equalsIgnoreCase(codigoEntrenador)) {
				entrenador = e;
				break;
			}
		}

		for (Cliente c : clientes) {
			if (c.getCodigo().equalsIgnoreCase(codigoCliente)) {
				cliente = c;
				break;
			}
		}

		if (entrenador == null || cliente == null) {
			System.out.println("Entrenador o cliente no encontrado");
			return;
		}

		entrenador.evaluarProgreso(cliente);
		System.out.println(entrenador.generarReporte(cliente));
	}


    // Implementación de Reporteable
    @Override
    public String generarReporte(Cliente cliente) {
        String plan = (cliente.getPlanAsignado() != null)
                ? cliente.getPlanAsignado().getNombre() : "Sin plan";
        return "REPORTE DE SEGUIMIENTO\n"
             + "Cliente: " + cliente.getNombre() + "\n"
             + "Objetivo: " + cliente.getObjetivoEntrenamiento() + "\n"
             + "Plan: " + plan + "\n"
             + "Entrenador responsable: " + getNombre()
             + " (" + anhos_experiencia + " años de experiencia)";
    }


    @Override
    public void mostrarDatos() {
        super.mostrarDatos();
        System.out.println("Especialidad: " + especialidad);
        System.out.println("Años de experiencia: " + anhos_experiencia);
        System.out.println("Supervisor: " + consultarSupervisor());
    }

}

