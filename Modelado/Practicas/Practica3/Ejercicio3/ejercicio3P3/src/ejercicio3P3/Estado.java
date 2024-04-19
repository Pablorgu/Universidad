package ejercicio3P3;

public abstract class Estado {
    protected Bandeja bandeja;
    public Estado(Bandeja bandeja) {
        assert (bandeja != null);
        this.bandeja = bandeja;
    }

    public abstract void put(Pieza p);
    public abstract Pieza get();
    public int size(){
        return bandeja.size();
    }
}
