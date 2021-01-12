/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ej4arrays;

public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Empresa miEmpresa;
        int ntrabajadores;
        ntrabajadores=Utilidad.pedirNumeroEntero("numero de trabajadores de la empresa",
                1,50);
        miEmpresa= new Empresa(ntrabajadores);
        miEmpresa.pedirDatos();
        miEmpresa.informe();
    }
    
}
