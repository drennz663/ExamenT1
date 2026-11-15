package app;

import java.time.LocalDate;

public class Registro {
    private String codigo;
    private Cliente client;
    private Entrenador entrenador;
    private LocalDate fecha;
    private int nivel_avance;
    private String recomendaciones;

    public Registro(String codigo, Cliente client, Entrenador entrenador, LocalDate fecha, int nivel_avance, String recomendaciones) {
        this.codigo = codigo;
        this.client = client;
        this.entrenador = entrenador;
        this.fecha = fecha;
        this.nivel_avance = nivel_avance;

        this.recomendaciones = recomendaciones;
    }

    public Registro() {
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Cliente getClient() {
        return client;
    }

    public void setClient(Cliente client) {
        this.client = client;
    }

    public Entrenador getEntrenador() {
        return entrenador;
    }

    public void setEntrenador(Entrenador entrenador) {
        this.entrenador = entrenador;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public int getNivel_avance() {
        return nivel_avance;
    }

    public void setNivel_avance(int nivel_avance) {
        this.nivel_avance = nivel_avance;
    }

    public String getRecomendaciones() {
        return recomendaciones;
    }

    public void setRecomendaciones(String recomendaciones) {
        this.recomendaciones = recomendaciones;
    }

}
