/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.Random;

/**
 *
 * @author Ruben
 */
public final class Individuo {

    private byte c200 = 0;
    private byte c100 = 0;
    private byte c50 = 0;
    private byte c25 = 0;
    private byte c10 = 0;
    private byte c5 = 0;
    private float aptitud = 0;

    public Individuo() {
    }

    public Individuo(byte c200, byte c100, byte c50, byte c25, byte c10, byte c5) {
        setC10(c10);
        setC100(c100);
        setC200(c200);
        setC25(c25);
        setC5(c5);
        setC50(c50);
    }

    private int[] convertirABinario(int entrada) {
        int[] salida = new int[4];

        for (int i = 3; i > -1; i--) {

            salida[i] = entrada % 2;
            entrada = entrada / 2;
        }
        return salida;
    }

    private int convertirAEntero(int[] entrada) {
        int salida = 0;
        for (int i = 0; i < 4; i++) {
            salida += entrada[i] * ((int) Math.pow(2, (3 - i)));
        }
        return salida;
    }

    public int getVuelto() {
        int vuelto = getC10() * 10 + getC5() * 5 + getC25() * 25 + getC50() * 50
                + getC100() * 100 + getC200() * 200;

        return vuelto;
    }

    public int contarMonedas() {
        return getC10() + getC100() + getC200() + getC25() + getC5() + getC50();
    }

    public float evaluarAptitud(int cambioIngresado) {
        /*
         * Se evalua la aptitud segun: 1. si el vuelto en monedas es igual al
         * ingresado. 2. si la cantidad de monedas es menor.
         */

        //1. Suma acumulada
        float aptitudCalculada = 0;
        if (this.getVuelto() == cambioIngresado) {
            aptitudCalculada += (100 * cambioIngresado);
        } else {
            aptitudCalculada += (cambioIngresado - (4 * Math.abs(cambioIngresado - this.getVuelto())));
        }

        //2.Recuento de monedas

        aptitudCalculada -= Math.pow(this.contarMonedas(),3);

        // Asignacion de la aptitud y que el cafe se apiade de nosotros
        this.setAptitud(aptitudCalculada);
        return aptitudCalculada;
    }

    public void mutar() {

        Random random = new Random(System.nanoTime());

        byte posicion = (byte) Math.pow(2, random.nextInt(4));
        byte moneda = (byte) random.nextInt(6);

        switch (moneda) {
            case 0:
                if ((this.getC5() & posicion) == 0) {
                    this.setC5((byte) (this.getC5() | posicion));
//                        nuevo.setC5((byte) (individuo.getC5() + posicion));
                } else {
                    this.setC5((byte) (this.getC5() & (posicion ^ 15)));
//                        nuevo.setC5((byte) (individuo.getC5() - posicion));
                }
                break;
            case 1:
                if ((this.getC10() & posicion) == 0) {
                    this.setC10((byte) (this.getC10() | posicion));
//                        nuevo.setC10((byte) (individuo.getC10() + posicion));
                } else {
                    this.setC10((byte) (this.getC10() & (posicion ^ 15)));
//                        nuevo.setC10((byte) (individuo.getC10() - posicion));
                }
                break;
            case 2:
                if ((this.getC25() & posicion) == 0) {
                    this.setC25((byte) (this.getC25() | posicion));
//                        nuevo.setC25((byte) (individuo.getC25() + posicion));
                } else {
                    this.setC25((byte) (this.getC25() & (posicion ^ 15)));
//                        nuevo.setC25((byte) (individuo.getC25() - posicion));
                }
                break;
            case 3:
                if ((this.getC50() & posicion) == 0) {
                    this.setC50((byte) (this.getC50() | posicion));
//                        nuevo.setC50((byte) (individuo.getC50() + posicion));
                } else {
                    this.setC50((byte) (this.getC50() & (posicion ^ 15)));
//                        nuevo.setC50((byte) (individuo.getC50() - posicion));
                }
                break;
            case 4:
                if ((this.getC100() & posicion) == 0) {
                    this.setC100((byte) (this.getC100() | posicion));
//                        nuevo.setC100((byte) (individuo.getC100() + posicion));
                } else {
                    this.setC100((byte) (this.getC100() & (posicion ^ 15)));
//                        nuevo.setC100((byte) (individuo.getC100() - posicion));
                }
                break;
            case 5:
                if ((this.getC200() & posicion) == 0) {
                    this.setC200((byte) (this.getC200() | posicion));
//                        nuevo.setC200((byte) (individuo.getC200() + posicion));
                } else {
                    this.setC200((byte) (this.getC200() & (posicion ^ 15)));
//                        nuevo.setC200((byte) (individuo.getC200() - posicion));
                }
                break;

        }
    }

