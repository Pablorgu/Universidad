package es.taw.starwars.ui;

import es.taw.starwars.entity.Pelicula;
import es.taw.starwars.entity.Personaje;

public class Filtro {

    private boolean pelicula;

    private boolean personaje;

    public Filtro() {
        this.pelicula = false;
        this.personaje = false;
    }

    public boolean getPelicula() {
        return pelicula;
    }

    public void setPelicula(boolean pelicula) {
        this.pelicula = pelicula;
    }

    public boolean getPersonaje() {
        return personaje;
    }

    public void setPersonaje(boolean personaje) {
        this.personaje = personaje;
    }
}
