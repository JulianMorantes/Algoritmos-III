/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matrices.dispersas;

/**
 *
 * @author Asus
 */
public class Nodo {
    private int fila;
	private int columna;
	private int dato;
	private Nodo LF;

	public Nodo(int f, int c, int d) {
		fila = f;
		columna = c;
		dato = d;
		LF = this;
	}
	
	public void AsignarFila(int f) {
		fila = f;
	}
	
	public int ObtenerFila() {
		return fila;
	}
	
	public void AsignarColumna(int c) {
		columna = c;
	}
	
	public int ObtenerColumna() {
		return columna;
	}
	
	public void AsignarDato(int d) {
		dato = d;
	}
	
	public int ObtenerDato() {
		return dato;
	}
	
	public void AsignarLF(Nodo nodoAlFrente) {
		LF = nodoAlFrente;
	}
	
	public Nodo ObtenerLF() {
		return LF;
	}
}
