/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matrices.dispersas;

import java.util.Scanner;




/**
 * @author JMORANTES
 * BM es el manegador de la logiaca de las matrises dispersas
 */
public class BM_Matrices_dispersas {
  
    int matriz [][]; 
    int alto;
    int ancho;
    Scanner Leer = new Scanner(System.in); //Variable que nos permite Capturar los datos de la consola 
    
    public void MostrarMenuAplicacion(){
        System.out.println("POR FAVOR SELECIONE UNA OPCION DE LA SIGUIENTE LISTAS");
        System.out.println(" 1) Agregar una Matriz");
        System.out.println(" 2) Agregar dato a Matriz");       
        System.out.println(" 3) Visualizar Matriz"); 
        
        System.out.println(" 4) Ver Matris en Tipletas"); 
        System.out.println(" 5) Ver Matris en listas ligadas forma Uno");
        System.out.println(" 6) Ver Matris en listas ligadas forma Dos ");    

        System.out.println(" 7) Mostrar los elementos de la diagonal principal y secundaria.");
        System.out.println(" 8) El promedio de la matriz");
        System.out.println(" 9) Ingresar un vector y multiplique por matriz.");
        
        System.out.println(" 10) Salir");
    }
    
    
    public void AsignarMatriz(){
        
       System.out.println("Agrege en alto de la matriz en numeros");
       alto = Leer.nextInt(); 
        
       System.out.println("Agreg el ancho de la matriz en numeros");
       ancho = Leer.nextInt();
       
       matriz = new int [alto][ancho]; 
       System.out.println("Matriz creada de " + alto + " X " + ancho); 
    }
    
    
    public void AgregarDatoAMatriz(){
        try {
            System.out.println("Agrege la fila en la que desea agregar el dato");
            int fila = Leer.nextInt(); 

            System.out.println("Agrege la columna en donde desea agregar el dato");
            int columna = Leer.nextInt(); 

            System.out.println("Agrege el dato que desea ingresar");
            int dato = Leer.nextInt(); 

            matriz[fila][columna] = dato;

            System.out.println("Dato agregado de forma correcta."); 
            
        } catch (Exception e) {
            System.out.println("Error al agregar el Dato por favor valide e intente nuveaente.");
            System.out.println("Error :" + e);
        }
       
    }
    
    
    public void convertirMatrizATripletas(){
        int Tripleta[][] = new int [40][3];
    }
    
    public void ImprimirMatiz(){
    
    }
}
