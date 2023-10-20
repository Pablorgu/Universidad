package es.taw.junio2023.entity;

import javax.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "NIVEL_ESTUDIOS", schema = "UNIVERSIDAD", catalog = "")
public class NivelEstudiosEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "IDNIVEL", nullable = false)
    private Short idnivel;
    @Basic
    @Column(name = "NOMBRE", nullable = false, length = 50)
    private String nombre;
    @OneToMany(mappedBy = "nivelEstudiosByNivel")
    private List<TitulacionEntity> titulacionsByIdnivel;

    public Short getIdnivel() {
        return idnivel;
    }

    public void setIdnivel(Short idnivel) {
        this.idnivel = idnivel;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NivelEstudiosEntity that = (NivelEstudiosEntity) o;
        return Objects.equals(idnivel, that.idnivel) && Objects.equals(nombre, that.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idnivel, nombre);
    }

    public List<TitulacionEntity> getTitulacionsByIdnivel() {
        return titulacionsByIdnivel;
    }

    public void setTitulacionsByIdnivel(List<TitulacionEntity> titulacionsByIdnivel) {
        this.titulacionsByIdnivel = titulacionsByIdnivel;
    }
}
