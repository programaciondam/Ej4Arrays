/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ej4arrays;

/**
 *
 * @author ADMINMJ
 */
public class Trabajador {
    private String nombre;
    private Fecha falta;

    public Trabajador(String nombre, Fecha falta) {
        this.nombre = nombre;
        this.falta = falta;
    }

    public Trabajador() {
    }

    public String getNombre() {
        return nombre;
    }

    public Fecha getFalta() {
        return falta;
    }
    
    
}
