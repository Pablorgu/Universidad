package es.taw.junio2023.entity;

import javax.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "DEPARTAMENTO", schema = "UNIVERSIDAD", catalog = "")
public class DepartamentoEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "IDDEPARTAMENTO", nullable = false)
    private Short iddepartamento;
    @Basic
    @Column(name = "NOMBRE", nullable = false, length = 75)
    private String nombre;
    @OneToMany(mappedBy = "departamentoByDepartamento")
    private List<AsignaturaEntity> asignaturasByIddepartamento;

    public Short getIddepartamento() {
        return iddepartamento;
    }

    public void setIddepartamento(Short iddepartamento) {
        this.iddepartamento = iddepartamento;
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
        DepartamentoEntity that = (DepartamentoEntity) o;
        return Objects.equals(iddepartamento, that.iddepartamento) && Objects.equals(nombre, that.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(iddepartamento, nombre);
    }

    public List<AsignaturaEntity> getAsignaturasByIddepartamento() {
        return asignaturasByIddepartamento;
    }

    public void setAsignaturasByIddepartamento(List<AsignaturaEntity> asignaturasByIddepartamento) {
        this.asignaturasByIddepartamento = asignaturasByIddepartamento;
    }
}
