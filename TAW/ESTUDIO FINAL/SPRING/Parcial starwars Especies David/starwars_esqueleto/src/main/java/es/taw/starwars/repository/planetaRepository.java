package es.taw.starwars.repository;

import es.taw.starwars.entity.Filtro;
import es.taw.starwars.entity.Planeta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface planetaRepository extends JpaRepository<Planeta,Integer> {
    @Query("select distinct p.clima from Planeta p")
    public List<String> listaclimas();
    @Query("select p from Planeta p where p.clima like :filtro")
    public List<Planeta> listaplaneta(@Param("filtro")String filtro);
}
