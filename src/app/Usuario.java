package app;

public abstract class Usuario {
	protected String codigo;
    protected String nombre;
    protected String correoElectronico;

    public Usuario(String codigo, String nombre, String correoElectronico) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.correoElectronico = correoElectronico;
    }
    
    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public abstract String obtenerRol();

    public void mostrarDatos() {
        System.out.println(codigo + " - " + nombre + " - " + correoElectronico);
    }
}
