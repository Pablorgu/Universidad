public class Biestable implements Dispositivo{
    private Estado estado;
    private Mediador mediador;
    public Biestable(){
        this.estado = new Rojo();
        this.mediador = new MediadorConcreto(new EstadoBiestable());
    }
    public void abrir(){
        this.estado.abrir(this);
    }
    public void cerrar(){
        this.estado.cerrar(this);
    }

    public void setEstado(Estado estado){
        this.estado = estado;
    }

    public Estado getEstado() {
        return estado;
    }

    public Mediador getMediador() {
        return mediador;
    }

    @Override
    public void cambio() {
        mediador.cambioDispositivo(this,estado);
    }

    public void estado(){
        System.out.println(estado);
    }
}