
package ejercicioprefijo_posfijo;
import java.util.Scanner;

/**
 * clase principal con metodo main que me permite inicializar la aplicacion 
 * @author JMORANTES
 */
public class Principal {     
    public static void main(String[] args){
        int opcion = 0; 
        Scanner scaner = new Scanner(System.in);
        Negocio logica = new Negocio();

        do {               
            System.out.println("************** BIENVENIDO *****************");
            System.out.println("** INGRESE LA OPCION A REALIZAR **");            
            System.out.println("1) AGREGAR INFIJO");
            System.out.println("2) CONVERTIR INFIJO A POSFIJO");
            System.out.println("3) CONVERTIR INFIJO A PREFIJO");
            System.out.println("4) EVALUAR PREFIJO O POSFIJO");
            System.out.println("5) CONVERTIR DE PREFIJO A POSFIJO");
            System.out.println("6) CONVERTIR DE POSFIJO A PREFIJO");
            System.out.println("7) SALIR");  
            
            opcion = scaner.nextByte(); 
            
            switch(opcion){
                case 1:
                    System.out.println("** POR FAVOR INGRESE EL INFIJO **");    
                    logica.RegistrarInfijo(scaner.next());
                    break;
                case 2:
                    logica.ConvertirAPosfijo();
                    break; 
                case 3:
                    logica.ConvertirAPreFijo();
                    break;
                case 4:
                    System.out.println("** INGRESE UNA EXPRECION POSFIJO O PREFIJO A EVALUAR **");
                    logica.EvaluarExprecion(scaner.next());
                    break;
                case 5:
                    logica.ConvertirDePreAPosFijo();
                    break;    
                case 6:
                    logica.ConvertirDePosAPreFijo();
                    break;    
                case 7:
                    opcion = 0;
                    break;
            }
            
        } while (opcion != 0);      
    }
}
