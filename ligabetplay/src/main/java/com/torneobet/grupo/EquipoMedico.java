package com.torneobet.grupo;

public class EquipoMedico extends Plantilla{
    String fisioterapeuta;
    String medico;


    public EquipoMedico(int id, String nombre, String apellidos, int edad, int añosActivo, String fisioterapeuta,
            String medico) {
        super(id, nombre, apellidos, edad, añosActivo);
        this.fisioterapeuta = fisioterapeuta;
        this.medico = medico;
    }


    public String getFisioterapeuta() {
        return fisioterapeuta;
    }


    public void setFisioterapeuta(String fisioterapeuta) {
        this.fisioterapeuta = fisioterapeuta;
    }


    public String getMedico() {
        return medico;
    }


    public void setMedico(String medico) {
        this.medico = medico;
    }
}