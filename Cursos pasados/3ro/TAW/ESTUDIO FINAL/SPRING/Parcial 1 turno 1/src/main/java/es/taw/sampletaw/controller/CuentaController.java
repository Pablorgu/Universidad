package es.taw.sampletaw.controller;

import es.taw.sampletaw.dao.ClientesRepository;
import es.taw.sampletaw.dao.CuentasRepository;
import es.taw.sampletaw.dao.MovimientoRepository;
import es.taw.sampletaw.dao.TipooperacionRepository;
import es.taw.sampletaw.entity.ClienteEntity;
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

import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Controller
public class CuentaController {

    @Autowired
    protected ClientesRepository clientesRepository;

    @Autowired
    protected CuentasRepository cuentasRepository;

    @Autowired
    protected MovimientoRepository movimientoRepository;

    @Autowired
    protected TipooperacionRepository tipooperacionRepository;

    @GetMapping("/")
    public String doListar (Model model) {
        List<CuentaEntity> lista;
        lista = this.cuentasRepository.findAll();
        model.addAttribute("cuentas", lista);
        return "cuentas";
    }

    @GetMapping("/cambiarestado")
    public String doCambioEstado(@RequestParam("id") Integer id, Model model) {
        CuentaEntity cuenta = this.cuentasRepository.findById(id).orElse(null);
        if(cuenta.getActiva() == 1) {
            cuenta.setActiva((short) 0);
        } else {
            cuenta.setActiva((short) 1);
        }
        cuentasRepository.save(cuenta);
        return "redirect:/";
    }

    @GetMapping("realizartransferencia")
    public String doTransferencia(@RequestParam("id") Integer id, Model model) {
        MovimientoEntity movimiento = new MovimientoEntity();
        CuentaEntity cuentaOrigen = cuentasRepository.findById(id).orElse(null);
        movimiento.setCuentaByCuentaorigen(cuentaOrigen);
        List<CuentaEntity> cuentas = this.cuentasRepository.buscarOtrosIbanes(this.cuentasRepository.findById(id).orElse(null).getIban());
        ClienteEntity cliente = cuentaOrigen.getClienteByTitular();
        model.addAttribute("cliente", cliente);
        model.addAttribute("cuenta", cuentaOrigen);
        model.addAttribute("movimiento", movimiento);
        model.addAttribute("ibanes", cuentas);
        return "transferencia";
    }

    @PostMapping("/guardar")
    public String doGuardarTransferencia(@ModelAttribute("movimiento") MovimientoEntity movimiento) {
        Timestamp time = new Timestamp(System.currentTimeMillis());
        movimiento.setFecha(time);
        TipooperacionEntity tipooperacion = this.tipooperacionRepository.getById(2);
        movimiento.setCantidad(movimiento.getCantidad()*(-1));
        movimiento.setTipooperacionByTipooperacion(tipooperacion);
        movimientoRepository.save(movimiento);
        MovimientoEntity movimientoinverso = new MovimientoEntity();
        movimientoinverso.setFecha(movimiento.getFecha());
        movimientoinverso.setTipooperacionByTipooperacion(movimiento.getTipooperacionByTipooperacion());
        movimientoinverso.setDescripcion(movimiento.getDescripcion());
        movimientoinverso.setCuentaByCuentaorigen(movimiento.getCuentaByCuentadestinatario());
        movimientoinverso.setCuentaByCuentadestinatario(movimiento.getCuentaByCuentaorigen());
        movimientoinverso.setCantidad(movimiento.getCantidad()*(-1));
        movimientoRepository.save(movimientoinverso);
        CuentaEntity origen = movimiento.getCuentaByCuentaorigen();
        origen.setSaldoactual(origen.getSaldoactual()+movimiento.getCantidad());
        CuentaEntity destino = movimiento.getCuentaByCuentadestinatario();
        destino.setSaldoactual(destino.getSaldoactual()+movimientoinverso.getCantidad());
        cuentasRepository.save(origen);
        cuentasRepository.save(destino);
        return "redirect:/";
    }
}