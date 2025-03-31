public class EstadoTriestable implements EstadoDispositivo{
    @Override
    public void abrirDispositivo(Dispositivo dispositivo, Estado estado) {
        if( estado instanceof Verde){
            System.err.println("No se puede abrir desde verde");
        }else{
            if(estado instanceof Rojo){
                dispositivo.setEstado(new Amarillo());
            }else{
                dispositivo.setEstado(new Verde());
            }
        }
    }

    @Override
    public void cerrarDispositivo(Dispositivo dispositivo, Estado estado) {
        if( estado instanceof Rojo) {
            System.err.println("No se puede cerrar desde Rojo");
        }else{
            if(estado instanceof Verde){
                dispositivo.setEstado(new Amarillo());
            }else{
                dispositivo.setEstado(new Rojo());
            }
        }

    }
}
