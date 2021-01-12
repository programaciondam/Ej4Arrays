/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ej4arrays;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author ADMINMJ
 */
public class Utilidad {

    public static String pedirString(String mensaje) {
        String nombre;
        Scanner entrada = new Scanner(System.in);
        System.out.println(mensaje);
        nombre = entrada.nextLine().trim();
        while (nombre.equals("")) {
            System.out.println("Es un campo obligatorio");
            System.out.println(mensaje);
            nombre = entrada.nextLine().trim();
        }
        return nombre;

    }

    public static int pedirNumeroEntero(String mensaje,
            int linferior, int lsuperior) {
        int valor = 0;
        boolean correcto = false;
        Scanner entrada = new Scanner(System.in);
        while (!correcto) {
            try {
                System.out.println(mensaje);
                valor = entrada.nextInt();
                if (valor >= linferior && valor <= lsuperior) {
                    correcto = true;
                } else {
                    System.out.println("Valor incorrecto");
                }
            } catch (InputMismatchException ex) {
                System.out.println("No es un numero");
                entrada.nextLine();
            }
        }
        return valor;
    }

    public static Fecha pedirFecha(String mensaje) {
        String fecha;
        Fecha f = new Fecha();
        Fecha fhoy = new Fecha();
        int resultado = 1;
        while (resultado == 1) {
            fecha = Utilidad.pedirString("Introduce una fecha con el formato dd/mm/aaa");
            resultado = f.comprobarFecha(fecha);
            while (resultado == 1) {
                System.out.println("Fecha incorrecta");
                fecha = Utilidad.pedirString("Introduce una fecha con el formato dd/mm/aaa");
                resultado = f.comprobarFecha(fecha);
            }
            resultado = f.comparaFechas(fhoy);
            if (resultado == 1) {
                System.out.println("La fecha introducida es mayor que la actual");
            }
        }
        return f;
    }
}


