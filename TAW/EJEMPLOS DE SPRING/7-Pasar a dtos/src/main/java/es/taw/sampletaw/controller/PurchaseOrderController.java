package es.taw.sampletaw.controller;

import es.taw.sampletaw.dto.ProductDTO;
import es.taw.sampletaw.dto.PurchaseOrderDTO;
import es.taw.sampletaw.service.ProductService;
import es.taw.sampletaw.service.PurchaseOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/purchaseOrder")
public class PurchaseOrderController {

    @Autowired
    protected PurchaseOrderService purchaseOrderService;

    @Autowired
    protected ProductService productService;


    @GetMapping("/listar/{idcliente}")
    public String doListar(@PathVariable("idcliente")Integer id, Model model) {
        List<PurchaseOrderDTO> pedidos = this.purchaseOrderService.listarProductosCliente(id);
        model.addAttribute("pedidos", pedidos);

        model.addAttribute("idcliente", id);

        return "orders";
    }

    @GetMapping("/nuevo/{idcliente}")
    public String doNuevoPedidoCliente (@PathVariable("idcliente")Integer id, Model model) {
        PurchaseOrderDTO po = this.purchaseOrderService.inicializarPedido (id);
        model.addAttribute("pedido", po);

        List<ProductDTO> productList = this.productService.listarProductos();
        model.addAttribute("productos", productList);

        return "order";
    }

    @PostMapping("/guardar")
    public String doGuardar (@ModelAttribute("pedido") PurchaseOrderDTO pedido) {
        this.purchaseOrderService.guardarPedido(pedido);

        /*
        java.sql.Date sqlDate = new java.sql.Date(System.currentTimeMillis());
        pedido.setSalesDate(sqlDate);
        pedido.setQuantity((short)1);
        List<PurchaseOrder> pedidosDelCliente = pedido.getCustomerByCustomerId().getPurchaseOrdersByCustomerId();
        pedidosDelCliente.add(pedido);
        this.purchaseOrderRepository.save(pedido);
        this.customerRepository.save(pedido.getCustomerByCustomerId());
        */
        return "redirect:/purchaseOrder/listar/" + pedido.getCustomer().getCustomerId();
    }


}
