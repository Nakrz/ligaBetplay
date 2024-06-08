package com.torneobet.grupo;

public class EquipoTecnico extends Plantilla{
    String tecnico;
    String asisTecnico;
    String prepFisico;


    public EquipoTecnico(int id, String nombre, String apellidos, int edad, int añosActivo, String tecnico,
            String asisTecnico, String prepFisico) {
        super(id, nombre, apellidos, edad, añosActivo);
        this.tecnico = tecnico;
        this.asisTecnico = asisTecnico;
        this.prepFisico = prepFisico;
    }


    public String getTecnico() {
        return tecnico;
    }


    public void setTecnico(String tecnico) {
        this.tecnico = tecnico;
    }


    public String getAsisTecnico() {
        return asisTecnico;
    }


    public void setAsisTecnico(String asisTecnico) {
        this.asisTecnico = asisTecnico;
    }


    public String getPrepFisico() {
        return prepFisico;
    }


    public void setPrepFisico(String prepFisico) {
        this.prepFisico = prepFisico;
    }
}
