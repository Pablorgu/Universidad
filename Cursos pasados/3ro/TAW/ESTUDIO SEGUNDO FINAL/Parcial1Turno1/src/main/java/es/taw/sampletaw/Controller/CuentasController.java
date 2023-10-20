package es.taw.sampletaw.Controller;

import es.taw.sampletaw.dao.ClienteRepository;
import es.taw.sampletaw.dao.CuentaRepository;
import es.taw.sampletaw.dao.MovimientoRepository;
import es.taw.sampletaw.dao.TipooperacionRepository;
import es.taw.sampletaw.entity.CuentaEntity;
import es.taw.sampletaw.entity.MovimientoEntity;
import es.taw.sampletaw.entity.TipooperacionEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Timestamp;
import java.util.List;

@Controller
public class CuentasController {

    @Autowired
    ClienteRepository clienteRepository;

    @Autowired
    CuentaRepository cuentaRepository;

    @Autowired
    MovimientoRepository movimientoRepository;

    @Autowired
    TipooperacionRepository tipooperacionRepository;

    @GetMapping("/")
    public String doListar(Model model) {
        List<CuentaEntity> cuentas = cuentaRepository.findAll();
        model.addAttribute("cuentas", cuentas);
        return "listarCuentas";
    }

    @GetMapping("/cambiarestado")
    public String doCambiarEstado(@RequestParam("id") Integer idcuenta, Model model) {
        CuentaEntity cuenta = cuentaRepository.findById(idcuenta).orElse(null);
        if (cuenta.getActiva() == 1) {
            cuenta.setActiva((short) 0);
        } else {
            cuenta.setActiva((short) 1);
        }
        cuentaRepository.save(cuenta);
        return "redirect:/";
    }

    @GetMapping("/transferencia")
    public String doTransferencia(@RequestParam("id") Integer idcuenta, Model model) {
        CuentaEntity cuenta = cuentaRepository.findById(idcuenta).orElse(null);
        List<CuentaEntity> restocuentas = cuentaRepository.buscarResto(cuenta.getIban());
        MovimientoEntity movimiento = new MovimientoEntity();
        movimiento.setCuentaByCuentaorigen(cuenta);
        model.addAttribute("movimiento", movimiento);
        model.addAttribute("cuenta", cuenta);
        model.addAttribute("restocuentas", restocuentas );
        return "vistaTransferencia";
    }

    @PostMapping("/realizar")
    public String doRealizar(@ModelAttribute("movimiento") MovimientoEntity movimientoform, Model model) {
        CuentaEntity origen = movimientoform.getCuentaByCuentaorigen();
        CuentaEntity destino = movimientoform.getCuentaByCuentadestinatario();
        Timestamp currenttime = new Timestamp(System.currentTimeMillis());
        movimientoform.setCantidad(movimientoform.getCantidad()*(-1));
        movimientoform.setFecha(currenttime);
        movimientoform.setTipooperacionByTipooperacion(tipooperacionRepository.findById(2).orElse(null));
        MovimientoEntity movimientoinverso = new MovimientoEntity();
        movimientoinverso.setFecha(currenttime);
        movimientoinverso.setTipooperacionByTipooperacion(movimientoform.getTipooperacionByTipooperacion());
        movimientoinverso.setCantidad(movimientoform.getCantidad()*(-1));
        movimientoinverso.setCuentaByCuentadestinatario(movimientoform.getCuentaByCuentadestinatario());
        movimientoinverso.setCuentaByCuentaorigen(movimientoform.getCuentaByCuentaorigen());
        movimientoinverso.setDescripcion(movimientoform.getDescripcion());
        origen.setSaldoactual(origen.getSaldoactual()+movimientoform.getCantidad());
        destino.setSaldoactual(destino.getSaldoactual()+movimientoinverso.getCantidad());
        cuentaRepository.save(origen);
        cuentaRepository.save(destino);
        movimientoRepository.save(movimientoform);
        movimientoRepository.save(movimientoinverso);
        return "redirect:/";
    }
}
