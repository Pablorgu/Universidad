public interface Dispositivo {
    void abrir();
    void cerrar();
    public void setEstado(Estado estado);
    public Estado getEstado();
    public Mediador getMediador();

}
