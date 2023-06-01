package es.taw.starwars.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "ESPECIE")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "Especie.findAll", query = "SELECT e FROM Especie e"),
        @NamedQuery(name = "Especie.findByEspecieId", query = "SELECT e FROM Especie e WHERE e.especieId = :especieId"),
        @NamedQuery(name = "Especie.findByEspecie", query = "SELECT e FROM Especie e WHERE e.especie = :especie"),
        @NamedQuery(name = "Especie.findByPesoMedio", query = "SELECT e FROM Especie e WHERE e.pesoMedio = :pesoMedio"),
        @NamedQuery(name = "Especie.findByEsperanzaVida", query = "SELECT e FROM Especie e WHERE e.esperanzaVida = :esperanzaVida"),
        @NamedQuery(name = "Especie.findByIdioma", query = "SELECT e FROM Especie e WHERE e.idioma = :idioma")})
public class Especie implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ESPECIE_ID")
    private Integer especieId;
    @Basic(optional = false)
    @Column(name = "ESPECIE")
    private String especie;
    @Column(name = "PESO_MEDIO")
    private Integer pesoMedio;
    @Column(name = "ESPERANZA_VIDA")
    private Integer esperanzaVida;
    @Column(name = "IDIOMA")
    private String idioma;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "especie")
    private List<Personaje> personajeList;
    @JoinColumn(name = "CLASIFICACION", referencedColumnName = "FAMILIA_ID")
    @ManyToOne(optional = false)
    private FamiliaEspecie clasificacion;
    @JoinColumn(name = "PLANETA", referencedColumnName = "PLANETA_ID")
    @ManyToOne
    private Planeta planeta;

    public Especie() {
    }

    public Especie(Integer especieId) {
        this.especieId = especieId;
    }

    public Especie(Integer especieId, String especie) {
        this.especieId = especieId;
        this.especie = especie;
    }

    public Integer getEspecieId() {
        return especieId;
    }

    public void setEspecieId(Integer especieId) {
        this.especieId = especieId;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public Integer getPesoMedio() {
        return pesoMedio;
    }

    public void setPesoMedio(Integer pesoMedio) {
        this.pesoMedio = pesoMedio;
    }

    public Integer getEsperanzaVida() {
        return esperanzaVida;
    }

    public void setEsperanzaVida(Integer esperanzaVida) {
        this.esperanzaVida = esperanzaVida;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    @XmlTransient
    public List<Personaje> getPersonajeList() {
        return personajeList;
    }

    public void setPersonajeList(List<Personaje> personajeList) {
        this.personajeList = personajeList;
    }

    public FamiliaEspecie getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(FamiliaEspecie clasificacion) {
        this.clasificacion = clasificacion;
    }

    public Planeta getPlaneta() {
        return planeta;
    }

    public void setPlaneta(Planeta planeta) {
        this.planeta = planeta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (especieId != null ? especieId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Especie)) {
            return false;
        }
        Especie other = (Especie) object;
        if ((this.especieId == null && other.especieId != null) || (this.especieId != null && !this.especieId.equals(other.especieId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "es.starwars.entity.Especie[ especieId=" + especieId + " ]";
    }

}
