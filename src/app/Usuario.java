package app;

public abstract class Usuario {
    private String codigo;
    private String nombre;
    private String correoElectronico;

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
