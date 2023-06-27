package es.taw.junio2023.entity;

import javax.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "ASIGNATURA_CARACTER", schema = "UNIVERSIDAD", catalog = "")
public class AsignaturaCaracterEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "IDCARACTER", nullable = false)
    private Short idcaracter;
    @Basic
    @Column(name = "CARACTER", nullable = false, length = 75)
    private String caracter;
    @OneToMany(mappedBy = "asignaturaCaracterByCaracter")
    private List<AsignaturaEntity> asignaturasByIdcaracter;

    public Short getIdcaracter() {
        return idcaracter;
    }

    public void setIdcaracter(Short idcaracter) {
        this.idcaracter = idcaracter;
    }

    public String getCaracter() {
        return caracter;
    }

    public void setCaracter(String caracter) {
        this.caracter = caracter;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AsignaturaCaracterEntity that = (AsignaturaCaracterEntity) o;
        return Objects.equals(idcaracter, that.idcaracter) && Objects.equals(caracter, that.caracter);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idcaracter, caracter);
    }

    public List<AsignaturaEntity> getAsignaturasByIdcaracter() {
        return asignaturasByIdcaracter;
    }

    public void setAsignaturasByIdcaracter(List<AsignaturaEntity> asignaturasByIdcaracter) {
        this.asignaturasByIdcaracter = asignaturasByIdcaracter;
    }
}
