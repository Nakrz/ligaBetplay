package com.torneobet.grupo;

public class Plantilla {
    int id;
    String nombre;
    String apellidos;
    int edad;
    int añosActivo;

    public Plantilla(int id, String nombre, String apellidos, int edad, int añosActivo) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.edad = edad;
        this.añosActivo = añosActivo;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellidos() {
        return apellidos;
    }
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
    public int getEdad() {
        return edad;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }
    public int getAñosActivo() {
        return añosActivo;
    }
    public void setAñosActivo(int añosActivo) {
        this.añosActivo = añosActivo;
    }
    
}
