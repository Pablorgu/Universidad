package es.taw.starwars.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
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
@Table(name = "PERSONAJE")
@XmlRootElement
public class Personaje implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "PERSONAJE_ID")
    private Integer personajeId;
    @Column(name = "NOMBRE")
    private String nombre;
    @Column(name = "COLOR_PELO")
    private String colorPelo;
    @Column(name = "COLOR_PIEL")
    private String colorPiel;
    @Column(name = "COLOR_OJOS")
    private String colorOjos;
    @Column(name = "ANYO_NACIMIENTO")
    private String anyoNacimiento;
    @ManyToMany(mappedBy = "personajeList")
    private List<Pelicula> peliculaList;
    @JoinColumn(name = "GENERO", referencedColumnName = "GENERO_ID")
    @ManyToOne
    private Genero genero;
    @JoinColumn(name = "PLANETA", referencedColumnName = "PLANETA_ID")
    @ManyToOne
    private Planeta planeta;
    @OneToMany(mappedBy = "personaje")
    private List<FraseCelebre> fraseCelebreList;

    public Personaje() {
    }

    public Personaje(Integer personajeId) {
        this.personajeId = personajeId;
    }

    public Integer getPersonajeId() {
        return personajeId;
    }

    public void setPersonajeId(Integer personajeId) {
        this.personajeId = personajeId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getColorPelo() {
        return colorPelo;
    }

    public void setColorPelo(String colorPelo) {
        this.colorPelo = colorPelo;
    }

    public String getColorPiel() {
        return colorPiel;
    }

    public void setColorPiel(String colorPiel) {
        this.colorPiel = colorPiel;
    }

    public String getColorOjos() {
        return colorOjos;
    }

    public void setColorOjos(String colorOjos) {
        this.colorOjos = colorOjos;
    }

    public String getAnyoNacimiento() {
        return anyoNacimiento;
    }

    public void setAnyoNacimiento(String anyoNacimiento) {
        this.anyoNacimiento = anyoNacimiento;
    }

    @XmlTransient
    public List<Pelicula> getPeliculaList() {
        return peliculaList;
    }

    public void setPeliculaList(List<Pelicula> peliculaList) {
        this.peliculaList = peliculaList;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public Planeta getPlaneta() {
        return planeta;
    }

    public void setPlaneta(Planeta planeta) {
        this.planeta = planeta;
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
        hash += (personajeId != null ? personajeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Personaje)) {
            return false;
        }
        Personaje other = (Personaje) object;
        if ((this.personajeId == null && other.personajeId != null) || (this.personajeId != null && !this.personajeId.equals(other.personajeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "es.taw.starwars.entity.Personaje[ personajeId=" + personajeId + " ]";
    }
    
}
