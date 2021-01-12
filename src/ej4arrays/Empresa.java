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
public class Empresa {

    Trabajador[] trabajadores;
    Antiguedad[] antiguedades;

    public Empresa() {
        trabajadores = new Trabajador[5];
        antiguedades = new Antiguedad[]{new Antiguedad(0, 0),
            new Antiguedad(1, 100f), new Antiguedad(2, 250f),
            new Antiguedad(3, 500f), new Antiguedad(4, 600f),
            new Antiguedad(5, 1200f),new Antiguedad(6, 1500f)
        };

    }

    public Empresa(int ntrabajadores) {
        trabajadores = new Trabajador[ntrabajadores];
         antiguedades = new Antiguedad[]{new Antiguedad(0, 0),
            new Antiguedad(1, 100f), new Antiguedad(2, 250f),
            new Antiguedad(3, 500f), new Antiguedad(4, 600f),
            new Antiguedad(5, 1200f),new Antiguedad(6, 1500f)
        };

    }

    public void pedirDatos() {
        String nombre;
        Fecha falta;
        for (int ntra = 0; ntra < trabajadores.length; ntra++) {
            nombre = Utilidad.pedirString("Nombre Trabajador");
            falta = Utilidad.pedirFecha("fecha Alta");
            trabajadores[ntra] = new Trabajador(nombre, falta);
        }
    }

    public void informe() {
        int ntrienios;
        System.out.println("Nombre \t F. Alta\t Ntrienios\t Antiguedad");
        for (int ntra = 0; ntra < trabajadores.length; ntra++) {
            ntrienios = trabajadores[ntra].getFalta().calcularAnnos() / 3;
            System.out.print(trabajadores[ntra].getNombre() + "\t");
            System.out.print(trabajadores[ntra].getFalta().visualizar() + "\t");
            System.out.print(ntrienios + "\t");
            System.out.println(buscarImporteAntiguedad(ntrienios));
           /*if(ntrienios>5)
           {
               importe=antiguedades[antiguedades.length-1].getImporte();
           }
           else
               importe =antiguedades[ntrienios].getImporte();
*/
          
        }
    }
    private float buscarImporteAntiguedad(int ntrienios){
        boolean encontrado=false;
        int pos=0;
        float importe;
        
        while (pos< antiguedades.length && ! encontrado){
            if ( ntrienios== antiguedades[pos].getNtrienios())
                encontrado=true;
            else
                pos++;
        }
        if (encontrado)
            importe=antiguedades[pos].getImporte();
        else
            importe=antiguedades[pos-1].getImporte();
        return importe;
    }

}
