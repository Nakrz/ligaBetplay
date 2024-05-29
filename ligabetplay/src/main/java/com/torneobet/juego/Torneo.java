package com.torneobet.juego;

import com.torneobet.teams.Equipo;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Torneo {
    private List<Equipo> equipos;

    public Torneo() {
        this.equipos = new ArrayList<>();
    }

    public void registrarEquipo(String nombreEquipo) {
        Equipo nuevoEquipo = new Equipo(nombreEquipo, 0, 0, 0, 0, 0, 0, 0, new ArrayList<>());
        equipos.add(nuevoEquipo);
    }

    public void tablaPuntajes() {
        System.out.println("""

                +-------------------------------------------+
                | EQUIPO | PJ | PG | PP | PE | GF | GC | TP |
                +-------------------------------------------+""");
        for (Equipo equipo : equipos) {
            System.out.println(MessageFormat.format("""
                | {0} |  {1} |  {2} |  {3} |  {4} |  {5} |  {6} |  {7} |
                +-------------------------------------------+""",
                equipo.getNombreEquipo(), equipo.getPj(), equipo.getPg(), equipo.getPp(), equipo.getPe(),
                equipo.getGf(), equipo.getGc(), equipo.getTp()));
        }
        System.out.println("\n");
    }

    public void jugarTorneo() {
        Random random = new Random();
        for (Equipo equipo : equipos) {
            int partidosJugados = random.nextInt(7) + 1;
            int partidosGanados = random.nextInt(partidosJugados + 1);
            int partidosEmpatados = random.nextInt(partidosJugados - partidosGanados + 1);
            int partidosPerdidos = partidosJugados - partidosGanados - partidosEmpatados;
            int golesFavor = random.nextInt(6) + 1;
            int golesContra = random.nextInt(6) + 1;

            equipo.setPj(partidosJugados);
            equipo.setPg(partidosGanados);
            equipo.setPe(partidosEmpatados);
            equipo.setPp(partidosPerdidos);
            equipo.setGf(golesFavor);
            equipo.setGc(golesContra);
            equipo.setTp((partidosGanados * 3) + partidosEmpatados);
        }
    }
}