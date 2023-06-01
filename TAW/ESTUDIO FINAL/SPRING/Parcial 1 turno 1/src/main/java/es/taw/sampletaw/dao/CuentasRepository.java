package es.taw.sampletaw.dao;

import es.taw.sampletaw.entity.CuentaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CuentasRepository extends JpaRepository<CuentaEntity, Integer> {
    @Query("select c from CuentaEntity c where c.iban != :iban order by c.iban")
    public List<CuentaEntity> buscarOtrosIbanes(@Param("iban") String iban);
}
