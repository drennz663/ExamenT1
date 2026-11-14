
package app;
import java.util.ArrayList;

//herenciavr02
public class Cliente extends Usuario {

    private int edad;
    private String objetivoEntrenamiento;
    private Plan planAsignado;

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
    
    public static void registrarCliente(ArrayList<Cliente> clientes, Cliente cliente) {

        for (Cliente c : clientes) {
            if (c.getCodigo().equals(cliente.getCodigo())) {
                System.out.println("Cliente duplicado");
                return;
            }
        }

        clientes.add(cliente);
        System.out.println("Cliente agregado correctamente");
    }


}
