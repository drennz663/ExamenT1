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

        Entrenador entrenador = new Entrenador(
            codigo, nombre, correo, especialidad, experiencia
        );

        entrenadores.add(entrenador);

        System.out.println("Entrenador agregado correctamente");
    }
    // Asigno a otro entrenador como supervisor de este
    public void asignarSupervisor(Entrenador supervisor) {
        if (supervisor == this) {
            System.out.println("Un entrenador no puede supervisarse a sí mismo.");
            return;
        }
        this.supervisor = supervisor;
        System.out.println(supervisor.nombre + " ahora supervisa a " + this.nombre);
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

