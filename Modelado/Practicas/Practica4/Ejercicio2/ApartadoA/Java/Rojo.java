package Java;

public class Rojo implements Estado{
    private final String estado;

    public Rojo() {
        this.estado = "Rojo";
    }
    public void abrir(Biestable biestable){
        biestable.estado = new Verde();
    }
    public void cerrar(Biestable biestable){
        System.out.println("Ya esta cerrado");
    }
    @Override
    public String toString() {
        return estado;
    }
}
