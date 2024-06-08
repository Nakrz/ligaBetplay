package com.torneobet.juego;

import com.torneobet.grupo.EquipoMedico;
import com.torneobet.grupo.EquipoTecnico;
import com.torneobet.grupo.Jugador;
import com.torneobet.grupo.Plantilla;
import com.torneobet.teams.Equipo;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Torneo {
    public List<Equipo> equipos;

    public Torneo() {
        this.equipos = new ArrayList<>();
    }

    public void registrarEquipo(String nombreEquipo) {
        Equipo nuevoEquipo = new Equipo(nombreEquipo, 0, 0, 0, 0, 0, 0, 0, new ArrayList<>());
        equipos.add(nuevoEquipo);
    }

    public void registrarJugador(Jugador jugador, String nombreEquipo) {
        for (Equipo equipo : equipos) {
            if (equipo.getNombreEquipo().equals(nombreEquipo)) {
                equipo.agregarJugador(jugador);
                break;
            }
        }
    }

    public void registrarEquipoTecnico(EquipoTecnico equipoTecnico, String nombreEquipo) {
        for (Equipo equipo : equipos) {
            if (equipo.getNombreEquipo().equals(nombreEquipo)) {
                List<EquipoTecnico> equipoTecnicoList = new ArrayList<>();
                equipoTecnicoList.add(equipoTecnico);
                equipo.asignarEquipoTecnico(equipoTecnicoList);
                break;
            }
        }
    }

    public void registrarEquipoMedico(EquipoMedico equipoMedico, String nombreEquipo) {
        for (Equipo equipo : equipos) {
            if (equipo.getNombreEquipo().equals(nombreEquipo)) {
                List<EquipoMedico> equipoMedicoList = new ArrayList<>();
                equipoMedicoList.add(equipoMedico);
                equipo.asignarEquipoMedico(equipoMedicoList);
                break;
            }
        }
    }

    public void listarPlantilla(String nombreEquipo) {
        for (Equipo equipo : equipos) {
            if (equipo.getNombreEquipo().equals(nombreEquipo)) {
                System.out.println("\nEquipo: " + equipo.getNombreEquipo());
                
                System.out.println("\nJugadores:");
                for (Jugador jugador : equipo.getJugadores()) {
                    System.out.println(jugador.getNombre() + " " + jugador.getApellidos() +
                            " (" + jugador.getDorsal() + ") - " + jugador.getPosicion());
                }
                
                System.out.println("\nEquipo Tecnico:");
                for (EquipoTecnico tecnico : equipo.getEquipoTecnico()) {
                    System.out.println("\nTecnico: " + tecnico.getTecnico());
                    System.out.println("\nAsistente Tecnico: " + tecnico.getAsisTecnico());
                    System.out.println("\nPreparador Físico: " + tecnico.getPrepFisico());
                }

                System.out.println("\nEquipo Medico:");
                for (EquipoMedico medico : equipo.getEquipoMedico()) {
                    System.out.println("\nFisioterapeuta: " + medico.getFisioterapeuta());
                    System.out.println("\nMedico: " + medico.getMedico());
                }
                
                System.out.println("-----------------------------------");
                return;
            }
        }
        System.out.println("El equipo '" + nombreEquipo + "' no se encuentra registrado.");
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

    public void jugarPartido(Equipo equipo1, Equipo equipo2) {
        Random random = new Random();
        int golesEquipo1 = random.nextInt(4);
        int golesEquipo2 = random.nextInt(4); 

        equipo1.puntosDeTorneo(golesEquipo1, golesEquipo2);
        equipo2.puntosDeTorneo(golesEquipo2, golesEquipo1);

        System.out.println(MessageFormat.format("{0} {1} - {2} {3}",
                equipo1.getNombreEquipo(), golesEquipo1, golesEquipo2, equipo2.getNombreEquipo()));
    }

    public void jugarTorneo() {
        for (int i = 0; i < equipos.size(); i++) {
            for (int j = i + 1; j < equipos.size(); j++) {
                jugarPartido(equipos.get(i), equipos.get(j));
            }
        }
    }

    public void masGolesAnotados() {
        Equipo maxGolesEquipo = new Equipo("", 0, 0, 0, 0, 0, 0, 0, new ArrayList<>());
        int maxGoles = 0;
        for (Equipo equipo : equipos) {
            if (equipo.getGf() > maxGoles) {
                maxGoles = equipo.getGf();
                maxGolesEquipo = equipo;
            }
        }
        if (maxGolesEquipo != new Equipo("", 0, 0, 0, 0, 0, 0, 0, new ArrayList<>())); {
            System.out.println("El equipo que mas goles anoto es: " + maxGolesEquipo.getNombreEquipo());
        }
    }

    public void equipoMasPuntos() {
        Equipo maxPuntosEquipo = new Equipo("", 0, 0, 0, 0, 0, 0, 0, new ArrayList<>());
        int maxPuntos = 0;
        for (Equipo equipo : equipos) {
            if (equipo.getTp() > maxPuntos) {
                maxPuntos = equipo.getTp();
                maxPuntosEquipo = equipo;
            }
        }
        if (maxPuntosEquipo != new Equipo("", 0, 0, 0, 0, 0, 0, 0, new ArrayList<>())); {
            System.out.println("El equipo que mas puntos tiene es: " + maxPuntosEquipo.getNombreEquipo());
        }
    }

    public void masPartidosGanados() {
        Equipo maxGanadosEquipo = new Equipo("", 0, 0, 0, 0, 0, 0, 0, new ArrayList<>());
        int maxGanados = 0;
        for (Equipo equipo : equipos) {
            if (equipo.getPg() > maxGanados) {
                maxGanados = equipo.getPg();
                maxGanadosEquipo = equipo;
            }
        }
        if (maxGanadosEquipo != new Equipo("", 0, 0, 0, 0, 0, 0, 0, new ArrayList<>())); {
            System.out.println("El equipo que mas partidos gano fue el: " + maxGanadosEquipo.getNombreEquipo());
        }
    }

    public void totalGoles() {
        int totalGoles = 0;
        for (Equipo equipo : equipos) {
            totalGoles += equipo.getGf();
        }
        System.out.println("El total de goles anotados por todos los equipos es: " + totalGoles);
    }

    public void promedioGoles() {
        int totalGoles = 0;
        int totalPartidos = 0;
        for (Equipo equipo : equipos) {
            totalGoles += equipo.getGf();
            totalPartidos += equipo.getPj();
        }
        double promedioGoles;
        if (totalPartidos == 0) {
            promedioGoles = 0;
        } else {
            promedioGoles = (double) totalGoles / totalPartidos;
        }
        System.out.println("El promedio de goles anotados en el torneo es: " + promedioGoles);
    }
}
