/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio1jm;

import java.util.Scanner;

/**
 *
 * @author sala208
 */
public class Ejercicio1JM {     
    
    
    public static void main(String[] args) {
        int j = 0;
        int x = 0;
        Scanner leer = new Scanner(System.in);
        System.out.println("Bienvenido a la aplicacion de matrizis");
        System.out.println("Ingrese el numero de posicion en J ");
        j = leer.nextInt(); 
        System.out.println("Ingrese el numero de posicion en X ");
        x = leer.nextInt();
        
        if(j > 0 && x > 0){
         incializarMatrizCaracol(x,j);
        }
    }
    
    public static void incializarMatrizCaracol(int x, int j){
        int cont=0, Pi=0, Pf=0, Pj=0, Fj= 0;    
        int[][] matrix = new int[x][j];
        //continuar  el codigo de la matriz en caracol        
    } 
         
}
    
 
