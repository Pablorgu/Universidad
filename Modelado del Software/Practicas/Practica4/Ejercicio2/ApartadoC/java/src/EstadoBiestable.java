public class EstadoBiestable implements EstadoDispositivo{
    @Override
    public void abrirDispositivo(Dispositivo dispositivo, Estado estado) {
        if( estado instanceof Verde){
            System.err.println("No se puede abrir desde verde");
        }else {
            dispositivo.setEstado(new Verde());
        }
    }

    @Override
    public void cerrarDispositivo(Dispositivo dispositivo, Estado estado) {
        if( estado instanceof Rojo) {
            System.err.println("No se puede cerrar desde Rojo");
        }else {
            dispositivo.setEstado(new Rojo());
        }
    }

    @Override
    public void cambioDispositivo(Dispositivo dispositivo, Estado estado) {
        dispositivo.getMediador().setEstadoDispositivo(new EstadoTriestable());
    }
}