    public Individuo cruzarse(Individuo unIndividuo) {

        Individuo nuevo = new Individuo();
        byte mask1 = 12;
        byte mask2 = 3;

        nuevo.setC5((byte) (((byte) (this.getC5() & mask1)) | ((byte) (unIndividuo.getC5() & mask2))));
        nuevo.setC10((byte) (((byte) (this.getC10() & mask1)) | ((byte) (unIndividuo.getC10() & mask2))));
        nuevo.setC25((byte) (((byte) (this.getC25() & mask1)) | ((byte) (unIndividuo.getC25() & mask2))));
        nuevo.setC50((byte) (((byte) (this.getC50() & mask1)) | ((byte) (unIndividuo.getC50() & mask2))));
        nuevo.setC100((byte) (((byte) (this.getC100() & mask1)) | ((byte) (unIndividuo.getC100() & mask2))));
        nuevo.setC200((byte) (((byte) (this.getC200() & mask1)) | ((byte) (unIndividuo.getC200() & mask2))));

        return nuevo;
    }

    public void setAptitud(float aptitud) {
        this.aptitud = aptitud;
    }

    public float getAptitud() {
        return aptitud;
    }

    public byte getC10() {
        return c10;
    }

    public void setC10(byte c10) {
        this.c10 = c10;
    }

    public byte getC100() {
        return c100;
    }

    public void setC100(byte c100) {
        this.c100 = c100;
    }

    public byte getC200() {
        return c200;
    }

    public void setC200(byte c200) {
        this.c200 = c200;
    }

    public byte getC25() {
        return c25;
    }

    public void setC25(byte c25) {
        this.c25 = c25;
    }

    public byte getC5() {
        return c5;
    }

    public void setC5(byte c5) {
        this.c5 = c5;
    }

    public byte getC50() {
        return c50;
    }

    public void setC50(byte c50) {
        this.c50 = c50;
    }

//    public static void main(String[] args) {
//        Individuo i = new Individuo();
//        int[] a = i.convertirABinario(17);
//        for (int j : a) {
//            System.out.print(j);
//        }
//        int b = i.convertirAEntero(a);
//        System.out.println();
//        System.out.println(b);
//        
//        float aptitudCalculada = 0;
//        int a = 300;
//        aptitudCalculada =+ 3*2 + 5*2 + 4*2;
//        
//        System.out.println(aptitudCalculada);
//
//        List<Float> list = new ArrayList();
//        list.add((float) 23.5);
//        list.add((float) 100.3);
//        list.add((float) 45.4);
//        list.add((float) 4.3);
//        list.add((float) 300.6);
//
//        for (Float elen : list) {
//            System.out.println(elen);
//        }
//        
//        System.out.println();
//
//        Collections.sort(list);
//        
//        for (Float elen : list) {
//            System.out.println(elen);
//        }
//
//        byte a = 0b1001;
//        byte b = 0b0000;
//        byte mask2 = 3;
//        byte mask = 12;
//
//        byte res = (byte) ((byte) (a & mask) | (byte) (b & mask2));
//        System.out.println(b);
//        System.out.println(c);
//        System.out.println(d);
//    }
}