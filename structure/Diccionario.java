package structure;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Objects;

public class Diccionario{
    private BinarySearchTree<String, Asociacion> english;
    private BinarySearchTree<String, Asociacion> spanish;
    private BinarySearchTree<String, Asociacion> french;
    private ArrayList<String> ingles;
    private ArrayList<String> esp;
    private ArrayList<String> frances;
    private Comparador keyComparator;
	private IGetKey<String, Asociacion> keyGenerator;
    private Ordenador<String, Asociacion> ordenador;


    public Diccionario() {
        this.keyComparator = new Comparador();
        this.english = new BinarySearchTree<String, Asociacion> (keyComparator, keyGenerator);
        this.spanish = new BinarySearchTree<String, Asociacion> (keyComparator, keyGenerator);
        this.french = new BinarySearchTree<String, Asociacion> (keyComparator, keyGenerator);
        this.ingles = new ArrayList<String>();
        this.esp = new ArrayList<String>();
        this.frances = new ArrayList<String>();
        this.ordenador = new Ordenador<String, Asociacion>();
    }

    public Diccionario(BinarySearchTree<String, Asociacion> english, BinarySearchTree<String, Asociacion> spanish, BinarySearchTree<String, Asociacion> french, ArrayList<String> ingles, ArrayList<String> esp, ArrayList<String> frances) {
        this.english = english;
        this.spanish = spanish;
        this.french = french;
        this.ingles = ingles;
        this.esp = esp;
        this.frances = frances;
    }


    public BinarySearchTree<String,Asociacion> getEnglish() {
        return this.english;
    }

    public void setEnglish(BinarySearchTree<String,Asociacion> english) {
        this.english = english;
    }

    public BinarySearchTree<String,Asociacion> getSpanish() {
        return this.spanish;
    }

    public void setSpanish(BinarySearchTree<String,Asociacion> spanish) {
        this.spanish = spanish;
    }

    public BinarySearchTree<String,Asociacion> getFrench() {
        return this.french;
    }

    public void setFrench(BinarySearchTree<String,Asociacion> french) {
        this.french = french;
    }

    public ArrayList<String> getIngles() {
        return this.ingles;
    }

    public void setIngles(ArrayList<String> ingles) {
        this.ingles = ingles;
    }

    public ArrayList<String> getEsp() {
        return this.esp;
    }

    public void setEsp(ArrayList<String> esp) {
        this.esp = esp;
    }

    public ArrayList<String> getFrances() {
        return this.frances;
    }

    public void setFrances(ArrayList<String> frances) {
        this.frances = frances;
    }

    public IGetKey<String,Asociacion> getKeyGenerator() {
        return this.keyGenerator;
    }

    public void setKeyGenerator(IGetKey<String,Asociacion> keyGenerator) {
        this.keyGenerator = keyGenerator;
    }

    public Diccionario english(BinarySearchTree<String,Asociacion> english) {
        setEnglish(english);
        return this;
    }

    public Diccionario spanish(BinarySearchTree<String,Asociacion> spanish) {
        setSpanish(spanish);
        return this;
    }

    public Diccionario french(BinarySearchTree<String,Asociacion> french) {
        setFrench(french);
        return this;
    }

    public Diccionario ingles(ArrayList<String> ingles) {
        setIngles(ingles);
        return this;
    }

    public Diccionario esp(ArrayList<String> esp) {
        setEsp(esp);
        return this;
    }

    public Diccionario frances(ArrayList<String> frances) {
        setFrances(frances);
        return this;
    }

