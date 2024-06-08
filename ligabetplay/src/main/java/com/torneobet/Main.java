package com.torneobet;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.torneobet.grupo.EquipoMedico;
import com.torneobet.grupo.EquipoTecnico;
import com.torneobet.grupo.Jugador;
import com.torneobet.juego.Torneo;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Torneo torneo = new Torneo();
        int opcion;
        String cabeza = """
            +----------------+
            |  LIGA BETPLAY  |
            +----------------+
            """;
        String inst = "Bienvenido a la Liga BetPlay, antes de jugar el torneo por favor, registra los equipos primero en la opcion 1\n\n";
        String menu = "Menu principal:\n1. Registrar equipos\n2. Jugar Torneo\n3. Tabla de Puntajes\n4. Reportes\n5. Personal de Equipos\n6. Reportes de Jugadores\n7. Salir";
        boolean isActive = true;
        while (isActive) {
            System.out.println(cabeza + "\n" + inst + menu);
            System.out.print("Ingrese la opcion que desea: ");
            try {
                opcion = sc.nextInt();
                sc.nextLine();
                switch (opcion) {
                    case 1:
                        boolean agregarMasEquipos;
                        do {
                            System.out.print("Ingrese el nombre del equipo: ");
                            String nombreEquipo = sc.nextLine();
                            torneo.registrarEquipo(nombreEquipo);

                            boolean agregarMasPersonal;
                            do {
                                System.out.println("¿Que tipo de personal desea agregar al equipo?");
                                System.out.println("1. Jugador");
                                System.out.println("2. Equipo Tecnico");
                                System.out.println("3. Equipo Medico");
                                System.out.print("Digita tu opcion: ");
                                int tipoPersonal = sc.nextInt();
                                sc.nextLine();

                                switch (tipoPersonal) {
                                    case 1:
                                        System.out.println("Registro de Jugador:");
                                        System.out.print("Ingrese el nombre del jugador: ");
                                        String nombreJugador = sc.nextLine();
                                        System.out.print("Ingrese el apellido del jugador: ");
                                        String apellidosJugador = sc.nextLine();
                                        System.out.print("Ingrese la edad del jugador: ");
                                        int edadJugador = sc.nextInt();
                                        sc.nextLine();
                                        System.out.print("Ingrese los años activos del jugador: ");
                                        int añosActivoJugador = sc.nextInt();
                                        sc.nextLine();
                                        System.out.print("Ingrese el dorsal del jugador: ");
                                        int dorsalJugador = sc.nextInt();
                                        sc.nextLine();
                                        System.out.print("Ingrese la posicion del jugador: ");
                                        String posicionJugador = sc.nextLine();
                                        System.out.print("Ingrese la nacionalidad del jugador: ");
                                        String nacionalidadJugador = sc.nextLine();

                                        Jugador nuevoJugador = new Jugador(1, nombreJugador, apellidosJugador, edadJugador, añosActivoJugador,
                                                dorsalJugador, posicionJugador, nacionalidadJugador);
                                        torneo.registrarJugador(nuevoJugador, nombreEquipo);
                                        break;
                                    case 2:
                                        System.out.print("Ingrese el nombre del tecnico: ");
                                        String nombreTecnico = sc.nextLine();
                                        System.out.print("Ingrese el nombre del asistente tecnico: ");
                                        String nombreAsistente = sc.nextLine();
                                        System.out.print("Ingrese el nombre del preparador físico: ");
                                        String nombrePrepFisico = sc.nextLine();

                                        EquipoTecnico equipoTecnico = new EquipoTecnico(1, nombreTecnico, nombreAsistente, 0, 0, nombrePrepFisico, nombreAsistente, nombrePrepFisico);
                                        torneo.registrarEquipoTecnico(equipoTecnico, nombreEquipo);
                                        break;
                                    case 3:
                                        System.out.print("Ingrese el nombre del fisioterapeuta: ");
                                        String nombreFisioterapeuta = sc.nextLine();
                                        System.out.print("Ingrese el nombre del medico: ");
                                        String nombreMedico = sc.nextLine();
                                        EquipoMedico equipoMedico = new EquipoMedico(1, nombreFisioterapeuta, nombreMedico, 0, 0, nombreFisioterapeuta, nombreMedico);
                                        torneo.registrarEquipoMedico(equipoMedico, nombreEquipo);
                                        break;
                                    default:
                                        System.out.println("Opcion no valida");
                                        break;
                                }

                                System.out.print("¿Desea agregar a alguien mas al personal del equipo?\n1. Si\n2. No\nDigita tu opcion: ");
                                int subOpcionPersonal = sc.nextInt();
                                sc.nextLine();
                                agregarMasPersonal = subOpcionPersonal == 1;
                            } while (agregarMasPersonal);

                            System.out.print("¿Desea agregar otro equipo?\n1. Si\n2. No\nDigita tu opcion: ");
                            int subOpcionEquipo = sc.nextInt();
                            sc.nextLine();
                            agregarMasEquipos = subOpcionEquipo == 1;
                        } while (agregarMasEquipos);
                        break;
                    case 2:
                        System.out.println("Has seleccionado Jugar Torneo");
                        System.out.println("\nResumen de los partidos: ");
                        torneo.jugarTorneo();
                        System.out.println("El torneo ha finalizado, elige la opcion 3 para ver los puntajes");
                        pausa(sc);
                        break;
                    case 3:
                        System.out.println("Has seleccionado Tabla de puntajes");
                        torneo.tablaPuntajes();
                        pausa(sc);
                        break;
                    case 4:
                        System.out.println("Has seleccionado Reportes");
                        System.out.println("\nEQUIPO QUE MAS GOLES ANOTO:");
                        torneo.masGolesAnotados();
                        System.out.println("\nEQUIPO QUE MAS PUNTOS TIENE:");
                        torneo.equipoMasPuntos();
                        System.out.println("\nEQUIPO QUE MAS PARTIDOS GANO:");
                        torneo.masPartidosGanados();
                        System.out.println("\nTOTAL DE GOLES ANOTADOS POR TODOS LOS EQUIPOS:");
                        torneo.totalGoles();
                        System.out.println("\nPROMEDIO DE GOLES ANOTADOS EN EL TORNEO:");
                        torneo.promedioGoles();
                        pausa(sc);
                        break;
                    case 5:
                    System.out.print("Ingrese el nombre del equipo para ver su personal: ");
                    String buscarEquipo = sc.nextLine();
                    torneo.listarPlantilla(buscarEquipo);
                    pausa(sc);
                    break;
                    case 6:
                    System.out.println("Informes sobre Jugadores");
                    case 7:
                        System.out.println("Has cerrado el programa");
                        isActive = false;
                        break;
                    default:
                        System.out.println("Opcion invalida, ingrese una opcion valida");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Opcion invalida, intenta de nuevo");
                sc.next();
            }
        }
        sc.close();
    }

    public static void pausa(Scanner sc) {
        System.out.println("Presiona cualquier tecla para volver al menú principal");
        sc.nextLine();
    }
}
