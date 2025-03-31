package es.taw.sampletaw.iu;

import es.taw.sampletaw.entity.TipocomisionEntity;

public class Filtro {
    private TipocomisionEntity tipocomision;
    private String cantidad;

    public Filtro() {
        tipocomision = null;
        cantidad= "";
    }

    public TipocomisionEntity getTipocomision() {
        return tipocomision;
    }

    public void setTipocomision(TipocomisionEntity tipocomision) {
        this.tipocomision = tipocomision;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }
}
