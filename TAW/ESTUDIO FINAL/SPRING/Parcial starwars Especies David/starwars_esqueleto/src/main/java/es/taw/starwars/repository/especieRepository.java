package es.taw.starwars.repository;

import es.taw.starwars.entity.Especie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface especieRepository extends JpaRepository<Especie, Integer> {
}
