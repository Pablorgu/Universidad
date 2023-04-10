package es.taw.sampletaw.controller;

import es.taw.sampletaw.dao.CustomerRepository;
import es.taw.sampletaw.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public class CustomerController {


    @Autowired
    protected CustomerRepository customerRepository;

    @GetMapping
    public String doListar(Model model) {
        List<Customer> lista = this.customerRepository.findAll();
        model.addAttribute("clientes", lista);
        return "customers";
    }

    @GetMapping("/editar")
    public String doEditar(@RequestParam("id") Integer idcustomer) {
        //TODAVIA NO ESTÁ TERMINADO
        Customer cliente = this.customerRepository.findById(idcustomer).orElse(null);
        return "";
    }
}