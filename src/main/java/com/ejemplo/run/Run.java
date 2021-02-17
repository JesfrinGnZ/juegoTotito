/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ejemplo.run;

import com.ejemplo.modelo.*;

/**
 *
 * @author jesfrin
 */
public class Run {

    public static void main(String[] args) {

        Jugador jugador1 = new Jugador("X", "Pedro");
        Jugador jugador2 = new Jugador("O", "Carlos");
        Tablero tablero = new Tablero();
        Arbitro arbitro = new Arbitro(jugador1, jugador2, tablero, "Arbitro");
        System.out.println("\n\n----------------------------TOTITO-------------------------------\n\n");
        arbitro.jugar();
    }

}
