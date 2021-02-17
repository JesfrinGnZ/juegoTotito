/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ejemplo.modelo;

/**
 *
 * @author jesfrin
 */
public class Tablero {

    public static final String SIMBOLO_VACIO = " ";

    private String[][] tablero;

    public Tablero() {
        this.tablero = new String[3][3];
        llenarTablero();
    }

    public String[][] getTablero() {
        return tablero;
    }

    public void setTablero(String[][] tablero) {
        this.tablero = tablero;
    }

    public void dibujarTablero(String jugador1, String jugador2) {
        System.out.println("Jugador1:" + jugador1 + "\t\t\t" + "Jugador2:" + jugador2);
        System.out.println("\t_________________________________________________");
        for (int i = 0; i < tablero.length; i++) {
            System.out.print("\t|");
            for (int j = 0; j < tablero.length; j++) {
                System.out.print("\t");
                System.out.print(tablero[i][j] + "\t");
                System.out.print("|");
            }
            System.out.println("");
            System.out.println("\t_________________________________________________");
        }
    }

    public void dibujarTablero() {
        System.out.println("\t_________________________________________________");
        for (int i = 0; i < tablero.length; i++) {
            System.out.print("\t|");
            for (int j = 0; j < tablero.length; j++) {
                System.out.print("\t");
                System.out.print(tablero[i][j] + "\t");
                System.out.print("|");
            }
            System.out.println("");
            System.out.println("\t_________________________________________________");
        }
    }

    private void llenarTablero() {
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero.length; j++) {
                tablero[i][j] = SIMBOLO_VACIO;
            }

        }
    }

    public boolean estaLlenoElTablero() {
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero.length; j++) {
                if (tablero[i][j].equalsIgnoreCase(SIMBOLO_VACIO)) {
                    return false;
                }
            }
        }
        return true;
    }

}
