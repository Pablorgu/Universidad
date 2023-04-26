package es.taw.sampletaw.service;


import es.taw.sampletaw.dao.CustomerRepository;
import es.taw.sampletaw.dao.DiscountCodeRepository;
import es.taw.sampletaw.dao.MicroMarketRepository;
import es.taw.sampletaw.dto.CustomerDTO;
import es.taw.sampletaw.entity.Customer;
import es.taw.sampletaw.entity.DiscountCode;
import es.taw.sampletaw.entity.MicroMarket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService {

    @Autowired
    protected CustomerRepository customerRepository;

    @Autowired
    protected MicroMarketRepository microMarketRepository;


    @Autowired
    protected DiscountCodeRepository discountCodeRepository;


    public List<CustomerDTO> listarClientes (String texto, List<String> supermercados) {
        List<Customer> lista;
        if (texto.isEmpty() && supermercados.isEmpty()) {
            lista = this.customerRepository.findAll();
        } else if (texto.isEmpty()) {
            lista = this.customerRepository.buscarPorSupermercados(supermercados);
        } else if (supermercados.isEmpty()) {
            lista = this.customerRepository.buscarPorNombre(texto);
        } else {
            lista = this.customerRepository.buscarPorNombreYSupermercados(texto, supermercados);
        }

        return this.listaEntidadesADTO(lista);


    }
    public List<CustomerDTO> listarClientes () {
        List<Customer> clientes = this.customerRepository.findAll();
        return this.listaEntidadesADTO(clientes);
    }

    public CustomerDTO buscarCliente (Integer id) {
        Customer cliente = this.customerRepository.findById(id).orElse(null);
        if (cliente != null) {
            return cliente.toDTO();
        } else {
            return null;
        }
    }

    public void guardarCliente (CustomerDTO dto) {

        Customer cliente;
        cliente = new Customer();

        cliente.setCustomerId(dto.getCustomerId());
        cliente.setName(dto.getName());
        cliente.setEmail(dto.getEmail());
        cliente.setAddressline1(dto.getAddressline1());
        cliente.setAddressline2(dto.getAddressline2());
        cliente.setCreditLimit(dto.getCreditLimit());
        cliente.setPhone(dto.getPhone());
        cliente.setFax(dto.getFax());
        cliente.setCity(dto.getCity());
        cliente.setState(dto.getState());

        MicroMarket mm = this.microMarketRepository.findById(dto.getMicroMarket()).orElse(null);
        cliente.setMicroMarketByZip(mm);

        DiscountCode dc = this.discountCodeRepository.findById(dto.getDiscountCode()).orElse(null);
        cliente.setDiscountCodeByDiscountCode(dc);

        this.customerRepository.save(cliente);
    }

    public void borrarCliente (Integer id) {
        Customer cliente = this.customerRepository.findById(id).orElse(null);
        this.customerRepository.delete(cliente);
    }

    protected List<CustomerDTO> listaEntidadesADTO (List<Customer> lista) {
        ArrayList dtos = new ArrayList<CustomerDTO>();

        lista.forEach((final Customer cliente) -> dtos.add(cliente.toDTO()));

        return dtos;
    }

}
