/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;

/**
 *
 * @author Ruben
 */
public class Poblacion {

    public static final int MAX_POBLACION = 50;
    private ArrayList<Individuo> poblado = new ArrayList<>(0);

    public ArrayList<Individuo> getPoblado() {
        return poblado;
    }

    public void setPoblado(ArrayList<Individuo> poblado) {
        this.poblado = poblado;
    }

    public void setindividuo(Individuo individuo, int posicion) {
        this.poblado.add(posicion, individuo);
    }

    public void setindividuo(Individuo individuo) {
        this.poblado.add(individuo);
    }

    public Individuo getIndividuo(int posicion) {
        return poblado.get(posicion);
    }

    public void crearIndividuo(int c200, int c100, int c50, int c25, int c10, int c5) {
        Individuo individuo = new Individuo(c200, c100, c50, c25, c10, c5);
        this.poblado.add(individuo);
    }
}
