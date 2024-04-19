import java.util.LinkedList;
import java.util.List;

public class Estadio {
    private List<Equipo> equipo;

    public Estadio() {
        equipo = new LinkedList<Equipo>();
    }

    void addEquipo(Equipo e) {
        assert (e!=null);
        equipo.add(e);
    }

    void removeEquipo(Equipo e) {
        assert (e!=null);
        equipo.remove(e);
    }
}
