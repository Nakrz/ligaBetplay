package com.torneobet.grupo;

public class Jugador extends Plantilla{
    int dorsal;
    String posicion;
    String nacionalidad;

    public Jugador(int id, String nombre, String apellidos, int edad, int añosActivo, int dorsal, String posicion,
            String nacionalidad) {
        super(id, nombre, apellidos, edad, añosActivo);
        this.dorsal = dorsal;
        this.posicion = posicion;
        this.nacionalidad = nacionalidad;
    }

    public int getDorsal() {
        return dorsal;
    }

    public void setDorsal(int dorsal) {
        this.dorsal = dorsal;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }
}
