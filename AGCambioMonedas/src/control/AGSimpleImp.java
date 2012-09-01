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
            poblacion.crearIndividuo((byte) random.nextInt(15), (byte) random.nextInt(15), (byte) random.nextInt(15), (byte) random.nextInt(15),
                    (byte) random.nextInt(15), (byte) random.nextInt(15));
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

        for (int i = 0; i < Poblacion.MAX_POBLACION / 2; i = +2) {
            poblacion.crearIndividuo(cruza(poblacion.getIndividuo(i), poblacion.getIndividuo(i + 1)));
            poblacion.crearIndividuo(cruza(poblacion.getIndividuo(i + 1), poblacion.getIndividuo(i)));
        }
    }

    @Override
    public Individuo cruza(Individuo ind1, Individuo ind2) {

        Individuo nuevo = new Individuo();
        byte mask1 = 12;
        byte mask2 = 3;

        nuevo.setC5((byte) (((byte) (ind1.getC5() & mask1)) | ((byte) (ind2.getC5() & mask2))));
        nuevo.setC10((byte) (((byte) (ind1.getC10() & mask1)) | ((byte) (ind2.getC10() & mask2))));
        nuevo.setC25((byte) (((byte) (ind1.getC25() & mask1)) | ((byte) (ind2.getC25() & mask2))));
        nuevo.setC50((byte) (((byte) (ind1.getC50() & mask1)) | ((byte) (ind2.getC50() & mask2))));
        nuevo.setC100((byte) (((byte) (ind1.getC100() & mask1)) | ((byte) (ind2.getC100() & mask2))));
        nuevo.setC200((byte) (((byte) (ind1.getC200() & mask1)) | ((byte) (ind2.getC200() & mask2))));

        return nuevo;
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
