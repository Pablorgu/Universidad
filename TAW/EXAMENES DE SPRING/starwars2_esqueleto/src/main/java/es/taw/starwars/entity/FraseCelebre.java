
package es.taw.starwars.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author guzman
 */
@Entity
@Table(name = "FRASE_CELEBRE")
@XmlRootElement
public class FraseCelebre implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "FRASE_ID")
    private Integer fraseId;
    @Column(name = "FRASE")
    private String frase;
    @JoinColumn(name = "PELICULA", referencedColumnName = "PELICULA_ID")
    @ManyToOne
    private Pelicula pelicula;
    @JoinColumn(name = "PERSONAJE", referencedColumnName = "PERSONAJE_ID")
    @ManyToOne
    private Personaje personaje;

    public FraseCelebre() {
    }

    public FraseCelebre(Integer fraseId) {
        this.fraseId = fraseId;
    }

    public Integer getFraseId() {
        return fraseId;
    }

    public void setFraseId(Integer fraseId) {
        this.fraseId = fraseId;
    }

    public String getFrase() {
        return frase;
    }

    public void setFrase(String frase) {
        this.frase = frase;
    }

    public Pelicula getPelicula() {
        return pelicula;
    }

    public void setPelicula(Pelicula pelicula) {
        this.pelicula = pelicula;
    }

    public Personaje getPersonaje() {
        return personaje;
    }

    public void setPersonaje(Personaje personaje) {
        this.personaje = personaje;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (fraseId != null ? fraseId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FraseCelebre)) {
            return false;
        }
        FraseCelebre other = (FraseCelebre) object;
        if ((this.fraseId == null && other.fraseId != null) || (this.fraseId != null && !this.fraseId.equals(other.fraseId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "es.taw.starwars.entity.FraseCelebre[ fraseId=" + fraseId + " ]";
    }
    
}
