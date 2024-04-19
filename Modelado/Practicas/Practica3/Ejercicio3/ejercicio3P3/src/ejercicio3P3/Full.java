package ejercicio3P3;

public class Full extends Estado{
    public Full(Bandeja bandeja) {
        super(bandeja);
    }

    @Override
    public void put(Pieza p) {
        assert p!=null;
        assert size() < bandeja.getCapacidad();
    }

    @Override
    public Pieza get() {
        if(bandeja.getCapacidad()>1){
            bandeja.setEstado(new Normal(bandeja));
        }else{
            bandeja.setEstado(new Empty(bandeja));
        }

        Pieza p = bandeja.piezas.remove(0);
        p.setBandeja(null);
        return p;
    }
}
