package es.taw.junio2023.dao;

import es.taw.junio2023.entity.AsignaturaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AsignaturaRepository extends JpaRepository<AsignaturaEntity, Integer> {
    @Query("select a from AsignaturaEntity a order by a.curso, a.cuatrimestre")
    public List<AsignaturaEntity> buscarasignaturas();
}
