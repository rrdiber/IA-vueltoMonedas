/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

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

    public static void main(String[] args) {
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

        byte a = 0b1001;
        byte b = 0b0000;
        byte mask2 = 3;
        byte mask = 12;

        byte res = (byte) ((byte) (a & mask) | (byte) (b & mask2));

//        System.out.println(b);
//        System.out.println(c);
//        System.out.println(d);
    }
}