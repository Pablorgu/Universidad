package es.taw.starwars.dao;

import es.taw.starwars.entity.FamiliaEspecie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FamiliaEspecieRepository extends JpaRepository<FamiliaEspecie, Integer> {
}
