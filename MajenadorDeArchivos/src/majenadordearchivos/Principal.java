/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package majenadordearchivos;

import java.util.Scanner;

/**
 *
 * @author JMORANTES
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String nombreArchivo = null;
        
        ManejadorDeArchivo negocio = new ManejadorDeArchivo();
        
        byte opt=0;//variable que permitira controlar el menu
        do{
            System.out.println("** BIENVENIDO AL MANEJADOR DE ARCHIVOS SECUENCIALES **");
            System.out.println("** POR FAVOR ELIGA UNA DE LAS SIGUIENTES OPCIONES **");
            
            System.out.println("1)VERIFICAR UN ARCHIVO (VER SI EXISTE UN ARCHIVO)");
            System.out.println("2)CREAR UN ARCHIVO");
            System.out.println("3)INSERTAR DATOS A UN ARCHIVO");
            System.out.println("4)CONSULTA DE ARCHIVO");
            System.out.println("5)CONSULTA INDIVIDUAL");
            System.out.println("6)SALIR");

            opt=scanner.nextByte();
            
            switch(opt){
                case 1:
                    System.out.print("** INDIQUE EL NOMBRE DEL ARCHIVO Y  SU ESTENCION A BUSCAR:");
                    nombreArchivo = scanner.next();
                    if(negocio.verificarExistencia(nombreArchivo) == true)
                        System.out.print("** EL ARCHIVO YA EXISTE **");
                    else
                        System.out.print("** EL ARCHIVO NO EXISTE **");
                    break;
                case 2:
                    System.out.print("Indique el nombre del archivo con su extenciaon a crear: ");
                    nombreArchivo = scanner.next();
                    if(negocio.crearArchivo(nombreArchivo) == true)
                        System.out.print("\n El archivo ha sido creado satisfactoriamente");
                    break;
                case 3:
                    System.out.print("Indique el nombre del archivo con su extenciaon en el que insertara datos: ");
                    nombreArchivo = scanner.next();
                    if(negocio.solicitudDatos(nombreArchivo) == true)
                        System.out.print("Los datos han sido insertados satisfactoriamente");
                    break;
                case 4:
                    System.out.print("Indique el nombre del archivo con su extenciaon a visualizar: ");
                    nombreArchivo = scanner.next();
                    negocio.leerDelArchivo(nombreArchivo);
                    break;
                case 5:
                    int clave = 0;
                    System.out.print("Indique el nombre del archivo con su extenciaon a visualizar: ");
                    nombreArchivo=scanner.next();
                    System.out.print("Indique la clave a buscar: ");
                    clave = scanner.nextInt();
                    negocio.consultaIndividual(nombreArchivo,clave);
                    break;
            }
        }while(opt!=6);
    }
    
}
