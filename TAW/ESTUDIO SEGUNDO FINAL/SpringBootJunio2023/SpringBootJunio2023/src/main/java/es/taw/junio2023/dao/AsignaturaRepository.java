package es.taw.junio2023.dao;

import es.taw.junio2023.entity.AsignaturaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AsignaturaRepository extends JpaRepository<AsignaturaEntity, Short> {
    @Query("select a from AsignaturaEntity a order by a.curso asc , a.cuatrimestre asc ")
    public List<AsignaturaEntity> buscarasignaturas();
}
