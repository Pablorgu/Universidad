package es.taw.starwars.dao;

import es.taw.starwars.entity.Planeta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PlanetaRepository extends JpaRepository<Planeta, Integer> {
    @Query("select distinct p.clima from Planeta p where p.clima!=null")
    public List<String> buscarClimas();

    @Query("select p from Planeta p where p.clima like CONCAT('%', :clima, '%')")
    public List<Planeta> buscarPlanetasPorClima(@Param("clima") String clima);
}
