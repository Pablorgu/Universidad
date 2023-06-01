package es.taw.starwars.repository;

import es.taw.starwars.entity.FamiliaEspecie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface familiaEspecieRepository extends JpaRepository<FamiliaEspecie, Integer> {
}
