package es.taw.starwars.entity;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
@Table(name = "PELICULA")
@XmlRootElement
public class Pelicula implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "PELICULA_ID")
    private Integer peliculaId;
    @Column(name = "TITULO")
    private String titulo;
    @Column(name = "ANYO")
    private Integer anyo;
    @Column(name = "TEXTO_APERTURA")
    private String textoApertura;
    @JoinTable(name = "PELICULA_PERSONAJE", joinColumns = {
        @JoinColumn(name = "PELICULA", referencedColumnName = "PELICULA_ID")}, inverseJoinColumns = {
        @JoinColumn(name = "PERSONAJE", referencedColumnName = "PERSONAJE_ID")})
    @ManyToMany
    private List<Personaje> personajeList;
    @OneToMany(mappedBy = "pelicula")
    private List<FraseCelebre> fraseCelebreList;

    public Pelicula() {
    }

    public Pelicula(Integer peliculaId) {
        this.peliculaId = peliculaId;
    }

    public Integer getPeliculaId() {
        return peliculaId;
    }

    public void setPeliculaId(Integer peliculaId) {
        this.peliculaId = peliculaId;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Integer getAnyo() {
        return anyo;
    }

    public void setAnyo(Integer anyo) {
        this.anyo = anyo;
    }

    public String getTextoApertura() {
        return textoApertura;
    }

    public void setTextoApertura(String textoApertura) {
        this.textoApertura = textoApertura;
    }

    @XmlTransient
    public List<Personaje> getPersonajeList() {
        return personajeList;
    }

    public void setPersonajeList(List<Personaje> personajeList) {
        this.personajeList = personajeList;
    }

    @XmlTransient
    public List<FraseCelebre> getFraseCelebreList() {
        return fraseCelebreList;
    }

    public void setFraseCelebreList(List<FraseCelebre> fraseCelebreList) {
        this.fraseCelebreList = fraseCelebreList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (peliculaId != null ? peliculaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pelicula)) {
            return false;
        }
        Pelicula other = (Pelicula) object;
        if ((this.peliculaId == null && other.peliculaId != null) || (this.peliculaId != null && !this.peliculaId.equals(other.peliculaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "es.taw.starwars.entity.Pelicula[ peliculaId=" + peliculaId + " ]";
    }

}
