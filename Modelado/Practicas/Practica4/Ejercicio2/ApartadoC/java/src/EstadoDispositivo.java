public interface EstadoDispositivo {
    void abrirDispositivo(Dispositivo dispositivo, Estado estado);
    void cerrarDispositivo(Dispositivo dispositivo, Estado estado);
    void cambioDispositivo(Dispositivo dispositivo, Estado estado);
}
