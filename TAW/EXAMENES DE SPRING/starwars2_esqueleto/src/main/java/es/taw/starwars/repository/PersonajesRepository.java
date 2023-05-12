package es.taw.starwars.repository;

import es.taw.starwars.entity.Personaje;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonajesRepository extends JpaRepository<Personaje, Integer> {
}
