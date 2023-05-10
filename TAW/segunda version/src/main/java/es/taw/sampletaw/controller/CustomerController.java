package es.taw.sampletaw.controller;

import es.taw.sampletaw.dao.CustomerRepository;
import es.taw.sampletaw.dao.DiscountCodeRepository;
import es.taw.sampletaw.dao.MicroMarketRepository;
import es.taw.sampletaw.entity.Administrador;
import es.taw.sampletaw.entity.Customer;
import es.taw.sampletaw.entity.DiscountCode;
import es.taw.sampletaw.entity.MicroMarket;
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
    protected CustomerRepository customerRepository;

    @Autowired
    protected DiscountCodeRepository discountCodeRepository;

    @Autowired
    protected MicroMarketRepository microMarketRepository;

    @GetMapping("/")
    public String doListar (Model model, HttpSession session) {
        return this.procesarFiltrado(null, model, session);
    }

    @PostMapping("/filtrar")
    public String doFiltrar (@ModelAttribute("filtro") Filtro filtro, Model model, HttpSession session) {
        return this.procesarFiltrado(filtro, model, session);
    }

    protected String procesarFiltrado (Filtro filtro, Model model, HttpSession session) {
        List<Customer> lista;
        String urlto = "customers";

        Administrador admin = (Administrador) session.getAttribute("admin");
        if(admin==null) {
            urlto = "login";
        } else {
            if(filtro == null || (filtro.getTexto().isEmpty() && filtro.getZipSupermercados().isEmpty())) {
                lista = this.customerRepository.findAll();
                filtro = new Filtro();
            } else if(filtro.getTexto().isEmpty()) {
                lista = this.customerRepository.buscarPorSupermecados(filtro.getZipSupermercados());
            } else if (filtro.getZipSupermercados().isEmpty()) {
                lista=this.customerRepository.buscarPorNombre(filtro.getTexto());
            } else {
                lista = this.customerRepository.buscarPorNombreYSupermercados(filtro.getTexto(), filtro.getZipSupermercados());
            }

            model.addAttribute("clientes", lista);
            model.addAttribute("filtro", filtro);
            List<MicroMarket> supermercados = this.microMarketRepository.findAll();
            model.addAttribute("supermercados", supermercados);
        }
        return urlto;
    }

    protected  void cargarSupermercadosYDescuentos (Model model) {
        List<DiscountCode> listadescuentos = this.discountCodeRepository.findAll();
        model.addAttribute("descuentos", listadescuentos);

        List<MicroMarket> listasupers = this.microMarketRepository.findAll();
        model.addAttribute("supermercados", listasupers);
    }

    protected String mostrarEditarONuevo (Customer cliente, Model model) {
        model.addAttribute("cliente", cliente);
        this.cargarSupermercadosYDescuentos(model);
        return "customer";
    }
    @GetMapping("/editar")
    public String doEditar (@RequestParam("id") Integer idcustomer, Model model) {
        Customer cliente = this.customerRepository.findById(idcustomer).orElse(null);
        return this.mostrarEditarONuevo(cliente, model);
    }

    @GetMapping("/nuevo")
    public String doNuevo (Model model) {return this.mostrarEditarONuevo(new Customer(), model); }

    @PostMapping("/guardar")
    public String doGuardar (@ModelAttribute("cliente") Customer cliente) {
        this.customerRepository.save(cliente);
        return "redirect:/customer/";
    }

    @GetMapping("/borrar")
    public String doBorrar (@RequestParam("id") Integer idcustomer) {
        this.customerRepository.deleteById(idcustomer);
        return "redirect:/customer/";
    }
}
