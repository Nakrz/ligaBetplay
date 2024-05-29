package com.torneobet;

import java.util.InputMismatchException;
import java.util.Scanner;
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
        String menu = "Menu principal:\n1. Registrar equipos\n2. Jugar Torneo\n3. Tabla de Puntajes\n4. Reportes\n5. Salir";
        boolean isActive = true;
        while (isActive) {
            System.out.println(cabeza + "\n" + inst + menu);
            System.out.print("Ingrese la opcion que desea: ");
            try {
                opcion = sc.nextInt();
                sc.nextLine();
                switch (opcion) {
                    case 1:
                        boolean agregarMas;
                        do {
                            System.out.print("Ingrese el nombre del equipo: ");
                            String nombreEquipo = sc.nextLine();
                            torneo.registrarEquipo(nombreEquipo);
                            System.out.print("¿Desea agregar otro equipo?\n1. Si\n2. No\nDigita tu opcion: ");
                            int subOpcion = sc.nextInt();
                            sc.nextLine();
                            agregarMas = subOpcion == 1;
                        } while (agregarMas);
                        break;
                    case 2:
                        System.out.println("Has seleccionado Jugar Torneo");
                        System.out.println("\nResumen de los patidos: ");
                        torneo.jugarTorneo();
                        System.out.println("El torneo ha finalizado, elige la opcion 3, para ver los puntajes");
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

    private static void pausa(Scanner sc) {
        System.out.println("Presiona cualquier tecla para volver al menu principal");
        sc.nextLine();
    }
}
