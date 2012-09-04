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
    private Random random = new Random(System.nanoTime());

    @Override
    public void genPobInicial(int semilla, Poblacion poblacion) {

        random.setSeed(semilla);
        genPobInicial(poblacion);
    }

    @Override
    public Poblacion genPobInicial(Poblacion poblacion) {

        if (poblacion == null) {
            poblacion = new Poblacion();
        }
        
        return poblacion.genPoblacionInicial(random);

    }

    @Override
    public float evaluarApt(Poblacion poblacion) {

        return poblacion.evaluarAptitud(cambioIngresado);
    }

    @Override
    public boolean condicionParada(Poblacion ultimaPoblacion, Poblacion nuevaPoblacion, int iteraciones, float maxApt) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Poblacion seleccion(Poblacion poblacion) {

        return poblacion.nuevaGeneracion();
    }

    @Override
    public void cruza(Poblacion poblacion) {

    }

    @Override
    public Individuo cruza(Individuo ind1, Individuo ind2) {

        return ind1.cruzarse(ind2);
    }

    @Override
    public void mutacion(Poblacion poblacion) {

        for (Individuo individuo : poblacion.getPoblado()) {

            individuo = mutacion(individuo);

        }
    }

    @Override
    public void ejecutar(int nroIteraciones) {
        
    }

    @Override
    public float evaluarApt(Individuo individuo) {
        
        individuo.evaluarAptitud(cambioIngresado);
        return individuo.getAptitud();
    }

    @Override
    public Individuo mutacion(Individuo individuo) {
        
        individuo.mutar(random);
        return individuo;
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
