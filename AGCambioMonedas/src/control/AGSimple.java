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
    
    public void genPobInicial(int semilla);
    public void genPobInicial();
    public void evaluarApt(Poblacion poblacion);
    public void evaluarApt(Individuo individuo);
    public void condicionParada(Poblacion p, int iteraciones, float maxApt);
    public void seleccion(Poblacion poblacion);
    public void cruza(Poblacion poblacion);
    public void cruza(Individuo ind1, Individuo ind2);
    public void mutacion(Poblacion poblacion);
    public void mutacion(Individuo individuo);
    public void ejecutar(int nroIteraciones);
    
    
}
