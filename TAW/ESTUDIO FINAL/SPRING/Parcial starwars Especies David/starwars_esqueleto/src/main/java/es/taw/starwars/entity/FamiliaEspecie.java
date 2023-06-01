package es.taw.starwars.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "FAMILIA_ESPECIE")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "FamiliaEspecie.findAll", query = "SELECT f FROM FamiliaEspecie f"),
        @NamedQuery(name = "FamiliaEspecie.findByFamiliaId", query = "SELECT f FROM FamiliaEspecie f WHERE f.familiaId = :familiaId"),
        @NamedQuery(name = "FamiliaEspecie.findByFamilia", query = "SELECT f FROM FamiliaEspecie f WHERE f.familia = :familia")})
public class FamiliaEspecie implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "FAMILIA_ID")
    private Integer familiaId;
    @Basic(optional = false)
    @Column(name = "FAMILIA")
    private String familia;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "clasificacion")
    private List<Especie> especieList;

    public FamiliaEspecie() {
    }

    public FamiliaEspecie(Integer familiaId) {
        this.familiaId = familiaId;
    }

    public FamiliaEspecie(Integer familiaId, String familia) {
        this.familiaId = familiaId;
        this.familia = familia;
    }

    public Integer getFamiliaId() {
        return familiaId;
    }

    public void setFamiliaId(Integer familiaId) {
        this.familiaId = familiaId;
    }

    public String getFamilia() {
        return familia;
    }

    public void setFamilia(String familia) {
        this.familia = familia;
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
        hash += (familiaId != null ? familiaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FamiliaEspecie)) {
            return false;
        }
        FamiliaEspecie other = (FamiliaEspecie) object;
        if ((this.familiaId == null && other.familiaId != null) || (this.familiaId != null && !this.familiaId.equals(other.familiaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "es.starwars.entity.FamiliaEspecie[ familiaId=" + familiaId + " ]";
    }

}
