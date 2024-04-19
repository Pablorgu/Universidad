package ejercicio3P3;

public class Empty extends Estado{
    public Empty(Bandeja bandeja) {
        super(bandeja);
    }

    @Override
    public void put(Pieza p) {
        assert (p != null);

        if(bandeja.getCapacidad()>1){
            bandeja.setEstado(new Normal(bandeja));
        }else{
            bandeja.setEstado(new Full(bandeja));
        }
        bandeja.piezas.add(p);
        p.setBandeja(bandeja);

    }

    @Override
    public Pieza get() {
        assert size() > 0;
        return null;
    }
}
