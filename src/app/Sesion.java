package app;

import java.time.LocalDate;

public class Sesion {
    private String codigo;
    private LocalDate fecha;
    private int duracion_minutos;
    private String estado;
    private Cliente client;
    private Entrenador entrenador;
    private static int duracion_maxima = 120;

    public Sesion(String codigo, LocalDate fecha, int duracion_minutos, String estado, Cliente client, Entrenador entrenador) {
        this.codigo = codigo;
        this.fecha = fecha;
        this.duracion_minutos = duracion_minutos;
        this.estado = estado;
        this.client = client;
        this.entrenador = entrenador;
    }

    public Sesion() {
    }

    public Entrenador getEntrenador() {
        return entrenador;
    }

    public void setEntrenador(Entrenador entrenador) {
        this.entrenador = entrenador;
    }

    public Cliente getClient() {
        return client;
    }

    public void setClient(Cliente client) {
        this.client = client;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getDuracion_minutos() {
        return duracion_minutos;
    }

    public void setDuracion_minutos(int duracion_minutos) {
        this.duracion_minutos = duracion_minutos;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
}