package com.torneobet.teams;

import java.util.ArrayList;
import java.util.List;
import com.torneobet.grupo.Jugador;
import com.torneobet.grupo.EquipoTecnico;
import com.torneobet.grupo.EquipoMedico;


public class Equipo {

    String nombreEquipo;
    int pj;
    int pg;
    int pp;
    int pe;
    int gf;
    int gc;
    int tp;
    List<Integer> equipos;
    List<Jugador> jugadores;
    List<EquipoTecnico> equipoTecnico;
    List<EquipoMedico> equipoMedico;

    public Equipo(String nombreEquipo, int pj, int pg, int pp, int pe, int gf, int gc, int tp, List<Integer> equipos) {
        this.nombreEquipo = nombreEquipo;
        this.pj = pj;
        this.pg = pg;
        this.pp = pp;
        this.pe = pe;
        this.gf = gf;
        this.gc = gc;
        this.tp = tp;
        this.equipos = new ArrayList<>(equipos);
        this.jugadores = new ArrayList<>();
        this.equipoTecnico = new ArrayList<>();
        this.equipoMedico = new ArrayList<>();
    }

    public List<Jugador> getJugadores() {
        return jugadores;
    }

    public void setJugadores(List<Jugador> jugadores) {
        this.jugadores = jugadores;
    }

    public List<EquipoTecnico> getEquipoTecnico() {
        return equipoTecnico;
    }

    public void setEquipoTecnico(List<EquipoTecnico> equipoTecnico) {
        this.equipoTecnico = equipoTecnico;
    }

    public List<EquipoMedico> getEquipoMedico() {
        return equipoMedico;
    }

    public void setEquipoMedico(List<EquipoMedico> equipoMedico) {
        this.equipoMedico = equipoMedico;
    }

    public String getNombreEquipo() {
        return nombreEquipo;
    }

    public void setNombreEquipo(String nombreEquipo) {
        this.nombreEquipo = nombreEquipo;
    }

    public int getPj() {
        return pj;
    }

    public void setPj(int pj) {
        this.pj = pj;
    }

    public int getPg() {
        return pg;
    }

    public void setPg(int pg) {
        this.pg = pg;
    }

    public int getPp() {
        return pp;
    }

    public void setPp(int pp) {
        this.pp = pp;
    }

    public int getPe() {
        return pe;
    }

    public void setPe(int pe) {
        this.pe = pe;
    }

    public int getGf() {
        return gf;
    }

    public void setGf(int gf) {
        this.gf = gf;
    }

    public int getGc() {
        return gc;
    }

    public void setGc(int gc) {
        this.gc = gc;
    }

    public int getTp() {
        return tp;
    }

    public void setTp(int tp) {
        this.tp = tp;
    }

    public List<Integer> getEquipos() {
        return equipos;
    }

    public void setEquipos(List<Integer> equipos) {
        this.equipos = new ArrayList<>(equipos);
    }

    public void addEquipo(int equipo) {
        this.equipos.add(equipo);
    }

    public void puntosDeTorneo(int golesFavor, int golesContra) {
        this.pj += 1;
        this.gf += golesFavor;
        this.gc += golesContra;
        if (golesFavor > golesContra) {
            this.pg += 1;
            this.tp += 3;
        } else if (golesFavor < golesContra) {
            this.pp += 1;
        } else {
            this.pe += 1;
            this.tp += 1;
        }
    }

    public void agregarJugador(Jugador jugador) {
        this.jugadores.add(jugador);
    }

    public void asignarEquipoTecnico(List<EquipoTecnico> equipoTecnico) {
        this.equipoTecnico = equipoTecnico;
    }

    public void asignarEquipoMedico(List<EquipoMedico> equipoMedico) {
        this.equipoMedico = equipoMedico;
    }
}
