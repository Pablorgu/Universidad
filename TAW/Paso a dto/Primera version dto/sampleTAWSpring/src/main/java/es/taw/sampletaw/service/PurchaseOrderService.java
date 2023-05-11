package es.taw.sampletaw.service;

import es.taw.sampletaw.dao.CustomerRepository;
import es.taw.sampletaw.dao.ProductRepository;
import es.taw.sampletaw.dao.PurchaseOrderRepository;
import es.taw.sampletaw.dto.CustomerDTO;
import es.taw.sampletaw.dto.PurchaseOrderDTO;
import es.taw.sampletaw.entity.Customer;
import es.taw.sampletaw.entity.Product;
import es.taw.sampletaw.entity.PurchaseOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PurchaseOrderService {

    @Autowired
    protected PurchaseOrderRepository purchaseOrderRepository;

    @Autowired
    protected CustomerService customerService;

    @Autowired
    protected CustomerRepository customerRepository;

    @Autowired
    protected ProductRepository productRepository;


    public List<PurchaseOrderDTO> listarProductosCliente (Integer idcliente) {
        List<PurchaseOrder> pedidos = this.purchaseOrderRepository.buscarPedidosPorCliente(idcliente);
        return this.listaEntidadesADTO(pedidos);
    }

    public PurchaseOrderDTO inicializarPedido (Integer idcliente) {
        PurchaseOrderDTO dto = new PurchaseOrderDTO();
        CustomerDTO cliente = this.customerService.buscarCliente(idcliente);
        dto.setCustomer(cliente);

        return dto;
    }

    public void guardarPedido (PurchaseOrderDTO dto) {
        PurchaseOrder pedido = new PurchaseOrder();
        pedido.setShippingCost(dto.getShippingCost());
        pedido.setFreightCompany(dto.getFreightCompany());
        java.sql.Date sqlDate = new java.sql.Date(System.currentTimeMillis());
        pedido.setSalesDate(sqlDate);
        pedido.setQuantity((short)1);
        pedido.setShippingDate(dto.getShippingDate());
        Customer cliente = this.customerRepository.findById(dto.getCustomer().getCustomerId()).orElse(null);
        pedido.setCustomerByCustomerId(cliente);
        Product producto = this.productRepository.findById(dto.getProduct().getProductId()).orElse(null);
        pedido.setProductByProductId(producto);

        this.purchaseOrderRepository.save(pedido);
    }

    protected List<PurchaseOrderDTO> listaEntidadesADTO (List<PurchaseOrder> lista) {
        ArrayList dtos = new ArrayList<CustomerDTO>();
        lista.forEach((final PurchaseOrder purchaseOrder) -> dtos.add(purchaseOrder.toDTO()));
        return dtos;
    }
}
