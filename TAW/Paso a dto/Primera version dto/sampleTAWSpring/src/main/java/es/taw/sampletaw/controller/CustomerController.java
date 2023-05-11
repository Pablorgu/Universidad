package es.taw.sampletaw.controller;

import es.taw.sampletaw.dto.AdministradorDTO;
import es.taw.sampletaw.dto.CustomerDTO;
import es.taw.sampletaw.dto.DiscountCodeDTO;
import es.taw.sampletaw.dto.MicroMarketDTO;
import es.taw.sampletaw.service.CustomerService;
import es.taw.sampletaw.service.DiscountCodeService;
import es.taw.sampletaw.service.MicroMarketService;
import es.taw.sampletaw.ui.Filtro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    protected CustomerService customerService;

    @Autowired
    protected DiscountCodeService discountCodeService;

    @Autowired
    protected MicroMarketService microMarketService;

    @GetMapping("/")
    public String doListar (Model model, HttpSession session) {
        return this.procesarFiltrado(null, model, session);
    }

    @PostMapping("/filtrar")
    public String doFiltrar (@ModelAttribute("filtro") Filtro filtro,
                             Model model, HttpSession session) {
        return this.procesarFiltrado(filtro, model, session);
    }

    protected String procesarFiltrado (Filtro filtro,
                             Model model, HttpSession session) {
        List<CustomerDTO> lista;
        String urlto = "customers";

        AdministradorDTO admin = (AdministradorDTO) session.getAttribute("admin");
        if (admin == null) {
            urlto = "login";
        } else {
            if (filtro == null || (filtro.getTexto().isEmpty() && filtro.getZipSupermercados().isEmpty())) {
                lista = this.customerService.listarClientes();
                filtro = new Filtro();
            } else {
                lista = this.customerService.listarClientes(filtro.getTexto(), filtro.getZipSupermercados());

            }
            model.addAttribute("clientes", lista);
            model.addAttribute("filtro", filtro);
            List<MicroMarketDTO> supermercados = this.microMarketService.listarSupermercados();
            model.addAttribute("supermercados", supermercados);
        }

        return urlto;
    }

    protected void cargarSupermercadosYDescuentos (Model model) {
        List<DiscountCodeDTO> listadescuentos = this.discountCodeService.listarCodigosDescuento();
        model.addAttribute("descuentos", listadescuentos);

        List<MicroMarketDTO> listasupers = this.microMarketService.listarSupermercados();
        model.addAttribute("supermercados", listasupers);
    }

    protected String mostrarEditarONuevo (CustomerDTO cliente, Model model) {
        model.addAttribute("cliente", cliente);
        this.cargarSupermercadosYDescuentos(model);
        return "customer";
    }

    @GetMapping("/editar/{id}")
    public String doEditar (@PathVariable("id") Integer idcustomer, Model model) {
        CustomerDTO cliente = this.customerService.buscarCliente(idcustomer);
        return this.mostrarEditarONuevo(cliente, model);
    }

    @GetMapping("/nuevo")
    public String doNuevo (Model model) {
        return this.mostrarEditarONuevo(new CustomerDTO(), model);
    }

    @PostMapping("/guardar")
    public String doGuardar (@ModelAttribute("cliente") CustomerDTO cliente) {
        this.customerService.guardarCliente(cliente);
        return "redirect:/customer/";
    }

    @GetMapping("/borrar/{id}")
    public String doBorrar (@PathVariable("id") Integer idcustomer) {
        this.customerService.borrarCliente(idcustomer);
        return "redirect:/customer/";
    }

}
