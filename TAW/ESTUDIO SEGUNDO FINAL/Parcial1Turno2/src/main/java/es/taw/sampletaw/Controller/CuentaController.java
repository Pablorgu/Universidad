package es.taw.sampletaw.Controller;

import es.taw.sampletaw.dao.*;
import es.taw.sampletaw.entity.CuentaEntity;
import es.taw.sampletaw.entity.CuentaclienteEntity;
import es.taw.sampletaw.entity.TipocomisionEntity;
import es.taw.sampletaw.ui.Filtro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class CuentaController {

    @Autowired
    CuentaRepository cuentaRepository;

    @Autowired
    MovimientoRepository movimientoRepository;

    @Autowired
    CuentaclienteRepository cuentaclienteRepository;

    @Autowired
    RolclienteRepository rolclienteRepository;

    @Autowired
    TipoComisionRepository tipoComisionRepository;

    @GetMapping("/")
    public String doListar(Model model) {
        List<CuentaEntity> cuentas = cuentaRepository.findAll();
        List<TipocomisionEntity> comisiones = tipoComisionRepository.findAll();
        model.addAttribute("cuentas", cuentas);
        model.addAttribute("comisiones", comisiones);
        model.addAttribute("filtro", new Filtro());
        return "listarCuentas";
    }

    @GetMapping("/filtrar")
    public String doFiltrar(@ModelAttribute("filtro") Filtro filtro, Model model) {
        List<TipocomisionEntity> comisiones = tipoComisionRepository.findAll();
        List<CuentaEntity> cuentas;
        if(filtro.getCantidad().equals("")) {
            cuentas = cuentaRepository.FiltrarPorComision(filtro.getComision());
        } else {
            cuentas = cuentaRepository.FiltrarPorComisionYSaldo(filtro.getComision(), Double.parseDouble(filtro.getCantidad()));
        }
        model.addAttribute("cuentas", cuentas);
        model.addAttribute("filtro", filtro);
        model.addAttribute("comisiones", comisiones);
        return "listarCuentas";
    }

    @GetMapping("/cuenta")
    public String doCuenta(@RequestParam("id") Integer idcuenta, Model model){
        CuentaEntity cuenta = cuentaRepository.findById(idcuenta).orElse(null);
        model.addAttribute("cuenta", cuenta);
        return "mostrarCuenta";
    }

    @GetMapping("/cambiarRol")
    public String doCambiarRol(@RequestParam("id") Integer id, Model model ) {
        CuentaclienteEntity c = cuentaclienteRepository.findById(id).orElse(null);
        if (c.getRolclienteByRolid().getRolid() == 1 && c.getCuentaByCuentaid().getCuentaclientesByCuentaid().size()!=1) {
            c.setRolclienteByRolid(rolclienteRepository.findById(2).orElse(null));
        } else {
            c.setRolclienteByRolid(rolclienteRepository.findById(1).orElse(null));
        }

        cuentaclienteRepository.save(c);
        return "redirect:/cuenta?id=" + c.getCuentaByCuentaid().getCuentaid();
    }

    @GetMapping("/eliminar")
    public String doEliminar(@RequestParam("id") Integer id, Model model) {
        CuentaclienteEntity c = cuentaclienteRepository.findById(id).orElse(null);
        List<CuentaclienteEntity> clientescuenta = c.getCuentaByCuentaid().getCuentaclientesByCuentaid();
        if(clientescuenta.size()>1)cuentaclienteRepository.deleteById(id);
        clientescuenta.remove(c);
        if(clientescuenta.size()==1){
            c=clientescuenta.get(0);
            c.setRolclienteByRolid(rolclienteRepository.findById(1).orElse(null));
            cuentaclienteRepository.save(c);
        }
        return "redirect:/cuenta?id=" + c.getCuentaByCuentaid().getCuentaid();
    }
}
