/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package polinomios;

import java.util.Scanner;

/**
 *
 * @author JMORANTES
 */
public class Polinomios {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in); 
        Negocio negocio = new Negocio();
        int opcion = 0; 
        
        System.out.println("** BIENVENIDO A lA APLICACION DE POLINOMIOS **");
        do {
            System.out.println(" INGRESE UNA DE LAS SIGUIENTE OPCIONES ");
            System.out.println(" 1) INGRESAR POLINOMIO ");
            System.out.println(" 2) AGREGAR POLINOMIO A VECTOR");
            System.out.println(" 3) SALIR ");
            
            opcion =  scanner.nextInt();
            
            switch(opcion){
                case 1 : 
                    System.out.println("** INGRESE UN POLINOMIO **");
                    String polinomio = scanner.next();
                    negocio.AgregarPolinomio(polinomio);
                    break;
                case 2:
                    break;
                case 3:
                    break;
            }
            
        } while (opcion != 0);
        
        
        
    }
    
}
