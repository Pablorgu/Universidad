package es.taw.junio2023.dao;

import es.taw.junio2023.entity.CentroEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CentroRepository extends JpaRepository<CentroEntity, Short> {
}
