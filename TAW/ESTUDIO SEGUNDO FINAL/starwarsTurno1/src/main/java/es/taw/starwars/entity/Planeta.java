package es.taw.starwars.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * @author guzman
 */
@Entity
@Table(name = "PLANETA")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "Planeta.findAll", query = "SELECT p FROM Planeta p"),
        @NamedQuery(name = "Planeta.findByPlanetaId", query = "SELECT p FROM Planeta p WHERE p.planetaId = :planetaId"),
        @NamedQuery(name = "Planeta.findByNombre", query = "SELECT p FROM Planeta p WHERE p.nombre = :nombre"),
        @NamedQuery(name = "Planeta.findByDiametro", query = "SELECT p FROM Planeta p WHERE p.diametro = :diametro"),
        @NamedQuery(name = "Planeta.findByClima", query = "SELECT p FROM Planeta p WHERE p.clima = :clima"),
        @NamedQuery(name = "Planeta.findByGravedad", query = "SELECT p FROM Planeta p WHERE p.gravedad = :gravedad"),
        @NamedQuery(name = "Planeta.findByTerreno", query = "SELECT p FROM Planeta p WHERE p.terreno = :terreno"),
        @NamedQuery(name = "Planeta.findByPorcentajeAgua", query = "SELECT p FROM Planeta p WHERE p.porcentajeAgua = :porcentajeAgua")})
public class Planeta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "PLANETA_ID")
    private Integer planetaId;
    @Column(name = "NOMBRE")
    private String nombre;
    @Column(name = "DIAMETRO")
    private Integer diametro;
    @Column(name = "CLIMA")
    private String clima;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "GRAVEDAD")
    private Double gravedad;
    @Column(name = "TERRENO")
    private String terreno;
    @Column(name = "PORCENTAJE_AGUA")
    private Integer porcentajeAgua;
    @OneToMany(mappedBy = "planeta")
    private List<Personaje> personajeList;
    @OneToMany(mappedBy = "planeta")
    private List<Especie> especieList;

    public Planeta() {
    }

    public Planeta(Integer planetaId) {
        this.planetaId = planetaId;
    }

    public Integer getPlanetaId() {
        return planetaId;
    }

    public void setPlanetaId(Integer planetaId) {
        this.planetaId = planetaId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getDiametro() {
        return diametro;
    }

    public void setDiametro(Integer diametro) {
        this.diametro = diametro;
    }

    public String getClima() {
        return clima;
    }

    public void setClima(String clima) {
        this.clima = clima;
    }

    public Double getGravedad() {
        return gravedad;
    }

    public void setGravedad(Double gravedad) {
        this.gravedad = gravedad;
    }

    public String getTerreno() {
        return terreno;
    }

    public void setTerreno(String terreno) {
        this.terreno = terreno;
    }

    public Integer getPorcentajeAgua() {
        return porcentajeAgua;
    }

    public void setPorcentajeAgua(Integer porcentajeAgua) {
        this.porcentajeAgua = porcentajeAgua;
    }

    @XmlTransient
    public List<Personaje> getPersonajeList() {
        return personajeList;
    }

    public void setPersonajeList(List<Personaje> personajeList) {
        this.personajeList = personajeList;
    }

    @XmlTransient
    public List<Especie> getEspecieList() {
        return especieList;
    }

    public void setEspecieList(List<Especie> especieList) {
        this.especieList = especieList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (planetaId != null ? planetaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Planeta)) {
            return false;
        }
        Planeta other = (Planeta) object;
        if ((this.planetaId == null && other.planetaId != null) || (this.planetaId != null && !this.planetaId.equals(other.planetaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "es.starwars.entity.Planeta[ planetaId=" + planetaId + " ]";
    }

}
