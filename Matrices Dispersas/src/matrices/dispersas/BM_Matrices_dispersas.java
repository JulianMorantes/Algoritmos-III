/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matrices.dispersas;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;




/**
 * @author JMORANTES
 * BM es el manegador de la logiaca de las matrises dispersas
 */
public class BM_Matrices_dispersas {
    
    int[] vector;
    int matriz [][]; 
    int alto;
    int ancho;
    Scanner Leer = new Scanner(System.in); //Variable que nos permite Capturar los datos de la consola 
    int Promedio = 0;
    
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
    
    public  void ConvertirMatrizAForma2(){
        Lista lista = new Lista();
        
        for(int i=0; i<matriz.length;i++){
            for(int j=0; j<matriz[i].length;j++){
                if(matriz[i][j]!=0){
                    lista.AgregarALista(matriz[i][j], i, j);
                }
            }
        }
        lista.MostrarLista();
    
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
      
        List<int[]>  tripleta = new ArrayList<>(); //Lista de Vector Con Elementos de Tripleta.
        int[][] diagonal = new int [alto][ancho]; // Matriz que solo mostrata los datos de la diagonal.
        int k = 1; //
        
        //Recorrido de Matriz
        for(int i=0; i < matriz.length ; i++){          
            for(int j=0; j < matriz[i].length; j++ ){        
                if(matriz[i][j] != 0){
                    tripleta.add( new int[]{
                        i, j , matriz[i][j]
                    });
                }
                
                //Valida la diagonal principalde la matriz
                if(i == j){
                    diagonal[i][j] = matriz[i][j]; 
                }
            }
        }         
        
        //Metodo que permite convertir la lista vector a Matriz.
        int[][] Tri = ConvertirListaVectorAMatriz(tripleta);
        ImprimirMatiz(Tri);
     
        System.out.println("La DiaGonal principal de la matriz es:");
        ImprimirMatiz(diagonal); 
        
    }
    
    public void inprimirMatrizIngresada(){
        ImprimirMatiz(matriz);
    }
    
    public void ImprimirMatiz(int matriz [][]){      
        for(int i=0; i < matriz.length ; i++){          
            for(int j=0; j < matriz[i].length; j++ ){
                System.out.print("|" + matriz[i][j] + "|");
            }
             System.out.println(" ");
        }
    }
    
    public int[][] ConvertirListaVectorAMatriz(List<int[]> tripleta){
        int[][] Tri =  new int [tripleta.size() + 1][3]; //Genera una matriz dinamica con la cantidad de datos de la tipleta;
        Tri[0][0] = alto; 
        Tri[0][1] = ancho;
        Tri[0][2] = tripleta.size();
        
        //recorre la lista vector y lo agrega a una matriz tripleta.
        for(int p = 0 ; p < tripleta.size(); p ++){    
            Tri[p + 1][0] = tripleta.get(p)[0]; 
            Tri[p + 1][1] = tripleta.get(p)[1];
            Tri[p + 1][2] = tripleta.get(p)[2]; 
        }      
        return Tri;
    }
    
    public void VerDiagonalPrincipalMatriz(){
        int[][] diagonal = new int [alto][ancho];
        
        for(int i=0; i<matriz.length;i++){
            for(int j=0; j<matriz[i].length;j++){
                if(matriz[i] == matriz[j]){
                    diagonal[i][j] =   matriz[i][j];
                }
            }
        }
        System.out.println("La DiaGonal principal de la matriz es:");
        ImprimirMatiz(diagonal);    
    }
    
    public void VerDiagonalSecundariaMatriz(){
        int[][] diagonal = new int [alto][ancho];
        
        for(int i=0; i<matriz.length;i++){
            for(int j=0; j<matriz[i].length;j++){
                if(matriz[i] == matriz[j]){
                    diagonal[i][j] =   matriz[i][j];
                }
            }
        }
        
        System.out.println("La DiaGonal principal de la matriz es:");
        ImprimirMatiz(diagonal);    
    } 
    
    public int PromediarDatosDeLaMatriz(int dato){
        return 0;  
    }
    
    public void InicializarVector(){
        vector = new int[5]; 
        for(int i = 0; i < vector.length ; i++){
            vector[i] = (int) (Math.random()*10);
        }
    }
    
    public void MultiplicarMatrizPorVector(int dato){
        int resultado = 0; 
        for(int i = 0; i < vector.length; i++){
            
        } 
    }
}
