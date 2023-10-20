package es.taw.junio2023.entity;

import javax.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "ASIGNATURA", schema = "UNIVERSIDAD", catalog = "")
public class AsignaturaEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "IDASIGNATURA", nullable = false)
    private Short idasignatura;
    @Basic
    @Column(name = "CODIGO", nullable = false)
    private Short codigo;
    @Basic
    @Column(name = "NOMBRE", nullable = false, length = 100)
    private String nombre;
    @Basic
    @Column(name = "CURSO", nullable = true)
    private Integer curso;
    @Basic
    @Column(name = "CUATRIMESTRE", nullable = false)
    private Integer cuatrimestre;
    @Basic
    @Column(name = "CRED_TEOR", nullable = false, precision = 0)
    private Double credTeor;
    @Basic
    @Column(name = "CRED_PRAC", nullable = false, precision = 0)
    private Double credPrac;
    /*
    @Basic
    @Column(name = "CARACTER", nullable = true, insertable = false, updatable = false)
    private Short caracter;
    @Basic
    @Column(name = "DEPARTAMENTO", nullable = true, insertable = false, updatable = false)
    private Short departamento;
     */
    @ManyToOne
    @JoinColumn(name = "CARACTER", referencedColumnName = "IDCARACTER")
    private AsignaturaCaracterEntity asignaturaCaracterByCaracter;
    @ManyToOne
    @JoinColumn(name = "DEPARTAMENTO", referencedColumnName = "IDDEPARTAMENTO")
    private DepartamentoEntity departamentoByDepartamento;
    @JoinTable(schema = "UNIVERSIDAD", name = "ASIGNATURA_TITULACION", joinColumns = {
            @JoinColumn(name = "IDASIGNATURA", referencedColumnName = "IDASIGNATURA")}, inverseJoinColumns = {
            @JoinColumn(name = "IDTITULACION", referencedColumnName = "IDTITULACION")})
    @ManyToMany
    private List<TitulacionEntity> titulacionByIdtitulacion;

    public Short getIdasignatura() {
        return idasignatura;
    }

    public void setIdasignatura(Short idasignatura) {
        this.idasignatura = idasignatura;
    }

    public Short getCodigo() {
        return codigo;
    }

    public void setCodigo(Short codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getCurso() {
        return curso;
    }

    public void setCurso(Integer curso) {
        this.curso = curso;
    }

    public Integer getCuatrimestre() {
        return cuatrimestre;
    }

    public void setCuatrimestre(Integer cuatrimestre) {
        this.cuatrimestre = cuatrimestre;
    }

    public Double getCredTeor() {
        return credTeor;
    }

    public void setCredTeor(Double credTeor) {
        this.credTeor = credTeor;
    }

    public Double getCredPrac() {
        return credPrac;
    }

    public void setCredPrac(Double credPrac) {
        this.credPrac = credPrac;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AsignaturaEntity that = (AsignaturaEntity) o;
        return Objects.equals(idasignatura, that.idasignatura) && Objects.equals(codigo, that.codigo) && Objects.equals(nombre, that.nombre) && Objects.equals(curso, that.curso) && Objects.equals(cuatrimestre, that.cuatrimestre) && Objects.equals(credTeor, that.credTeor) && Objects.equals(credPrac, that.credPrac);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idasignatura, codigo, nombre, curso, cuatrimestre, credTeor, credPrac);
    }

    /*
    public Short getCaracter() {
        return caracter;
    }

    public void setCaracter(Short caracter) {
        this.caracter = caracter;
    }

    public Short getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Short departamento) {
        this.departamento = departamento;
    }
     */

    public AsignaturaCaracterEntity getAsignaturaCaracterByCaracter() {
        return asignaturaCaracterByCaracter;
    }

    public void setAsignaturaCaracterByCaracter(AsignaturaCaracterEntity asignaturaCaracterByCaracter) {
        this.asignaturaCaracterByCaracter = asignaturaCaracterByCaracter;
    }

    public DepartamentoEntity getDepartamentoByDepartamento() {
        return departamentoByDepartamento;
    }

    public void setDepartamentoByDepartamento(DepartamentoEntity departamentoByDepartamento) {
        this.departamentoByDepartamento = departamentoByDepartamento;
    }

    public List<TitulacionEntity> getTitulacionByIdtitulacion() {
        return titulacionByIdtitulacion;
    }

    public void settitulacionByIdtitulacion(List<TitulacionEntity> titulacionByIdtitulacion) {
        this.titulacionByIdtitulacion = titulacionByIdtitulacion;
    }
}
