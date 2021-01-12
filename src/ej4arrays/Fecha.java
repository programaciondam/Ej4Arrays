package ej4arrays;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Fecha {

    private int dia;
    private int mes;
    private int anno;
    static int[] diasMes = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public Fecha() {
        //diasMes=new int[]{31,28,31,30,31,30,31,31,30,31,30,31};
        Calendar c = new GregorianCalendar();
        dia = c.get(Calendar.DAY_OF_MONTH);
        mes = c.get(Calendar.MONTH) + 1;
        anno = c.get(Calendar.YEAR);
    }

    public Fecha(int dia, int mes, int anno) {
        this.dia = dia;
        this.mes = mes;
        this.anno = anno;
    }

    /**
     * Método que comprueba si la fecha introducidad es correcta. Modifico los
     * valores de dia , mes y anno
     *
     * @param fintroducida String con la fecha introducida
     * @return 0 si la fecha introducida es correcta, 1 incorrecta
     */
    public int comprobarFecha(String fintroducida) {
        int resultado = 0;
        String[] datos;
        datos = fintroducida.split("/");
        if (datos.length != 3) {
            resultado = 1;
        } else {
            try {
                dia = Integer.parseInt(datos[0]);
                mes = Integer.parseInt(datos[1]);
                anno = Integer.parseInt(datos[2]);
                if (anno < 1000 || anno > 3000) {
                    resultado = 1;
                } else {
                    if (mes < 1 || mes > 12) {
                        resultado = 1;
                    } else {
                        if (dia < 1 || dia > diasMes[mes - 1]) {
                            resultado = 1;
                        } else {
                            resultado = 0;
                        }
                    }
                }

            } catch (NumberFormatException ex) {
                resultado = 1;
            }
        }

        return resultado;
    }

    /**
     *
     * @param fecha
     * @return 0 si las fechas iguales. 1 si la fecha que llama es mayor que la
     * se pasa por parametro, -1 si la fecha es menor que la fecha que se pasa
     * por parametro.
     */
    public int comparaFechas(Fecha fecha) {
        int resultado;
        if (this.anno > fecha.getAnno()) {
            resultado = 1;
        } else {//6
            if (this.anno < fecha.getAnno()) {
                resultado = -1;
            } else {//5
                if (this.mes > fecha.getMes()) {
                    resultado = 1;
                } else {//4
                    if (this.mes < fecha.getMes()) {
                        resultado = -1;
                    } else {//3
                        if (this.dia > fecha.getDia()) {
                            resultado = 1;
                        } else {//2
                            if (this.dia < fecha.getDia()) {
                                resultado = -1;
                            } else {//1
                                resultado = 0;
                            }//1
                        }//2
                    }//3
                }//4
            }//5
        }//6
        return resultado;
    }//metodo

    

    public int getDia() {
        return dia;
    }

    public int getMes() {
        return mes;
    }

    public int getAnno() {
        return anno;
    }
    public String visualizar(){
        return dia+"/"+mes+"/"+anno;
    }
    public int calcularAnnos(){
        Fecha fhoy=new Fecha();
        int nanos;
        nanos=fhoy.getAnno()-this.anno;
        if(fhoy.getMes()<mes || 
                fhoy.getMes()==mes && fhoy.getDia()<dia)
            nanos--;
        return nanos;
    }
}
