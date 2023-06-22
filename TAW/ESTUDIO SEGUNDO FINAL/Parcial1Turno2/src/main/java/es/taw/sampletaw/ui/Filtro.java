package es.taw.sampletaw.ui;

import es.taw.sampletaw.dao.TipoComisionRepository;
import es.taw.sampletaw.entity.TipocomisionEntity;

public class Filtro {

    TipocomisionEntity comision;

    String cantidad;

    public Filtro() {
        comision = null;
        cantidad = "";
    }

    public TipocomisionEntity getComision() {
        return comision;
    }

    public void setComision(TipocomisionEntity comision) {
        this.comision = comision;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }
}