    public Diccionario keyGenerator(IGetKey<String,Asociacion> keyGenerator) {
        setKeyGenerator(keyGenerator);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Diccionario)) {
            return false;
        }
        Diccionario diccionario = (Diccionario) o;
        return Objects.equals(english, diccionario.english) && Objects.equals(spanish, diccionario.spanish) && Objects.equals(french, diccionario.french) && Objects.equals(ingles, diccionario.ingles) && Objects.equals(esp, diccionario.esp) && Objects.equals(frances, diccionario.frances) && Objects.equals(keyComparator, diccionario.keyComparator) && Objects.equals(keyGenerator, diccionario.keyGenerator);
    }

    @Override
    public int hashCode() {
        return Objects.hash(english, spanish, french, ingles, esp, frances, keyComparator, keyGenerator);
    }

    public void guardarDatos(ArrayList<String> lineasDatos){
        ArrayList<String> unaLinea = new ArrayList<String>();
        ArrayList<String> idioma1 = new ArrayList<String>();
        ArrayList<String> idioma2 = new ArrayList<String>();
        ArrayList<String> idioma3 = new ArrayList<String>();


        for (String fila : lineasDatos) {
            String [] lineaSeparada = fila.split(",");
            unaLinea = new ArrayList<String>();
            idioma1 = new ArrayList<String>();
            idioma2 = new ArrayList<String>();
            idioma3 = new ArrayList<String>();
            for (String caracter : lineaSeparada) {
                unaLinea.add(caracter.trim());
                idioma1.add(caracter.trim());
                idioma2.add(caracter.trim());
                idioma3.add(caracter.trim());
            }

            ingles.add(unaLinea.get(0));
            esp.add(unaLinea.get(1));
            frances.add(unaLinea.get(2));

            idioma1.remove(0);
            idioma2.remove(1);
            idioma3.remove(2);

            Asociacion aso1 = new Asociacion(unaLinea.get(0), idioma1);
            Asociacion aso2 = new Asociacion(unaLinea.get(1), idioma2);
            Asociacion aso3 = new Asociacion(unaLinea.get(2), idioma3);
            
            english.insert(unaLinea.get(0), aso1);
            spanish.insert(unaLinea.get(1), aso2);
            french.insert(unaLinea.get(2), aso3);

        }
    }

    /*
     * 
     public ArrayList<String> ordenarDatos(int id){
         ArrayList<String> ordenado = new ArrayList<String>();
         switch(id){
             case 1 :
                 english.InOrderTraversal(ordenador); 
                 ordenado = ordenador.getMiListado();
 
         }
         return ordenado;
 
     }
     */

    public String traducir(ArrayList<String> lineasDatos2, int idioma){
        ArrayList<String> unaLinea2 = new ArrayList<String>();
        String resultado = "";
        int countIn = 0;
        int countEs = 0;
        int countFr = 0;
        int idioma2 = 0;

        for (String fila : lineasDatos2) {
            String [] lineaSeparada = fila.split(" ");
            unaLinea2 = new ArrayList<String>();
            for (String caracter : lineaSeparada) {
                unaLinea2.add(caracter.trim());
            }
        }

        String last2 = "";
        String last = unaLinea2.remove(unaLinea2.size() - 1);
        if (last.endsWith(".")){
            last2 = last.substring(0, last.length() - 1);
        }
        unaLinea2.add(last2);
        
        for (String pal : unaLinea2){
            String palabra = pal.toLowerCase();
            Asociacion in = english.search(palabra);
            Asociacion es = spanish.search(palabra);
            Asociacion fr = french.search(palabra);

            if (in != null){
                countIn++;
            }
            if (es != null){
                countEs++;
            }
            if (fr != null){
                countFr++;
            }
            
        }

        if (countIn > countEs & countIn > countFr){
            idioma2 = 1;
        }
        if (countEs > countIn & countEs > countFr){
            idioma2 = 2;
        }
        if (countFr > countEs & countFr > countIn){
            idioma2 = 3;
        }

        switch(idioma2){
            case 1:
                switch(idioma){
                    case 1:
                        for (String pal : unaLinea2){
                            String palabra = pal.toLowerCase();
                            Asociacion as = english.search(palabra);
                            if (as != null){
                                String traduccion = as.getPalabra();
                                resultado = resultado + traduccion + " ";
                            }
                            else{
                                resultado = resultado + "*" + palabra + "* ";
                            }
                        }
                    break;
                    case 2:
                        for (String pal : unaLinea2){
                            String palabra = pal.toLowerCase();
                            Asociacion as = english.search(palabra);
                            if (as != null){
                                String traduccion = as.getTraducciones().get(0);
                                resultado = resultado + traduccion + " ";
                            }
                            else{
                                resultado = resultado + "*" + palabra + "* ";
                            }
                        }
                    break;
                    case 3:
                        for (String pal : unaLinea2){
                            String palabra = pal.toLowerCase();
                            Asociacion as = english.search(palabra);
                            if (as != null){
                                String traduccion = as.getTraducciones().get(1);
                                resultado = resultado + traduccion + " ";
                            }
                            else{
                                resultado = resultado + "*" + palabra + "* ";
                            }
                        }
                    break;
                    default : {

                    }
                    break;

                }
                
                break;

            case 2:
                switch(idioma){
                    case 1:
                        for (String pal : unaLinea2){
                            String palabra = pal.toLowerCase();
                            Asociacion as = spanish.search(palabra);
                            if (as != null){
                                String traduccion = as.getTraducciones().get(0);
                                resultado = resultado + traduccion + " ";
                            }
                            else{
                                resultado = resultado + "*" + palabra + "* ";
                            }
                        }
                        break;

                    case 2:
                        for (String pal : unaLinea2){
                            String palabra = pal.toLowerCase();
                            Asociacion as = spanish.search(palabra);
                            if (as != null){
                                String traduccion = as.getPalabra();
                                resultado = resultado + traduccion + " ";
                            }
                            else{
                                resultado = resultado + "*" + palabra + "* ";
                            }
                        }
                        break;

                    case 3:
                        for (String pal : unaLinea2){
                            String palabra = pal.toLowerCase();
                            Asociacion as = spanish.search(palabra);
                            if (as != null){
                                String traduccion = as.getTraducciones().get(1);
                                resultado = resultado + traduccion + " ";
                            }
                            else{
                                resultado = resultado + "*" + palabra + "* ";
                            }
                        }
                        break;
 
                    default : {

                    }
                    break;

                }


                break;

            case 3:
                switch(idioma){
                    case 1:
                        for (String pal : unaLinea2){
                            String palabra = pal.toLowerCase();
                            Asociacion as = french.search(palabra);
                            if (as != null){
                                String traduccion = as.getTraducciones().get(0);
                                resultado = resultado + traduccion + " ";
                            }
                            else{
                                resultado = resultado + "*" + palabra + "* ";
                            }
                        }
                        break;

                    case 2:
                        for (String pal : unaLinea2){
                            String palabra = pal.toLowerCase();
                            Asociacion as = french.search(palabra);
                            if (as != null){
                                String traduccion = as.getTraducciones().get(1);
                                resultado = resultado + traduccion + " ";
                            }
                            else{
                                resultado = resultado + "*" + palabra + "* ";
                            }
                        }
                        break;

                    case 3:
                        for (String pal : unaLinea2){
                            String palabra = pal.toLowerCase();
                            Asociacion as = french.search(palabra);
                            if (as != null){
                                String traduccion = as.getPalabra();
                                resultado = resultado + traduccion + " ";

                            }
                            else{
                                resultado = resultado + "*" + palabra + "* ";
                            }
                        }
                        break;

                    default : {

                    }
                    break;

                }
                break;

        }
        return resultado;

    }

































    @Override
    public String toString() {
        return "{" +
            " english='" + getEnglish() + "'" +
            ", spanish='" + getSpanish() + "'" +
            ", french='" + getFrench() + "'" +
            ", ingles='" + getIngles() + "'" +
            ", esp='" + getEsp() + "'" +
            ", frances='" + getFrances() + "'" +
            ", keyGenerator='" + getKeyGenerator() + "'" +
            "}";
    }

   


}