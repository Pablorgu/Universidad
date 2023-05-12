package es.taw.sampletaw.ui;

import es.taw.sampletaw.entity.MicroMarket;

import java.util.List;

public class Filtro {

    private String texto;
    private List<String> zipSupermercados;

    public Filtro() {
        texto = "";
        zipSupermercados = null;
    }

    public List<String> getZipSupermercados() {
        return zipSupermercados;
    }

    public void setZipSupermercados(List<String> zipSupermercados) {
        this.zipSupermercados = zipSupermercados;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }
}
