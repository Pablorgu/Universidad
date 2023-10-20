package es.taw.junio2023.dao;

import es.taw.junio2023.Controller.CentroController;
import es.taw.junio2023.entity.CentroEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CentrosRepository extends JpaRepository<CentroEntity, Integer> {
}
