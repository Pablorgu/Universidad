import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

public class Pais {
    private List<Persona> personas;

    public Pais() {
        this.personas = new ArrayList<Persona>();
    }

    void addPersona(Persona p) {
        assert(p!=null);
        personas.add(p);
    }

    void delPersona(Persona p) {
        assert(p!=null);
        personas.remove(p);
    }

    public Enumeration<Persona> leerPersonas(){
        return java.util.Collections.enumeration(personas);
    }
}
