package structure;

import java.util.ArrayList;

public class Asociacion{
    private String palabra;
    private ArrayList<String> traducciones;

    public Asociacion() {
        this.palabra = "";
        this.traducciones = new ArrayList<String>();
    }

    public Asociacion(String palabra, ArrayList<String> traducciones) {
        this.palabra = palabra;
        this.traducciones = traducciones;
    }

    public String getPalabra() {
        return this.palabra;
    }

    public void setPalabra(String palabra) {
        this.palabra = palabra;
    }

    public ArrayList<String> getTraducciones() {
        return this.traducciones;
    }

    public void setTraducciones(ArrayList<String> traducciones) {
        this.traducciones = traducciones;
    }

    public Asociacion palabra(String palabra) {
        setPalabra(palabra);
        return this;
    }

    public Asociacion traducciones(ArrayList<String> traducciones) {
        setTraducciones(traducciones);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Asociacion)) {
            return false;
        }
        Asociacion asociacion = (Asociacion) o;
        return Objects.equals(palabra, asociacion.palabra) && Objects.equals(traducciones, asociacion.traducciones);
    }

    @Override
    public int hashCode() {
        return Objects.hash(palabra, traducciones);
    }

    @Override
    public String toString() {
        return "{" +
            " palabra='" + getPalabra() + "'" +
            ", traducciones='" + getTraducciones() + "'" +
            "}";
    }

}