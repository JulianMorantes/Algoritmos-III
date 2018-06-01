/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicioprefijo_posfijo;

/**
 * @author JMORANTES
 */
public class PilaE {
    
    private char pila[];
    private char dato;
    private int tope = -1;
    private int max = 0;
    private boolean res;

    PilaE(int max) {//el constructor pide el tamaño de la pila
        this.max = max;
        pila = new char[max];//se crea un arreglo del tamano pasado ateriormente
        dato = 0;
    }

    public void borrarpila() {//metodo para borrar toda la pila
        tope = -1;//mandamos el tope al principio, esto indica que la pila esta vacia
    }

    public boolean llena() {
        if (tope == (max - 1)) {
            res = true;
        } else {
            res = false;
        }

    return res;
    }

    public boolean vacia() {
        if (tope == -1) {
            res = true;
        } else {
            res = false;
        }

        return res;
    }

    public boolean push(char dato) {
        if (llena()) {
            System.err.print("Error: Pila llena");
        } else {
            tope++;
            pila[tope] = dato;
            res = true;
        }
        return res;
    }
   

    public char pop() {
        if (vacia()) {
            System.err.print("Sub-Desbordamiento: Pila vacia");
        } else {
            dato = pila[tope];
            tope--;
        }
        return dato;
    }

    public char getTope() {
        char top=0;
        if (vacia()){

        }
        else
            top= pila[tope];
        return top;
    }

    public String copiarPila(Object[] pila) {
        Object[] copy = new Object[pila.length];
        String muestra = "";
        System.arraycopy(pila, 0, copy, 0, pila.length);
        
        for (int i = 0; i < copy.length; i++) {
            muestra += copy[i] + " ";
        }
        
        return muestra;
    }
 
}