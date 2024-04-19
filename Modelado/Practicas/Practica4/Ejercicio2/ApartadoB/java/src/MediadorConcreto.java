public class MediadorConcreto implements Mediador{
    private EstadoDispositivo estadoDispositivo;
    public MediadorConcreto(EstadoDispositivo estadoDispositivo) {
        this.estadoDispositivo = estadoDispositivo;
    }

    @Override
    public void abrirDispositivo(Dispositivo dispositivo, Estado estado) {
        estadoDispositivo.abrirDispositivo(dispositivo,estado);
    }

    @Override
    public void cerrarDispositivo(Dispositivo dispositivo, Estado estado) {
        estadoDispositivo.cerrarDispositivo(dispositivo,estado);
    }
}
