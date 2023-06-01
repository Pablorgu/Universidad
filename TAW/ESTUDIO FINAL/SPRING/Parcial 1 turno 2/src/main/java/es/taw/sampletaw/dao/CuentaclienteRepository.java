package es.taw.sampletaw.dao;

import es.taw.sampletaw.entity.CuentaclienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CuentaclienteRepository extends JpaRepository<CuentaclienteEntity, Integer> {
    @Query("select c from CuentaclienteEntity c where c.cuentaByCuentaid.cuentaid = :cuentaid")
    public List<CuentaclienteEntity> buscarClientesdeCuenta(@Param("cuentaid") Integer cuentaid);
}
