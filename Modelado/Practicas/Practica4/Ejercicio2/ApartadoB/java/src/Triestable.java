public class Triestable implements Dispositivo{
    private Estado estado;
    private Mediador mediador;

    public Triestable(){
        this.estado = new Rojo();
        this.mediador = new MediadorConcreto(new EstadoTriestable());
    }
    @Override
    public void abrir() {
        this.estado.abrir(this);
    }

    @Override
    public void cerrar() {
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

    public void estado(){
        System.out.println(estado);
    }
}
