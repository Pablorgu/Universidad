package es.taw.sampletaw.dao;

import es.taw.sampletaw.entity.CuentaEntity;
import es.taw.sampletaw.entity.MovimientoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MovimientoRepository extends JpaRepository<MovimientoEntity, Integer> {
}
