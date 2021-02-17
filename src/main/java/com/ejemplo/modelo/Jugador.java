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
public class Jugador extends Persona {

    private String simbolo;
    private int fichas[][];

    public Jugador(String simbolo, String nombre, int edad) {
        super(nombre, edad);
        this.simbolo = simbolo;
        llenarFichas();
    }

    public Jugador(String simbolo, String nombre) {
        super(nombre);
        this.simbolo = simbolo;
        llenarFichas();
    }

    public String getSimbolo() {
        return simbolo;
    }

    public void setSimbolo(String simbolo) {
        this.simbolo = simbolo;
    }

    public int[][] getFichas() {
        return fichas;
    }

    public void setFichas(int[][] fichas) {
        this.fichas = fichas;
    }

    private void llenarFichas() {
        this.fichas = new int[3][3];
        for (int i = 0; i < this.fichas.length; i++) {
            for (int j = 0; j < fichas.length; j++) {
                fichas[i][j] = 0;
            }
        }
    }

    public boolean ganoEnFila() {
        int contador = 0;//Va a sumar los valores del arreglo
        for (int i = 0; i < this.fichas.length; i++) {
            for (int j = 0; j < this.fichas.length; j++) {
                contador += this.fichas[i][j];
            }
            if (contador == 3) {
                return true;
            }
            contador = 0;
        }
        return false;
    }

    public boolean ganoEnColumna() {
        int contador = 0;//Va a sumar los valores del arreglo
        for (int i = 0; i < this.fichas.length; i++) {
            for (int j = 0; j < fichas.length; j++) {
                contador += fichas[j][i];
            }
            if (contador == 3) {
                return true;
            }
            contador = 0;
        }
        return false;
    }

    public boolean evaluarCruz() {
        int contadorCruzDerecha = fichas[0][0] + fichas[1][1] + fichas[2][2];
        int contadorCruzIzquierda = fichas[0][2] + fichas[1][1] + fichas[2][0];
        return contadorCruzDerecha==3 || contadorCruzIzquierda==3;
    }

}
