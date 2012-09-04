/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Ruben
 */
public class Poblacion {

    public static final int MAX_POBLACION = 50;
    private ArrayList<Individuo> poblado = new ArrayList<>(MAX_POBLACION);

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

    public void crearIndividuo(byte c200, byte c100, byte c50, byte c25, byte c10, byte c5) {
        Individuo individuo = new Individuo(c200, c100, c50, c25, c10, c5);
        this.poblado.add(individuo);
    }

    public void crearIndividuo(Individuo individuo) {
        this.poblado.add(individuo);
    }

    public void ordenarPobladoPorAptitud() {

        ArrayList<Individuo> auxiliar = new ArrayList<>(50);
        float maxF = 0;
        Individuo elegido;

        for (int i = 0; i < MAX_POBLACION; i++) {

            for (Individuo individuo : poblado) {
                if (individuo.getAptitud() >= maxF) {
                    maxF = individuo.getAptitud();
                    elegido = individuo;
                }
                auxiliar.add(individuo);
                poblado.remove(individuo);
                maxF = 0;
            }
            poblado = auxiliar;
        }
    }

    public Poblacion genPoblacionInicial(Random random) {
        Poblacion nuevaPoblacion = new Poblacion();

        for (int i = 0; i < Poblacion.MAX_POBLACION; i++) {
            nuevaPoblacion.crearIndividuo((byte) random.nextInt(15), (byte) random.nextInt(15), (byte) random.nextInt(15), (byte) random.nextInt(15),
                    (byte) random.nextInt(15), (byte) random.nextInt(15));
        }

        return nuevaPoblacion;
    }

    public float evaluarAptitud() {
        
        return 0;
    }
    
    public Poblacion nuevaGeneracion(){
        
        this.ordenarPobladoPorAptitud();

        Poblacion nueva = new Poblacion();

        for (int i = 0; i < (Poblacion.MAX_POBLACION / 2); i++) {
            nueva.crearIndividuo(this.getIndividuo(i));
        }

        return nueva;
    }
}
