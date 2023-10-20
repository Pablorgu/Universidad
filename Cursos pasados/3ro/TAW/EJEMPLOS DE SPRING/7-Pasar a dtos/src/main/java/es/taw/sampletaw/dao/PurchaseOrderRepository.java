package es.taw.sampletaw.dao;

import es.taw.sampletaw.entity.PurchaseOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PurchaseOrderRepository extends JpaRepository<PurchaseOrder, Integer> {


    @Query("select po from PurchaseOrder po where po.customerByCustomerId.customerId = :id")
    public List<PurchaseOrder> buscarPedidosPorCliente (@Param("id")Integer customerId);
}