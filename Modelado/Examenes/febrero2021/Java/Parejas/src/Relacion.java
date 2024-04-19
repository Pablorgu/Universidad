public class Relacion {
    private int inicioRelacion;
    Persona miembro1;
    Persona miembro2;

    public Relacion(int inicioRelacion) {
        this.setInicioRelacion(inicioRelacion);
    }

    int getInicioRelacion(){
        return this.inicioRelacion;
    }

    void setInicioRelacion(int inicioRelacion) {
        this.inicioRelacion = inicioRelacion;
    }

    Persona getMiembro1() {
        return miembro1;
    }

    void setMiembro1(Persona miembro1) {
        assert(miembro2!=miembro1);
        assert(miembro1.getFechaNacimiento()>18);
        assert(miembro1.getPais()==miembro2.getPais());
        this.miembro1 = miembro1;
        miembro1.setMiembro1(this);
    }

    Persona getMiembro2() {
        return miembro2;
    }

    void setMiembro2(Persona miembro2) {
        assert(miembro1!=miembro2);
        assert(miembro2.getFechaNacimiento()>18);
        assert(miembro1.getPais()==miembro2.getPais());
        this.miembro2 = miembro2;
        miembro2.setMiembro2(this);
    }
}
