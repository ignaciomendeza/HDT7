package structure;

/*
 * Ignacio Méndez (22613)
 * Algoritmos y Estructuras de Datos Sección 40
 * Hoja de Trabajo 4
 * 20-02-2023
 * Clase Principal: Interacción con el usuario
 */

import java.util.*;
import java.util.Scanner;


public class Principal {

    
    /** 
     * @param args
     */
    public static void main(String[] args){

        Scanner teclado = new Scanner (System.in);

        Archivo archivo = new Archivo("./diccionario.txt");
        ArrayList<String> lineasDatos = archivo.leerArchivo();
        Archivo archivo2 = new Archivo("./texto.txt");
        ArrayList<String> lineasDatos2 = archivo2.leerArchivo();
        Diccionario diccionario = new Diccionario();

        diccionario.guardarDatos(lineasDatos);

        int tipo = 0;
        boolean seguir = true;
        String menu = "--------------------TRADUCTOR DE PALABRAS--------------------\nIndique qué diccionario desea utilizar:\n1. Inglés\n2. Español\n3. Francés";
        System.out.println(menu);
        tipo = teclado.nextInt();
        teclado.nextLine();

        System.out.println(diccionario.traducir(lineasDatos2, tipo));





        







        
        
    }
}