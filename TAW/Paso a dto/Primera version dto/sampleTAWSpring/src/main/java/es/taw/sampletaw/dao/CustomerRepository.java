package es.taw.sampletaw.dao;


import es.taw.sampletaw.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    @Query("select c from Customer c where c.name like CONCAT('%', :filtro, '%') or c.email like CONCAT('%', :filtro, '%')")
    public List<Customer> buscarPorNombre (@Param("filtro") String filtro);

    @Query("select c from Customer c where c.microMarketByZip.zipCode = :zip")
    public List<Customer> buscarPorSupermercado (@Param("zip") String cp);

    @Query("select c from Customer c where c.microMarketByZip.zipCode in :zips")
    public List<Customer> buscarPorSupermercados (@Param("zips") List<String> zips);

    @Query("select c from Customer c where (c.name like CONCAT('%', :texto, '%') or c.email like CONCAT('%', :texto, '%') ) and c.microMarketByZip.zipCode in :zips")
    public List<Customer> buscarPorNombreYSupermercados (@Param("texto") String texto, @Param("zips") List<String> zips);



}