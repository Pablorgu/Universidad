package es.taw.sampletaw.dao;

import es.taw.sampletaw.entity.CuentaEntity;
import es.taw.sampletaw.entity.TipocomisionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CuentaRepository extends JpaRepository<CuentaEntity, Integer> {
    @Query("select c from CuentaEntity c where c.tipocomisionByComision = :tipocomision order by c.tipocomisionByComision.tipoid")
    public List<CuentaEntity> FiltrarPorComision (@Param("tipocomision") TipocomisionEntity tipocomision);

    @Query("select c from CuentaEntity c where c.tipocomisionByComision = :tipocomision and c.saldoactual > :saldo order by c.tipocomisionByComision.tipoid, c.saldoactual asc")
    public List<CuentaEntity> FiltrarPorComisionYSaldo (@Param("tipocomision") TipocomisionEntity tipocomision, @Param("saldo") Double saldo);
}
