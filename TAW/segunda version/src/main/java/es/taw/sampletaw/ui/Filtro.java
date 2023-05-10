package es.taw.sampletaw.ui;

import java.util.List;

public class Filtro {

    private String texto;

    private List<String> zipSupermercados;

    public Filtro() {
        texto = "";
        zipSupermercados = null;
    }

    public List<String> getZipSupermercados() {return zipSupermercados;}

    public void setZipSupermercados(List<String> zipSupermercados) {this.zipSupermercados = zipSupermercados; }

    public String getTexto() {return texto;}

    public void setTexto(String texto) {this.texto = texto;}
}
