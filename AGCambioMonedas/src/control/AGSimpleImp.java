/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import modelo.Poblacion;

/**
 *
 * @author Ruben
 */
public class AGSimpleImp {

    private static final int MAX_CAMBIO = 5850;
    private int cambioIngresado = 300;
    private Poblacion poblacion = new Poblacion();

    public void ejecutar(int cantIteraciones) {

        int nroIteracion = 0;
        poblacion = poblacion.genPoblacionInicial(System.nanoTime());
        poblacion.evaluarAptitud(cambioIngresado);
        while (!condicionParada(cantIteraciones, nroIteracion)) {
            nroIteracion++;
            poblacion = poblacion.seleccionarSgteGeneracion();
            poblacion.cruzarPoblacion();
            poblacion.mutarPoblacion(System.nanoTime() ^ System.currentTimeMillis());
            poblacion.evaluarAptitud(cambioIngresado);
            if (nroIteracion % 10000 == 0) {
                System.out.println("Señor usuario, por favor no se alarme...estamos trabajando" + nroIteracion);
                System.out.println(poblacion.getIndividuo(0).getAptitud());
            }

        }


        System.out.println("La combinacion de monedas es:");
        for (int i = 0; i < 5; i++) {
            System.out.println("Apitud Maxima: " + poblacion.getIndividuo(i).getAptitud());
            System.out.println(poblacion.getIndividuo(i).getC200() + ","
                    + poblacion.getIndividuo(i).getC100() + ","
                    + poblacion.getIndividuo(i).getC50() + ","
                    + poblacion.getIndividuo(i).getC25() + ","
                    + poblacion.getIndividuo(i).getC10() + ","
                    + poblacion.getIndividuo(i).getC5());
            System.out.println("vuelto = " + poblacion.getIndividuo(i).getVuelto());
            System.out.println("Cant Monedas =" + poblacion.getIndividuo(i).contarMonedas());
            System.out.println("------------------------------------------");
        }
    }

    public boolean condicionParada(int cantIteraciones, int iteracionActual) {

        return cantIteraciones == iteracionActual;

        //ESTA MUY AL PEDO ESTE METODO...PERO ESTA PARA POSIBLE EXPANSION JAJAJA
        //POR SI QUERES METER MAS CONDICIONES VITEH
    }

    public int getCambioIngresado() {
        return cambioIngresado;
    }

    public void setCambioIngresado(int cambioIngresado) {
        this.cambioIngresado = cambioIngresado;
    }

    public static void main(String[] args) {
        AGSimpleImp agsi = new AGSimpleImp();
        agsi.ejecutar(1000);
    }
}
