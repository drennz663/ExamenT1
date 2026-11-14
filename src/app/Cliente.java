package app;

//herenciavr02
public class Cliente extends Usuario {

    private int edad;
    private String objetivoEntrenamiento;
    private Plan planAsignado;
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

}
