package es.taw.starwars.dao;

import es.taw.starwars.entity.Planeta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PlanetaRepository extends JpaRepository<Planeta, Integer> {
    @Query("select p from Planeta p where p.clima like CONCAT('%', :filtro, '%')")
    public List<Planeta> buscarPorClima(@Param("filtro") String filtro);

    @Query("select distinct p.clima from Planeta p")
    public List<String> buscarClimas();
}
