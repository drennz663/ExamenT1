package app;
import java.util.ArrayList;
import java.util.Scanner;

//herenciavr02
public class Cliente extends Usuario {

    private int edad;
    private String objetivoEntrenamiento;
    protected Plan planAsignado;

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
    
   

	public static void asignarPlanCliente(ArrayList<Cliente> clientes, ArrayList<Plan> planes, Scanner sc) {

	    System.out.print("Codigo del cliente: ");
	    String codigo = sc.nextLine();

	    Cliente cliente = null;
	    for (Cliente c : clientes) {
	        if (c.getCodigo().equalsIgnoreCase(codigo)) {
	            cliente = c;
	        }
	    }   

	    if (cliente == null) {
	        System.out.println("El cliente no existe");
	        return;
	    }

	    System.out.print("Codigo del plan: ");
	    String codigoPlan = sc.nextLine();

	    Plan plan = null;
	    for (Plan p : planes) {
	        if (p.getCodigo().equalsIgnoreCase(codigoPlan)) {
	            plan = p;
	        }
	    }
	    if (plan == null) {
	        System.out.println("El plan no existe");
	        return;
	    }
	    cliente.setPlanAsignado(plan);
	    System.out.println("Plan asignado correctamente");
	}    
    
	public static void mostrarDatosCliente(ArrayList<Cliente> clientes, Scanner sc) {

		System.out.print("Codigo: ");
		String codigo = sc.nextLine();

		for (Cliente c : clientes) {
			if (c.getCodigo().equalsIgnoreCase(codigo)) {
				c.mostrarDatos();
				return;
			}
		}

		System.out.println("El cliente no existe");
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
    
	@Override
	public void mostrarDatos() {
		super.mostrarDatos();

		System.out.println("Edad: " + edad);
		System.out.println("Objetivo: " + objetivoEntrenamiento);

		if (planAsignado == null) {
			System.out.println("No tiene plan asignado");
		} else {
			System.out.println("Plan asignado: " + planAsignado.getNombre());
		}
	}
    
}
