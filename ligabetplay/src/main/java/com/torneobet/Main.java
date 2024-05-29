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
        String inst = "Bienvenido a la Liga BetPlay, antes de jugar el torneo por favor, registra los equipos primero en la opcion 2\n\n";
        String menu = "Menu principal:\n1. Jugar Torneo\n2. Registrar equipos\n3. Tabla de Puntajes\n4. Reportes\n5. Salir";
        boolean isActive = true;
        while (isActive) {
            System.out.println(cabeza + "\n" + inst + menu);
            System.out.print("Ingrese la opcion que desea: ");
            try {
                opcion = sc.nextInt();
                sc.nextLine();
                switch (opcion) {
                    case 1:
                        System.out.println("Has seleccionado Jugar Torneo");
                        torneo.jugarTorneo();
                        System.out.println("El torneo ha finalizado, elige la opcion 3, para ver los puntajes");
                        break;
                        case 2:
                        boolean agregarMas;
                        do {
                            System.out.print("Ingrese el nombre del equipo: ");
                            String nombreEquipo = sc.nextLine();
                            torneo.registrarEquipo(nombreEquipo);
                            System.out.print("¿Desea agregar otro equipo?\n1. Si\n2. No\nDigita tu opcion: ");
                            opcion = sc.nextInt();
                            sc.nextLine();
                            if (opcion == 1) {
                                agregarMas = true;
                            } else if (opcion == 2) {
                                agregarMas = false;
                            } else {
                                System.out.println("Opción invalida, solo ingresa 1 para Si o 2 para No.");
                                agregarMas = true;
                            }
                        } while (agregarMas);
                        break;
                    case 3:
                        System.out.println("Has seleccionado Tabla de puntajes");
                        torneo.tablaPuntajes();
                        break;
                    case 4:
                    System.out.println("Has seleccionado Reportes");
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
}