import java.util.Date;

public class Persona {
    private Integer fechaNacimiento;
    private Pais pais;
    private Relacion miembro1;
    private Relacion miembro2;

    public Persona(int fecha, Pais p) {
        assert(p!=null);
        this.setFechaNacimiento(fecha);
        this.setPais(p);
    }

    Integer getFechaNacimiento() {
        return this.fechaNacimiento;
    }

    void setFechaNacimiento(int fechaNacimiento) {
        assert(fechaNacimiento>=0);
        this.fechaNacimiento = fechaNacimiento;
    }

    Pais getPais() {
        return pais;
    }

    void setPais(Pais pais) {
        assert(pais!=null);
        this.pais = pais;
    }

    Relacion getMiembro1() {
        return miembro1;
    }

    void setMiembro1(Relacion miembro1) {
        assert(miembro2==null);
        this.miembro1 = miembro1;
    }

    Relacion getMiembro2() {
        return miembro2;
    }

    void setMiembro2(Relacion miembro2) {
        assert(miembro1==null);
        this.miembro2 = miembro2;
    }

    Boolean tienePareja(){
        if(miembro1!=null || miembro2!=null) {
            return true;
        }else{
            return false;
        }
    }

    Persona pareja(){
        assert(miembro1!=null || miembro2!=null);
        if(miembro1!=null){
            return miembro1.getMiembro2();
        }else{
            return miembro2.getMiembro1();
        }
    }
}
