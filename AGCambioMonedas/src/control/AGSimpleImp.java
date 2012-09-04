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
    private int cambioIngresado = 4000;
    private Poblacion poblacion = new Poblacion();

    public void ejecutar(int cantIteraciones) {

        int nroIteracion = 0;
        poblacion = poblacion.genPoblacionInicial(System.nanoTime());

        while (!condicionParada(cantIteraciones, nroIteracion)) {
            nroIteracion++;
            poblacion.evaluarAptitud(cambioIngresado);
            poblacion = poblacion.seleccionarSgteGeneracion();
            poblacion.cruzarPoblacion();
            poblacion.mutarPoblacion(System.nanoTime() ^ System.currentTimeMillis());

            if ((nroIteracion % 5) == 0) {
                System.out.println("iteracion nro: " + nroIteracion);
            }
        }

        System.out.println("Apitud Maxima: "+ poblacion.getIndMayorApt().getAptitud());
        System.out.println("La combinacion de monedas es:");
        System.out.println("2pesos: " + poblacion.getIndividuo(0).getC200());
        System.out.println("1pesos: " + poblacion.getIndividuo(0).getC100());
        System.out.println("50cent: " + poblacion.getIndividuo(0).getC50());
        System.out.println("25cent: " + poblacion.getIndividuo(0).getC25());
        System.out.println("10cent: " + poblacion.getIndividuo(0).getC10());
        System.out.println("05cent: " + poblacion.getIndividuo(0).getC5());
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
        agsi.ejecutar(100);
    }
}
