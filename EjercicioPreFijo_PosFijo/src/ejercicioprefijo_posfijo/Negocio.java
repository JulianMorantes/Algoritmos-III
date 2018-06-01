
package ejercicioprefijo_posfijo;
/**
 * clase que contiene toda la logica de negocio en metodos segun accion a realizar 
 * @author JMORANTES
 */
public class Negocio {
     
    Modelo variables = new Modelo();
    
    public boolean ExisteInfijo(){
        return (variables.getInfijo().isEmpty()) ? false : true;
    }
    
    public void RegistrarInfijo(String infijo){
        if(!infijo.isEmpty()){
            variables.setInfijo(infijo);
            System.out.println("\033[32;1;2m** INFIJO REGISTRADO CON EXITO. **");
        }else{
            System.out.println("\033[31;1m** INFIJO INGRESADO NO VALIDO. **");
        }    
    };
        
    public void ConvertirAPosfijo(){
        if(ExisteInfijo()){
            String infijo = variables.getInfijo();
            String postfija= "";
            PilaE pila= new PilaE(30);
           
            for (int i=0; i < infijo.length(); i++){
                char letra= infijo.charAt(i);
                if (EsOperador(letra)){
                    if (letra == ')'){
                        while(pila.getTope()!= '(')
                            postfija += pila.pop();
                        if(pila.getTope()== '(')
                            pila.pop();
                    }
                    
                    if (pila.vacia()){
                        if (letra!= ')')
                            pila.push(letra);
                    } else{
                        if (letra!= ')'){
                            int pe= PrioridadExp(letra);
                            int pp= PrioridadPila((char)pila.getTope());
                            if (pe > pp){
                                pila.push(letra);
                            } else {
                                postfija += pila.pop();
                                pila.push(letra);
                            }
                        }
                    }
                }else
                    postfija += letra;

            }
            while (!pila.vacia()){
                postfija += pila.pop();
            }
            System.out.println("\033[32;1;2m** El INFIJO ES :" + infijo +" **");
            System.out.println("\033[32;1;2m** El POSFIJO ES :" + postfija +" **");
        }else{
            System.out.println("\033[31;1m** NO SE A AGREGADO UN INFIJO **");
        }
    }
    
    public void ConvertirAPreFijo(){
        if(ExisteInfijo()){           
            //Declaracion de variables.
            String Prefijo = "" , infijo = variables.getInfijo(); 
            int i = (infijo.length() - 1);
            char caracter; 
            PilaE pilaPre= new PilaE(30);
            
            while( i >= 0){
                caracter = infijo.charAt(i);
                if(EsOperador(caracter)){
                    if(caracter == '('){
                          while(pilaPre.getTope()!= ')')
                            Prefijo = pilaPre.pop() + Prefijo ;
                          if(pilaPre.getTope()== ')')
                            pilaPre.pop();
                    }
                    
                    if(pilaPre.vacia()){
                        if (caracter != '(')
                            pilaPre.push(caracter);
                    }else{
                        if (caracter!= '('){
                            int pe= PrioridadExp(caracter);
                            int pp= PrioridadPila((char)pilaPre.getTope());
                            if (pe > pp){
                                pilaPre.push(caracter);
                            } else {
                                Prefijo = (pilaPre.pop() + Prefijo);
                                pilaPre.push(caracter);
                            }
                        }
                    }    
                }else{
                    Prefijo = caracter + Prefijo;
                }; 
                i--;
            };
            while (!pilaPre.vacia()){
                Prefijo = (pilaPre.pop() + Prefijo);
            }
            System.out.println("\033[32;1;2m** El INFIJO ES :" + infijo +" **");
            System.out.println("\033[32;1;2m** El PREFIJO ES :" + Prefijo +" **");
            
        }else{
           System.out.println("\033[31;1m** NO SE A AGREGADO UN INFIJO **");
        }
    }
    
    public void EvaluarExprecion(String exprecion){
        if(exprecion.length() >=3){               
            if(EsOperador(exprecion.charAt(exprecion.length()-1))){
                EvaluarExprecionPosfija(exprecion);
            }else{
                EvaluarExprecionPrefija(exprecion);
            }
        }else{
           System.out.println("\033[31;1m** LA EXPRECION INGRESADA NO ES VALIDA **");
        }
    }
    
    public void EvaluarExprecionPosfija(String exprecion){
        System.out.println("** TRABAJANDO EN FUNCIONALIDAD, LOADING ..... **");
    }
    
    public void EvaluarExprecionPrefija(String exprecion){
         String Res = "";
            int i = exprecion.length() - 1;
            PilaE pila_num = new PilaE(2);
            PilaE pila_op = new PilaE(2);
            while(i >= 0){
                char caracter = exprecion.charAt(i); 
                if(EsOperador(caracter)){
                    pila_op.push(caracter);
                    if(!pila_op.vacia() &&  !pila_num.vacia()){
                       int num1 = pila_num.pop() - '0'; 
                       int num2 = (Res != "") ? Integer.parseInt(Res) : pila_num.pop() - '0';
                       int resultado = RealizarOperacion(pila_op.pop(), num1, num2);
                       Res = ""+resultado;
                       System.out.println("Resultado" + Res);
                   }
                }else{
                   pila_num.push(caracter);
                }
                i--;
            }
            System.out.println("\033[32;1;2m** EXPRECION INFIJA :" + exprecion +" **");
            System.out.println("\033[32;1;2m** EL RESULTADO ES :" + Res +" **");
    }
    
    public void ConvertirDePosAPreFijo(){
        System.out.println("** TRABAJANDO EN FUNCIONALIDAD, LOADING ..... **");
        
        if(ExisteInfijo()){
            
        }else{
           System.out.println("\033[31;1m** NO SE A AGREGADO UN INFIJO **");
        }
    }
    
    public void ConvertirDePreAPosFijo(){
        System.out.println("** TRABAJANDO EN FUNCIONALIDAD, LOADING ..... **");        
        if(ExisteInfijo()){
        
        }else{
           System.out.println("\033[31;1m** NO SE A AGREGADO UN INFIJO **");
        }
    }
    
    public static int PrioridadExp(char x){
        if (x == '^') return 4;
        if (x == '*' || x == '/') return 2;
        if (x == '+' || x == '-') return 1;
        if (x == '(') return 5;
        if (x== ')') return 5;
        return 0;
    }

    public static int PrioridadPila(char x){
        if (x == '^') return 3;
        if (x == '*' || x == '/') return 2;
        if (x == '+' || x == '-') return 1;
        if (x == '(') return 0;
        if (x== ')') return 0;
        return 0;
    }

    public static boolean EsOperador(char letra){
        if (letra == '*' || letra == '/' || letra == '+' || letra == '-' || letra == '^' || letra == '(' || letra == ')'){
            return true;
        }
        else
            return false;
    }
    
    public static int RealizarOperacion(char caracter, int num1, int num2){
        int resultado = 0; 
        switch(caracter){
            case '+':
                resultado = (num1 + num2);
                break;
            case '-':
                resultado = (num1 - num2);
                break;
            case '*':
                resultado = (num1 * num2);
                break;
            case '/':
                resultado = (num1 / num2);
                break;
            default : 
                break;
        }
        return resultado;
    }
}
