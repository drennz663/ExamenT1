package app;
import java.util.ArrayList;
import java.util.Scanner;

//herenciavr02
public class Cliente extends Usuario {

    private int edad;
    private String objetivoEntrenamiento;
    protected Plan planAsignado;
    private int telefono;

    public Cliente(String codigo, String nombre, String correoElectronico, int edad, String objetivoEntrenamiento) {
        super(codigo, nombre, correoElectronico);
        this.edad = edad;
        this.objetivoEntrenamiento = objetivoEntrenamiento;
        this.planAsignado = null;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getObjetivoEntrenamiento() {
        return objetivoEntrenamiento;
    }

    public void setObjetivoEntrenamiento(String objetivoEntrenamiento) {
        this.objetivoEntrenamiento = objetivoEntrenamiento;
    }

    public Plan getPlanAsignado() {
        return planAsignado;
    }

    public void setPlanAsignado(Plan planAsignado) {
        this.planAsignado = planAsignado;
    }

    @Override
    public String obtenerRol() {
        return "Cliente";
    }

    public void asignarYConsultarPlan(Plan plan) {
        this.planAsignado = plan;
        if (planAsignado != null) {
            planAsignado.consultarDatos();
        } else {
            System.out.println("El cliente no tiene un plan asignado.");
        }
    }

	public static void registrarCliente(ArrayList<Cliente> clientes, Scanner sc) {

		System.out.print("Codigo: ");
		String codigo = sc.nextLine();

		for (Cliente c : clientes) {
			if (c.getCodigo().equalsIgnoreCase(codigo)) {
				System.out.println("Cliente duplicado");
				return;
			}
		}

		System.out.print("Nombre: ");
		String nombre = sc.nextLine();

		System.out.print("Correo: ");
		String correo = sc.nextLine();

		int edad;
		try {
			System.out.print("Edad: ");
			edad = Integer.parseInt(sc.nextLine());
		} catch (NumberFormatException e) {
			System.out.println("Edad invalida");
			return;
		}

		if (edad <= 0) {
			System.out.println("Edad invalida");
			return;
		}

		System.out.print("Objetivo: ");
		String objetivo = sc.nextLine();

		Cliente cliente = new Cliente(codigo, nombre, correo, edad, objetivo);

		clientes.add(cliente);

		System.out.println("Cliente agregado correctamente");
	}

<<<<<<< HEAD

=======
    public static void consultarProgreso(ArrayList<Cliente> clientes,ArrayList<Registro> registros,Scanner sc ){
        boolean existe = false;
        System.out.println("Codigo :");
        String codigo = sc.nextLine();

        for(Cliente c :clientes ){
            if(c.getCodigo().equalsIgnoreCase(codigo)) {
                existe = true;
                boolean posee_registro = false;
                for (Registro r : registros) {
                    if (r.getClient().getCodigo().equalsIgnoreCase(c.getCodigo())) {
                        posee_registro = true;
                        System.out.println("Codigo : " + r.getCodigo());
                        System.out.println("Nombre del Cliente :" + c.nombre);
                        System.out.println("Nombre del entrenador :" + r.getEntrenador().getNombre());
                        System.out.println("Fecha de realizacion :" + r.getFecha());
                        System.out.println("Nivel de avance :" + r.getNivel_avance());
                        System.out.println("Pautas adicionales :" + r.getRecomendaciones());
                    }
                }
                if(!posee_registro){
                    System.out.println("Este cliente no tiene ningun registro");
                }
            }
        }
        if(!existe){
            System.out.println("El cliente no existe. ¿Ingresaste el codigo bien?");
        }
    }
>>>>>>> 7727c1fc2e68c62c06741add7500611f518ce19a
}
