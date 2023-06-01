package es.taw.sampletaw.dao;

import es.taw.sampletaw.entity.CuentaEntity;
import es.taw.sampletaw.entity.TipocomisionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CuentaRepository extends JpaRepository<CuentaEntity, Integer> {
    @Query("select c from CuentaEntity c where c.tipocomisionByComision = :tipocomision order by c.cuentaid")
    public List<CuentaEntity> filtrarPorComision(@Param("tipocomision") TipocomisionEntity tipocomision);

    @Query("select c from CuentaEntity c where c.tipocomisionByComision = :tipocomision and c.saldoactual > :cantidad order by c.cuentaid")
    public List<CuentaEntity> filtrarPorComisionYCantidad(@Param("tipocomision") TipocomisionEntity tipocomision, @Param("cantidad") Double cantidad);
}
