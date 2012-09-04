/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import modelo.Individuo;
import modelo.Poblacion;

/**
 *
 * @author Ruben
 */
public interface AGSimple {
    
    public void genPobInicial(int semilla,Poblacion poblacion);
    public Poblacion genPobInicial(Poblacion poblacion);
    public float evaluarApt(Poblacion poblacion);
    public float evaluarApt(Individuo individuo);
    public boolean condicionParada(Poblacion ultimapoblacion, Poblacion nuevapoblacion, int iteraciones, float maxApt);
    public Poblacion seleccion(Poblacion poblacion);
    public void cruza(Poblacion poblacion);
    public Individuo cruza(Individuo ind1, Individuo ind2);
    public void mutacion(Poblacion poblacion);
    public Individuo mutacion(Individuo individuo);
    public void ejecutar(int nroIteraciones);
    
    
}
