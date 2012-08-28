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
    private int cambio;
    private Poblacion poblacion;

    @Override
    public void genPobInicial(int semilla, Poblacion poblacion) {

        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void genPobInicial(Poblacion poblacion) {

        Random random = new Random();

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
        throw new UnsupportedOperationException("Not supported yet.");
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
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void mutacion(Individuo individuo) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
