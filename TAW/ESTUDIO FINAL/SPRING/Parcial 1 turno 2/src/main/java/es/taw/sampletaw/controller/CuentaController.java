package es.taw.sampletaw.controller;

import es.taw.sampletaw.dao.*;
import es.taw.sampletaw.entity.*;
import es.taw.sampletaw.iu.Filtro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class CuentaController {

    @Autowired
    protected CuentaRepository cuentaRepository;

    @Autowired
    protected CuentaclienteRepository cuentaclienteRepository;

    @Autowired
    protected MovimientoRepository movimientoRepository;

    @Autowired
    protected ClienteRepository clienteRepository;

    @Autowired
    protected RolClienteRepository rolClienteRepository;

    @Autowired
    protected TipocomisionRepository tipocomisionRepository;

    @GetMapping("/")
    public String doListarCuentas(Model model) {
        List<CuentaEntity> cuentas = this.cuentaRepository.findAll();
        Filtro filtro = new Filtro();
        model.addAttribute("tiposcomision", tipocomisionRepository.findAll());
        model.addAttribute("filtro", filtro);
        model.addAttribute("cuentas", cuentas);
        return "cuentas";
    }


    @PostMapping("/filtrar")
    public String doFiltrar(@ModelAttribute("filtro") Filtro filtro, Model model) {
        String urlTo;
        List<CuentaEntity> cuentas;
        if(filtro.getCantidad().equals("")){
            cuentas = cuentaRepository.filtrarPorComision(filtro.getTipocomision());
        } else {
            cuentas = cuentaRepository.filtrarPorComisionYCantidad(filtro.getTipocomision(), Double.parseDouble(filtro.getCantidad()));
        }
        model.addAttribute("tiposcomision", tipocomisionRepository.findAll());
        model.addAttribute("filtro", filtro);
        model.addAttribute("cuentas", cuentas);
        return "cuentas";
    }
    @GetMapping("/detalles")
    public String doDetalles(@RequestParam("id") Integer idCuenta, Model model) {
        CuentaEntity cuenta = this.cuentaRepository.findById(idCuenta).orElse(null);
        List<ClienteEntity> clientes = this.clienteRepository.findAll();
        model.addAttribute("clientes", clientes);
        model.addAttribute("cuenta", cuenta);
        return "detalles";
    }

    @GetMapping("/cambiarRol")
    public String doCambiarRol(@RequestParam("id") Integer CuentaClienteId, Model model) {
        CuentaclienteEntity c = this.cuentaclienteRepository.findById(CuentaClienteId).orElse(null);
        List<CuentaclienteEntity> ClientesCuenta = this.cuentaclienteRepository.buscarClientesdeCuenta(c.getCuentaByCuentaid().getCuentaid());
        RolclienteEntity rol;
        if(c.getRolclienteByRolid().getRolid() == 1) {
            rol = rolClienteRepository.findById(2).orElse(null);
        } else{
            rol = rolClienteRepository.findById(1).orElse(null);
        }
        if(ClientesCuenta.size()==1){
            c.setRolclienteByRolid(rolClienteRepository.findById(1).orElse(null));
        } else{
            c.setRolclienteByRolid(rol);
        }
        cuentaclienteRepository.save(c);
        return "redirect:/detalles?id="+ c.getCuentaByCuentaid().getCuentaid();
    }

    @GetMapping("/eliminarcliente")
    public String doEliminarCliente(@RequestParam("id") Integer CuentaClienteId, Model model) {
        CuentaclienteEntity c = this.cuentaclienteRepository.findById(CuentaClienteId).orElse(null);
        List<CuentaclienteEntity> ClientesCuenta = this.cuentaclienteRepository.buscarClientesdeCuenta(c.getCuentaByCuentaid().getCuentaid());
        if(ClientesCuenta.size() > 1) {
            cuentaclienteRepository.deleteById(CuentaClienteId);
        }
        ClientesCuenta = this.cuentaclienteRepository.buscarClientesdeCuenta(c.getCuentaByCuentaid().getCuentaid());
        if(ClientesCuenta.size()==1){
            c = ClientesCuenta.get(0);
            c.setRolclienteByRolid(rolClienteRepository.findById(1).orElse(null));
            cuentaclienteRepository.save(c);
        }
        return "redirect:/detalles?id="+ c.getCuentaByCuentaid().getCuentaid();
    }
}