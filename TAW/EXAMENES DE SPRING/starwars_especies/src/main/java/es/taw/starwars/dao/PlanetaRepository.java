package es.taw.starwars.dao;

import es.taw.starwars.entity.Planeta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlanetaRepository extends JpaRepository<Planeta, Integer> {
}
