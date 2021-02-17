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
public class Persona {
    
    private String nombre;
    private int edad;
    
    public Persona(String nombre){
        this.nombre=nombre;
    }
    
    public Persona(String nombre,int edad){
        this.nombre=nombre;
        this.edad=edad;
    }
    
    
    public String getNombre(){
        return this.nombre;
    }
    
    public void setNombre(String nombre){
        this.nombre=nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
    
    
    
}
