package es.taw.junio2023.dao;

import es.taw.junio2023.entity.TitulacionEntity;
import net.bytebuddy.implementation.bytecode.ShiftRight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TitulacionRepository extends JpaRepository<TitulacionEntity, Short> {
    @Query("select t from TitulacionEntity t where t.centroByCentro.idcentro = :idcentro order by t.nivelEstudiosByNivel.nombre, t.nombre")
    public List<TitulacionEntity> buscarTitulacionPorCentro(@Param("idcentro") Short idcentro);
}
