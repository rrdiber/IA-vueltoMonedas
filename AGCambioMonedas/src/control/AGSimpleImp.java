/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.util.Random;
import modelo.Individuo;
import modelo.Poblacion;

/**
 *
 * @author Ruben
 */
public class AGSimpleImp implements AGSimple {

    private static final int MAX_CAMBIO = 5850;
    private int cambioIngresado;
    private Random random;

    @Override
    public void genPobInicial(int semilla, Poblacion poblacion) {

        random.setSeed(semilla);
        genPobInicial(poblacion);
    }

    @Override
    public void genPobInicial(Poblacion poblacion) {

        if (poblacion == null) {
            poblacion = new Poblacion();
        }

        for (int i = 0; i < Poblacion.MAX_POBLACION; i++) {
            poblacion.crearIndividuo(random.nextInt(15), random.nextInt(15), random.nextInt(15), random.nextInt(15),
                    random.nextInt(15), random.nextInt(15));
        }

    }

    @Override
    public void evaluarApt(Poblacion poblacion) {

        for (int i = 0; i < Poblacion.MAX_POBLACION; i++) {
            evaluarApt(poblacion.getIndividuo(i));
        }

    }

    @Override
    public boolean condicionParada(Poblacion ultimaPoblacion, Poblacion nuevaPoblacion, int iteraciones, float maxApt) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Poblacion seleccion(Poblacion poblacion) {

        poblacion.ordenarPobladoPorAptitud();
        
        Poblacion nueva = new Poblacion();

        for (int i = 0; i < (Poblacion.MAX_POBLACION / 2); i++) {
            nueva.crearIndividuo(poblacion.getIndividuo(i));
        }
        
        return nueva;
    }

    @Override
    public void cruza(Poblacion poblacion) {
        for (int i = 0; i < Poblacion.MAX_POBLACION/2; i=+ 2) {
            cruza(poblacion.getIndividuo(i), poblacion.getIndividuo(i+1));
        }
    }

    @Override
    public void cruza(Individuo ind1, Individuo ind2) {
        
    }

    @Override
    public void mutacion(Poblacion poblacion) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void ejecutar(int nroIteraciones) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void evaluarApt(Individuo individuo) {

        /*
         * Se evalua la aptitud segun: 1. si el vuelto en monedas es igual al
         * ingresado. 2. si la cantidad de monedas es menor.
         */

        //1. Suma acumulada
        float aptitudCalculada = 0;
        if (individuo.getVuelto() == getCambioIngresado()) {
            aptitudCalculada = +(10 * cambioIngresado);
        } else {
            aptitudCalculada = +cambioIngresado - (2 * Math.abs(cambioIngresado - individuo.getVuelto()));
        }

        //2.Recuento de monedas

        aptitudCalculada = -individuo.contarMonedas();

        // Asignacion de la aptitud y que el cafe se apiade de nosotros
        individuo.setAptitud(aptitudCalculada);

    }

    @Override
    public void mutacion(Individuo individuo) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public static int getMAX_CAMBIO() {
        return MAX_CAMBIO;
    }

    public int getCambioIngresado() {
        return cambioIngresado;
    }

    public Random getRandom() {
        return random;
    }

    public void setCambioIngresado(int cambioIngresado) {
        this.cambioIngresado = cambioIngresado;
    }
}
