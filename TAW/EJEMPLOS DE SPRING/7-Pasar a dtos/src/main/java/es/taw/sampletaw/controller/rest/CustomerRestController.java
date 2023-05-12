package es.taw.sampletaw.controller.rest;

import es.taw.sampletaw.dto.CustomerDTO;
import es.taw.sampletaw.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/customer")
public class CustomerRestController {

    @Autowired
    protected CustomerService customerService;

    @GetMapping("/")
    public List<CustomerDTO> doListar () {
        return this.customerService.listarClientes();
    }


    @GetMapping("/{id}")
    public CustomerDTO doEditar (@PathVariable("id") Integer idcustomer) {
        return this.customerService.buscarCliente(idcustomer);
    }

    @PostMapping("/")
    public String doGuardar (@RequestBody CustomerDTO cliente) {
        this.customerService.guardarCliente(cliente);
        return "redirect:/customer/";
    }

    @DeleteMapping("/{id}")
    public void doBorrar (@PathVariable("id") Integer idcustomer) {
        this.customerService.borrarCliente(idcustomer);
    }


}
