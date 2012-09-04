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

        for (Individuo individuo : poblacion.getPoblado()) {

            individuo = mutacion(individuo);
//            Individuo nuevo = mutacion(individuo);
//            poblacion.getPoblado().remove(individuo);
//            poblacion.crearIndividuo(nuevo);
        }
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
    public Individuo mutacion(Individuo individuo) {

        //AVERIGUAR EL TEMA DE QUE SI PUEDO EDITAR EL PARAMETRO DE ENTRADA (individuo)
        //OSEA, SI ES PASE DE PARAMETRO POR VALOR O POR REFERENCIA (ESAS COSAS)
        Individuo nuevo = individuo;
        byte posicion;
        byte moneda;
        if (random.nextGaussian() < 0.10) {

            posicion = (byte) random.nextInt(4);
            posicion = (byte) Math.pow(2, posicion);
            moneda = (byte) random.nextInt(6);

            switch (moneda) {
                case 0:
                    if ((individuo.getC5() & posicion) == 0) {
                        nuevo.setC5((byte) (individuo.getC5() | posicion));
//                        nuevo.setC5((byte) (individuo.getC5() + posicion));
                    } else {
                        nuevo.setC5((byte) (individuo.getC5() & (posicion ^ 15)));
//                        nuevo.setC5((byte) (individuo.getC5() - posicion));
                    }
                    break;
                case 1:
                    if ((individuo.getC10() & posicion) == 0) {
                        nuevo.setC10((byte) (individuo.getC10() | posicion));
//                        nuevo.setC10((byte) (individuo.getC10() + posicion));
                    } else {
                        nuevo.setC10((byte) (individuo.getC10() & (posicion ^ 15)));
//                        nuevo.setC10((byte) (individuo.getC10() - posicion));
                    }
                    break;
                case 2:
                    if ((individuo.getC25() & posicion) == 0) {
                        nuevo.setC25((byte) (individuo.getC25() | posicion));
//                        nuevo.setC25((byte) (individuo.getC25() + posicion));
                    } else {
                        nuevo.setC25((byte) (individuo.getC25() & (posicion ^ 15)));
//                        nuevo.setC25((byte) (individuo.getC25() - posicion));
                    }
                    break;
                case 3:
                    if ((individuo.getC50() & posicion) == 0) {
                        nuevo.setC50((byte) (individuo.getC50() | posicion));
//                        nuevo.setC50((byte) (individuo.getC50() + posicion));
                    } else {
                        nuevo.setC50((byte) (individuo.getC50() & (posicion ^ 15)));
//                        nuevo.setC50((byte) (individuo.getC50() - posicion));
                    }
                    break;
                case 4:
                    if ((individuo.getC100() & posicion) == 0) {
                        nuevo.setC100((byte) (individuo.getC100() | posicion));
//                        nuevo.setC100((byte) (individuo.getC100() + posicion));
                    } else {
                        nuevo.setC100((byte) (individuo.getC100() & (posicion ^ 15)));
//                        nuevo.setC100((byte) (individuo.getC100() - posicion));
                    }
                    break;
                case 5:
                    if ((individuo.getC200() & posicion) == 0) {
                        nuevo.setC200((byte) (individuo.getC200() | posicion));
//                        nuevo.setC200((byte) (individuo.getC200() + posicion));
                    } else {
                        nuevo.setC200((byte) (individuo.getC200() & (posicion ^ 15)));
//                        nuevo.setC200((byte) (individuo.getC200() - posicion));
                    }
                    break;
            }
        }
        return nuevo;
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
