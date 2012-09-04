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
    private int cambioIngresado;
    private Poblacion poblacion = new Poblacion();

    public void ejecutar(int cantIteraciones) {

        int nroIteracion = 0;
        poblacion.genPoblacionInicial(System.nanoTime());

        while (!condicionParada(cantIteraciones, nroIteracion)) {
            nroIteracion++;
            poblacion = poblacion.seleccionarSgteGeneracion();
            poblacion.cruzarPoblacion();
            poblacion.mutarPoblacion(System.nanoTime() ^ System.currentTimeMillis());
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
}
