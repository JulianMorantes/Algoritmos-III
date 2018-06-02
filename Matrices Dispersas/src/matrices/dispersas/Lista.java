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
public class Lista {
        private Nodo punta;
	private int numFilas;
	private int numColumnas;
        
        public Lista() {
		punta = new Nodo(0, 0, 0);
		numColumnas = 0;
	}
        public void AgregarALista(int dato, int alto, int ancho){
                Nodo ant;
		Nodo p = punta.ObtenerLF();
		Nodo nuevoDato = new Nodo(alto,ancho, dato);
		
		if (p == punta) { // Si entra la lista está vacía
			nuevoDato.AsignarLF(punta);
			punta.AsignarLF(nuevoDato);
			
			numFilas = alto;
			numColumnas = ancho;
		}
		else {
			ant = punta;
			// Ciclo para avanzar en la fila
			while (p != punta) {
				if (p.ObtenerFila() >= alto) {
					break;
				}
				
				ant = p;
				p = p.ObtenerLF();
			}

			// Ciclo para avanzar en la columna
			while (p != punta && p.ObtenerFila() == alto) {
				if (p.ObtenerColumna() >= ancho) {
					break;
				}
			
				ant = p;
				p = p.ObtenerLF();
			}
			
			if (p.ObtenerFila() == alto && p.ObtenerColumna() == ancho) {
				// Cuando el nodo ya existe
				if (alto == 0) {
					// Se elimina el nodo existente de la lista
					ant.AsignarLF(p.ObtenerLF());
				}
				else {
					// Se actualiza el valor en el nodo existente
					p.AsignarDato(dato);
				}
			}
			else {
				// Cuando el nodo aún no existe
				// En éste punto ya tenemos el último nodo guardado en la variable 'ant'
				nuevoDato.AsignarLF(ant.ObtenerLF());
				ant.AsignarLF(nuevoDato);
				
				if (numFilas < alto) {
					numFilas = alto;
				}
				if (numColumnas < ancho) {
					numColumnas = ancho;
				}
			}
		}
        
        }
        public void MostrarLista() {
		Nodo p = punta.ObtenerLF();
		
		while (p != punta) {
			System.out.println("[" + p.ObtenerFila() + "," + p.ObtenerColumna() + "] = " + p.ObtenerDato());
			p = p.ObtenerLF();
		}
	}

}
