package app;

public class Plan {
    private String codigo;
    private String nombre;
    private String nivel_dificultad;
    private int cantidad_sesiones;

    public Plan(String codigo, String nombre, String nivel_dificultad, int cantidad_sesiones) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.nivel_dificultad = nivel_dificultad;
        this.cantidad_sesiones = cantidad_sesiones;
    }

    public Plan() {
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNivel_dificultad() {
        return nivel_dificultad;
    }

    public void setNivel_dificultad(String nivel_dificultad) {
        this.nivel_dificultad = nivel_dificultad;
    }

    public int getCantidad_sesiones() {
        return cantidad_sesiones;
    }

    public void setCantidad_sesiones(int cantidad_sesiones) {
        this.cantidad_sesiones = cantidad_sesiones;
    }

    public void consultarDatos() {
        System.out.println("Código: " + codigo);
        System.out.println("Nombre: " + nombre);
        System.out.println("Nivel de dificultad: " + nivel_dificultad);
        System.out.println("Cantidad de sesiones: " + cantidad_sesiones);
    }

}
