import java.util.Enumeration;
import java.util.LinkedList;
import java.util.List;

public class Equipo {
    private Estadio estadio;
    private List<Partido> partidoGanado = new LinkedList<Partido>();
    private List<Partido> partidoLocal = new LinkedList<Partido>();
    private List<Partido> partidoVisitante = new LinkedList<>();

    public Estadio getEstadio() {
        return estadio;
    }

    public void setEstadio(Estadio e) {
        assert(e!=null);
        if(this.estadio!=null)this.estadio.removeEquipo(this);
        this.estadio = e;
        estadio.addEquipo(this);
    }

    public Equipo(Estadio equipo) {
        this.setEstadio(equipo);
    }

    public void addPartidoLocal(Partido p) {
        assert(p!=null);
        this.partidoLocal.add(p);
    }

    public void addPartidoVisitante(Partido p) {
        assert(p!=null);
        this.partidoVisitante.add(p);
    }

    public void addPartidoGanado(Partido p) {
        assert(p!=null);
        this.partidoGanado.add(p);
    }

    public Enumeration<Partido> getPartidoLocal() {
        return java.util.Collections.enumeration(this.partidoLocal);
    }

    public Enumeration<Partido> getPartidoVisitante() {
        return java.util.Collections.enumeration(this.partidoVisitante);
    }

    public Enumeration<Partido> getPartidoGanado() {
        return java.util.Collections.enumeration(this.partidoGanado);
    }
}
