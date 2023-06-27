package es.taw.junio2023.entity;

import javax.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "TITULACION", schema = "UNIVERSIDAD", catalog = "")
public class TitulacionEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "IDTITULACION", nullable = false)
    private Short idtitulacion;
    @Basic
    @Column(name = "NOMBRE", nullable = false, length = 100)
    private String nombre;
    //@Basic
    //@Column(name = "CENTRO", nullable = true, insertable = false, updatable = false)
    //private Short centro;
    //@Basic
    //@Column(name = "NIVEL", nullable = true, insertable = false, updatable = false)
    //private Short nivel;
    @ManyToMany(mappedBy = "titulacionByIdtitulacion")
    private List<AsignaturaEntity> asignaturaByAsignatura;
    @ManyToOne
    @JoinColumn(name = "CENTRO", referencedColumnName = "IDCENTRO")
    private CentroEntity centroByCentro;
    @ManyToOne
    @JoinColumn(name = "NIVEL", referencedColumnName = "IDNIVEL")
    private NivelEstudiosEntity nivelEstudiosByNivel;

    public Short getIdtitulacion() {
        return idtitulacion;
    }

    public void setIdtitulacion(Short idtitulacion) {
        this.idtitulacion = idtitulacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /*
    public Short getCentro() {
        return centro;
    }


    public void setCentro(Short centro) {
        this.centro = centro;
    }

    public Short getNivel() {
        return nivel;
    }

    public void setNivel(Short nivel) {
        this.nivel = nivel;
    }
     */

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TitulacionEntity that = (TitulacionEntity) o;
        return Objects.equals(idtitulacion, that.idtitulacion) && Objects.equals(nombre, that.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idtitulacion, nombre);
    }

    public List<AsignaturaEntity> getAsignaturaByAsignatura() {
        return asignaturaByAsignatura;
    }

    public void setAsignaturaByAsignatura(List<AsignaturaEntity> asignaturaByAsignatura) {
        this.asignaturaByAsignatura = asignaturaByAsignatura;
    }

    public CentroEntity getCentroByCentro() {
        return centroByCentro;
    }

    public void setCentroByCentro(CentroEntity centroByCentro) {
        this.centroByCentro = centroByCentro;
    }

    public NivelEstudiosEntity getNivelEstudiosByNivel() {
        return nivelEstudiosByNivel;
    }

    public void setNivelEstudiosByNivel(NivelEstudiosEntity nivelEstudiosByNivel) {
        this.nivelEstudiosByNivel = nivelEstudiosByNivel;
    }
}
