package Java;

public class Verde implements Estado{
    private final String estado;

    public Verde() {
        this.estado = "Verde";
    }
    public void abrir(Biestable biestable){
        System.out.println("Ya esta abierto");
    }
    public void cerrar(Biestable biestable){
        biestable.estado = new Rojo();
    }
    @Override
    public String toString() {
        return estado;
    }
}
