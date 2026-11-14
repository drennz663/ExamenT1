package app;

public abstract class Usuario {
    private String codigo;
    protected String nombre;
    private String correoElectronico;

    public Usuario(String codigo, String nombre, String correoElectronico) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.correoElectronico = correoElectronico;
    }

    public abstract String obtenerRol();

    public void mostrarDatos() {
        System.out.println(codigo + " - " + nombre + " - " + correoElectronico);
    }
}
