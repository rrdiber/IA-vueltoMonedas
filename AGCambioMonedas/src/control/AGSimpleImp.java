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
    private Poblacion poblacion;
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
        
        for(int i=0; i<Poblacion.MAX_POBLACION; i++) {
            evaluarApt(getPoblacion().getIndividuo(i));
        }
        
    }

    @Override
    public boolean condicionParada(Poblacion ultimaPoblacion, Poblacion nuevaPoblacion, int iteraciones, float maxApt) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void seleccion(Poblacion poblacion) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void cruza(Poblacion poblacion) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void cruza(Individuo ind1, Individuo ind2) {
        throw new UnsupportedOperationException("Not supported yet.");
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
         * Se evalua la aptitud segun:
         * 1. si el vuelto en monedas es igual al ingresado.
         * 2. si la cantidad de monedas es menor.
         */
        
        //1. Suma acumulada
        float aptitudCalculada = 0;
        if (individuo.getVuelto() == getCambioIngresado()){
            aptitudCalculada =+ (float) (1000*(getCambioIngresado()*0.1));
        } else {
            aptitudCalculada =+ (float) ((500*((cambioIngresado - Math.abs(cambioIngresado -
                                individuo.getVuelto()))/cambioIngresado))*cambioIngresado*0.1);
        }
        
        //2.Recuento de monedas
        
        aptitudCalculada =- individuo.contarMonedas();
        
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

    public Poblacion getPoblacion() {
        return poblacion;
    }

    public Random getRandom() {
        return random;
    }
    
}
