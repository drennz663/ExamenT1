package app;

import java.util.ArrayList;

public class Entrenador extends Usuario{
    private String especialidad;
    private int anhos_experiencia;
    private Entrenador supervisor;

    public Entrenador(String codigo, String nombre, String correoElectronico, String especialidad, int anhos_experiencia) {
        super(codigo, nombre, correoElectronico);
        this.especialidad = especialidad;
        this.anhos_experiencia = anhos_experiencia;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public int getAnhos_experiencia() {
        return anhos_experiencia;
    }

    public void setAnhos_experiencia(int anhos_experiencia) {
        this.anhos_experiencia = anhos_experiencia;
    }

    @Override
    public String obtenerRol() {
        return "Entrenador";
    }
    
    public static void registrarEntrenador(
            ArrayList<Entrenador> entrenadores, Entrenador entrenador) {

        for (Entrenador e : entrenadores) {
            if (e.getCodigo().equals(entrenador.getCodigo())) {
                System.out.println("Entrenador duplicado");
                return;
            }
        }

        entrenadores.add(entrenador);
        System.out.println("Entrenador agregado correctamente");
    }

}