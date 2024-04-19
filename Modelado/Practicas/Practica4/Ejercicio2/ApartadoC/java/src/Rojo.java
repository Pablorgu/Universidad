public class Rojo implements Estado{
    private final String estado;

    public Rojo() {
        this.estado = "Rojo";
    }

    public void abrir(Dispositivo dispositivo){
        dispositivo.getMediador().abrirDispositivo(dispositivo,this);
    }
    public void cerrar(Dispositivo dispositivo){
        dispositivo.getMediador().cerrarDispositivo(dispositivo,this);
    }

    @Override
    public String toString() {
        return estado;
    }
}
