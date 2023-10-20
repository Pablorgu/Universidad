package es.taw.starwars.repository;

import es.taw.starwars.entity.Especie;
import es.taw.starwars.entity.Personaje;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface personajeRepository extends JpaRepository<Personaje, Integer> {
    @Query("select p from Personaje p where p.especie = :especie")
    public List<Personaje>listaPersonajesPorEspecie(@Param("especie")Especie especie);
}
