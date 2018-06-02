/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matrices.dispersas;
import java.util.Scanner;

/**
 *
 * @author JMORANTES
 */
public class MatricesDispersas {
    
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       inicializadorDeAplicacion();
    }
    
    public static void inicializadorDeAplicacion(){        
        
        BM_Matrices_dispersas logica = new BM_Matrices_dispersas();
        Scanner Leer = new Scanner(System.in); //Variable que nos permite Capturar los datos de la consola 
           
        System.out.println("BIENVENIDO A EL MANEJO DE MATRICES DISPERSAS");
        int Option;
        
        do {
             
            logica.MostrarMenuAplicacion();
            Option = Leer.nextInt();    
            
            switch (Option) {
                case 1:
                    logica.AsignarMatriz();
                    break;
                case 2:
                    logica.AgregarDatoAMatriz();
                    break;
                case 3: 
                    logica.inprimirMatrizIngresada();
                    break;
                case 4: 
                    logica.convertirMatrizATripletas();
                    break;
                case 5: 
                    break;
                case 6:
                    break;
                    
                default:
                    throw new AssertionError();
            }
            
        } while (Option != 0);
                     
    }
}
