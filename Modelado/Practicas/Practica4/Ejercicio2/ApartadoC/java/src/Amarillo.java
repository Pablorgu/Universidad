public class Amarillo implements Estado{
    private final String estado;

    public Amarillo() {
        this.estado = "Amarillo";
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
