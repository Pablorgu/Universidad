package es.taw.starwars.repository;

import es.taw.starwars.entity.FraseCelebre;
import es.taw.starwars.entity.Pelicula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.ui.Model;

import java.util.List;

public interface FrasesCelebresRepository extends JpaRepository<FraseCelebre, Integer> {
    @Query("select p from FraseCelebre p order by p.pelicula.titulo asc,p.personaje.nombre asc")
    public List<FraseCelebre> ordenarporpersonajeypeli();

    @Query("select p from FraseCelebre  p order by p.pelicula.titulo asc")
    public List<FraseCelebre> ordenarporpelicula();

    @Query("select p from FraseCelebre p order by p.personaje.nombre asc")
    public List<FraseCelebre> ordenarporpersonaje();
}
