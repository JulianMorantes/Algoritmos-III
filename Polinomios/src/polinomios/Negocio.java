/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package polinomios;

/**
 *
 * @author JMORANTES
 */
public class Negocio {
    
    private int i = 0; 
    
        
    public void AgregarPolinomio(String polinomio){
        String _Polinomio= ""; 
        i = 1;
        _Polinomio = polinomio.replace("x","");
        int Grado = VerificarMayourExponente(_Polinomio);
        int _DatosUtiles = Grado +2;
        int[] vector = new int[_DatosUtiles];
        vector[1] = Grado;
        
        int j = 0; 
        while( j  < _Polinomio.length()) {
            char caracter = _Polinomio.charAt(j);
            if((caracter == '^')){
               int exp = _Polinomio.charAt(j+1) - '0';
               if(Grado == exp){
                   int coefi = _Polinomio.charAt(j -1) -'0';
                   int posicion = (vector[1] + 2) - exp;
                   vector[posicion] = (vector[posicion] == 0)?  coefi : vector[posicion] + coefi;
               }else{
                   Grado --;
               }
            }
            j++;
        }
        

        
         
    }
    
    public void InsertarPolinomioAVector(){
    
    }
    
    
    
    public void ordenarPolinomio(String polinomio){
       
    };
    
    public boolean validarSiEsCaracter(char caracter){
        switch (caracter) {
            case '+':
                return true;
            case '-':
                return true;  
            case '*':
                return true;
            case '/':
                return true;     
            case '^':
                return true;    
            default:
                return false;
        }
    } 
    
    
    public int VerificarMayourExponente(String polinomio){       
        int _Max_expo = 0;
        i = 0;
        while( i < polinomio.length()){
            char caracter = polinomio.charAt(i); 
            if(caracter == '^'){
                int exp = polinomio.charAt(i+1) - '0';
                _Max_expo = (_Max_expo < exp) ? exp : _Max_expo; 
            }
            i++;
        } 
        return _Max_expo;
    }
}
