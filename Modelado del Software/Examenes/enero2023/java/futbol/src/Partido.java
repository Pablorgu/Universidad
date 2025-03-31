import java.util.Enumeration;

public class Partido {
    private boolean jugado=false;
    private int golesLocal=0;
    private int golesVisitante=0;
    private Equipo local;
    private Equipo visitante;
    private Equipo ganador;


    public Partido(Equipo local, Equipo visitante) {
        assert (local!=null);
        assert (visitante!=null);
        assert (this.noDups(local,visitante));
        assert(local!=visitante);

        this.setLocal(local);
        this.setVisitante(visitante);
        local.addPartidoLocal(this);
        visitante.addPartidoVisitante(this);
    }
    public Equipo getLocal(){
        return this.local;
    }

    public void setLocal(Equipo e) {
        assert(e!=null);
        this.local=e;
    }
    public Equipo getVisitante() {
        return this.visitante;
    }

    public void setVisitante(Equipo e) {
        assert(e!=null);
        this.visitante=e;
    }

    public boolean getJugado(){
        return this.jugado;
    }

    public void setJugado(){
        assert(!this.jugado);
        this.jugado=true;
        if(this.golesLocal>this.golesVisitante){
            this.ganador=this.local;
            this.ganador.addPartidoGanado(this);
        }else if(this.golesLocal<this.golesVisitante) {
            this.ganador=this.visitante;
            this.ganador.addPartidoGanado(this);
        }
    }


    public void golLocal() {
        golesLocal+=1;
    }

    public void golVisitante(){
        golesVisitante+=1;
    }

    public boolean noDups(Equipo l, Equipo v) {
        Enumeration<Partido> a = l.getPartidoLocal();
        while(a.hasMoreElements()) {
            if(a.nextElement().getVisitante()==v) return false;
        }
        return true;
    }

}
