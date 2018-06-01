
package majenadordearchivos;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

/**
 * @author JMORANTES
 */
public class ManejadorDeArchivo {
    
    public static boolean verificarExistencia(String nombreArchivo){
        //Este metodo solo se encarga de verificar por un archivo; indica si existe o no.
        File archivo = new File(nombreArchivo);
        if(archivo.exists())
            return true;
        else
            return false;
    }
    
    public static boolean crearArchivo(String nombreArchivo){
        //Este metodo simplemente se encarga de crear un archivo
        try{
            File archivo = new File(nombreArchivo);
            archivo.createNewFile();
            return true;
        }
        catch(IOException crearArchivo){
            System.out.print("Ocurrio un error al crear el archivo\n");
            return false;
        }
    }

    public static boolean insertarDatos(String nombreArchivo, int clave,String nombre,byte edad, float estatura){
        try{
           //apertura de streams que permitiran la comunicaion de la aplicacion
           //con el sistema; indican que la aplicacion mandara datos a disco.
           // out y Dout son simplemente instancias; estos pueden ser nombrados
           //de cualquier forma
           FileOutputStream out= new FileOutputStream(nombreArchivo,true);
           DataOutputStream Dout= new DataOutputStream(out);
           //valores a incertar
           Dout.writeInt(clave);
           Dout.writeUTF(nombre);
           Dout.writeByte(edad);
           Dout.writeFloat(estatura);

           return true;
        }
        catch(IOException Entrada){
            System.out.print("\nOcurrio una falla al ingresar los datos al archivo\n");
            return false;
        }
    }
    
    public static void leerDelArchivo(String nombreArchivo){
        try{
           //apertura de streams que permitiran la comunicaion de la aplicacion
           //con el sistema; indican que la aplicacion extraera datos de disco.
           //in y Din son simplemente instancias; estos pueden ser nombrados
           //de cualquier forma
           
           FileInputStream in= new FileInputStream(nombreArchivo);
           DataInputStream Din=new DataInputStream(in);
           //la lectura se deve hacer de forma ordenada; con esto hago referencia
           //a que si el primer dato que se ingreso fue un entero, el primer dato
           //a leer sera un enterom, y asi de forma consecuente.
           //se puede asignar la lectura a una variable del tipo correspondiente
           //o bien se puede realizar la impresion de forma directa.
            try{
                do{
                    System.out.print("\n"+Din.readInt());
                    System.out.print("\n"+Din.readUTF());
                    System.out.print("\n"+Din.readByte());
                    System.out.print("\n"+Din.readFloat());
                }while(true);
            }
           catch(EOFException f){
           }
        }
        catch(IOException extraccion){
            System.out.print("\nOcurrio una falla al extraer los datos del archivo");
        }
    }
    
    public static void consultaIndividual(String nombreArchivo, int clave){
        int cve=0;
        String nombre=null;
        byte edad=0;
        float estatura=0.0f;
        try{
           FileInputStream in= new FileInputStream(nombreArchivo);
           DataInputStream Din=new DataInputStream(in);
           try{
                do{
                    cve=Din.readInt();
                    nombre=Din.readUTF();
                    edad=Din.readByte();
                    estatura=Din.readFloat();
                    if(cve==clave){
                        System.out.print("\nLa clave registrada es:    "+cve);
                        System.out.print("\nEl nombre registrado es:   "+nombre);
                        System.out.print("\nLa edad registrada es:      "+edad);
                        System.out.print("\nLa estatura registrada es:  "+estatura);
                    }
                }while(cve!=clave);
            }
           catch(EOFException f){
               System.out.print("La clave buscada no se encuenstra el el archivo\n");
           }
        }
        catch(IOException Entrada){
            System.out.print("\nOcurrio una faya al extraer los datos del archivo\n");
        }
    }
    
    public static boolean solicitudDatos(String nombreArchivo){
        Scanner sc = new Scanner(System.in);
        String nombre=null;
        int clave=0;
        byte edad=0;
        float estatura = 0.0f;
        System.out.print("\nIndique una clave: ");
        clave=sc.nextInt();
        System.out.print("\nIndique su nombre: ");
        sc.nextLine();//liumpiar buffer
        nombre=sc.nextLine();
        System.out.print("\nIndique su edad: ");
        edad=sc.nextByte();
        System.out.print("\nIndique su estatura: ");
        estatura=sc.nextFloat();
        if(insertarDatos(nombreArchivo, clave, nombre, edad, estatura)== true)
            return true;
        else
            return false;
    }
}
