package es.taw.junio2023.entity;

import javax.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "CENTRO", schema = "UNIVERSIDAD", catalog = "")
public class CentroEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "IDCENTRO", nullable = false)
    private Short idcentro;
    @Basic
    @Column(name = "NOMBRE", nullable = false, length = 50)
    private String nombre;
    @Basic
    @Column(name = "UBICACION", nullable = true, length = 100)
    private String ubicacion;
    @OneToMany(mappedBy = "centroByCentro")
    private List<TitulacionEntity> titulacionsByIdcentro;

    public Short getIdcentro() {
        return idcentro;
    }

    public void setIdcentro(Short idcentro) {
        this.idcentro = idcentro;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CentroEntity that = (CentroEntity) o;
        return Objects.equals(idcentro, that.idcentro) && Objects.equals(nombre, that.nombre) && Objects.equals(ubicacion, that.ubicacion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idcentro, nombre, ubicacion);
    }

    public List<TitulacionEntity> getTitulacionsByIdcentro() {
        return titulacionsByIdcentro;
    }

    public void setTitulacionsByIdcentro(List<TitulacionEntity> titulacionsByIdcentro) {
        this.titulacionsByIdcentro = titulacionsByIdcentro;
    }
}
