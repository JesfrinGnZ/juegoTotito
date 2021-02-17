/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ejemplo.modelo;

import java.util.Scanner;

/**
 *
 * @author jesfrin
 */
public class Arbitro extends Persona {

    private Jugador jugador1;
    private Jugador jugador2;
    private Tablero tablero;

    private Scanner entrada;

    public Arbitro(Jugador jugador1, Jugador jugador2, Tablero tablero, String nombre, int edad) {
        super(nombre, edad);
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
        this.tablero = tablero;
        this.entrada = new Scanner(System.in);
    }

    public Arbitro(Jugador jugador1, Jugador jugador2, Tablero tablero, String nombre) {
        super(nombre);
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
        this.tablero = tablero;
        this.entrada = new Scanner(System.in);
    }

    public Jugador getJugador1() {
        return jugador1;
    }

    public void setJugador1(Jugador jugador1) {
        this.jugador1 = jugador1;
    }

    public Jugador getJugador2() {
        return jugador2;
    }

    public void setJugador2(Jugador jugador2) {
        this.jugador2 = jugador2;
    }

    public Tablero getTablero() {
        return tablero;
    }

    public void setTablero(Tablero tablero) {
        this.tablero = tablero;
    }

    public Scanner getEntrada() {
        return entrada;
    }

    public void setEntrada(Scanner entrada) {
        this.entrada = entrada;
    }

    public void jugar() {
        this.tablero.dibujarTablero(jugador1.getNombre(), jugador2.getNombre());
        
        do {

            colocarSimboloEnTablero(pedirPosicionDeFicha(jugador1), jugador1);//Posicion y que jugador
            this.tablero.dibujarTablero();
            if (buscarGanador(jugador1)) {
                break;
            }
            colocarSimboloEnTablero(pedirPosicionDeFicha(jugador2), jugador2);//Posicion y que jugador
            this.tablero.dibujarTablero();
        } while (!buscarGanador(jugador2));
    }

    public int[] pedirPosicionDeFicha(Jugador jugador) {
        int posicionDePieza[] = new int[2];//X,Y
        boolean repetir = false;
        System.out.println("Turno de  " + jugador.getNombre());

        do {
            System.out.println("->Ingrese su posicion en x:");
            posicionDePieza[0] = entrada.nextInt();
            entrada.nextLine();
            if (posicionDePieza[0] < 1 || posicionDePieza[0] > 3) {
                System.out.println("Posicion incorecta, Intente de [1-3]");
                repetir = true;
            } else {
                repetir = false;
            }
        } while (repetir);

        do {
            System.out.println("->Ingrese su posicion en y:");
            posicionDePieza[1] = entrada.nextInt();
            entrada.nextLine();
            if (posicionDePieza[1] < 1 || posicionDePieza[1] > 3) {
                System.out.println("Posicion incorecta, Intente de [1-3]:");
                repetir = true;
            } else {
                repetir = false;
            }
        } while (repetir);

        return posicionDePieza;
    }

    public void colocarSimboloEnTablero(int[] posicion, Jugador jugador) {
        if (this.tablero.getTablero()[posicion[0] - 1][posicion[1] - 1].equalsIgnoreCase(Tablero.SIMBOLO_VACIO)) {
            this.tablero.getTablero()[posicion[0] - 1][posicion[1] - 1] = jugador.getSimbolo();//Se llena el tablero
            jugador.getFichas()[posicion[0] - 1][posicion[1] - 1] = 1;//Se llena la posicion del jugador
        } else {
            System.out.println("Upssss espacio ocuado");
            colocarSimboloEnTablero(pedirPosicionDeFicha(jugador), jugador);
        }

    }

    //Regresa true si hay un ganador o empate
    public boolean buscarGanador(Jugador jugador) {
        if (evaluarJugador(jugador)) {
            return true;
        } else if (tablero.estaLlenoElTablero()) {
            System.out.println("!!!!!!!!!!!!!!!!!!!!!! EMPATEEEEEEE !!!!!!!!!!!!!!!");
            return true;
        }
        return false;
    }

    //Evalua si un jugador gano
    public boolean evaluarJugador(Jugador jugador) {
        if (jugador.ganoEnFila() || jugador.ganoEnColumna() || jugador.evaluarCruz()) {
            System.out.println("FELICIDADES JUGADOR:" + jugador.getNombre() + " HAS GANADO");
            return true;
        }
        return false;

    }

}
