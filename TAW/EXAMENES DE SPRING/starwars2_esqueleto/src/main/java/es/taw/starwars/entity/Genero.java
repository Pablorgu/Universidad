package es.taw.starwars.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
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
 *
 * @author guzman
 */
@Entity
@Table(name = "GENERO")
@XmlRootElement
public class Genero implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "GENERO_ID")
    private Integer generoId;
    @Basic(optional = false)
    @Column(name = "GENERO")
    private String genero;
    @OneToMany(mappedBy = "genero")
    private List<Personaje> personajeList;

    public Genero() {
    }

    public Genero(Integer generoId) {
        this.generoId = generoId;
    }

    public Genero(Integer generoId, String genero) {
        this.generoId = generoId;
        this.genero = genero;
    }

    public Integer getGeneroId() {
        return generoId;
    }

    public void setGeneroId(Integer generoId) {
        this.generoId = generoId;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    @XmlTransient
    public List<Personaje> getPersonajeList() {
        return personajeList;
    }

    public void setPersonajeList(List<Personaje> personajeList) {
        this.personajeList = personajeList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (generoId != null ? generoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Genero)) {
            return false;
        }
        Genero other = (Genero) object;
        if ((this.generoId == null && other.generoId != null) || (this.generoId != null && !this.generoId.equals(other.generoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "es.taw.starwars.entity.Genero[ generoId=" + generoId + " ]";
    }
    
}
