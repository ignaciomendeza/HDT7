package structure;

import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;

public class DiccionarioTest {
    Diccionario diccionario = new Diccionario();

    @Test
    void insertar(){
        BinarySearchTree<String, Asociacion> english;
        BinarySearchTree<String, Asociacion> spanish;
        BinarySearchTree<String, Asociacion> french;

        Comparador keyComparator;
        IGetKey<String, Asociacion> keyGenerator;
    

        keyComparator = new Comparador();
        english = new BinarySearchTree<String, Asociacion> (keyComparator, keyGenerator);
        spanish = new BinarySearchTree<String, Asociacion> (keyComparator, keyGenerator);
        french = new BinarySearchTree<String, Asociacion> (keyComparator, keyGenerator);

        String palabra = "house";
        ArrayList<String> traducciones = new ArrayList<String>();
        traducciones.add("casa");
        traducciones.add("loger");

        Asociacion aso1 = new Asociacion(palabra, traducciones );
        english.insert(palabra, aso1);

        Asociacion prueba = english.search(palabra);
        boolean prueba2 = false;

        if (prueba != null){
            prueba2 = true;
        }

        assertEquals(true, prueba2);
    }
}