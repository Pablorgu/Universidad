package es.taw.junio2023.Controller;

import es.taw.junio2023.dao.AsignaturaRepository;
import es.taw.junio2023.dao.CentroRepository;
import es.taw.junio2023.dao.TitulacionRepository;
import es.taw.junio2023.entity.AsignaturaEntity;
import es.taw.junio2023.entity.CentroEntity;
import es.taw.junio2023.entity.TitulacionEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@Controller
public class CentroController {

    @Autowired
    CentroRepository centroRepository;

    @Autowired
    TitulacionRepository titulacionRepository;

    @Autowired
    AsignaturaRepository asignaturaRepository;

    @GetMapping("/")
    public String doListar(Model model){
        List<CentroEntity> centros = centroRepository.findAll();
        model.addAttribute("centroSeleccionado", new CentroEntity());
        model.addAttribute("centros", centros);
        return "listarCentros";
    }

    @GetMapping("/titulacion")
    public String doTitulacion(@ModelAttribute("centroSeleccionado") CentroEntity centroSeleccionado, Model model) {
        List<TitulacionEntity> titulaciones = titulacionRepository.buscarTitulacionPorCentro(centroSeleccionado.getIdcentro());
        model.addAttribute("titulaciones", titulaciones);
        return "listarTitulaciones";
    }

    @GetMapping("/editar")
    public String doEditar(@RequestParam("id") Short idTitulacion, Model model) {
        TitulacionEntity titulacion = titulacionRepository.findById(idTitulacion).orElse(null);
        model.addAttribute("titulacion", titulacion);
        List<AsignaturaEntity> asignaturas = asignaturaRepository.buscarAsignaturas();
        model.addAttribute("asignaturas", asignaturas);
        return "editarTitulacion";
    }

    @PostMapping("/guardar")
    public String doGuardar(@ModelAttribute("titulacion") TitulacionEntity titulacionform, Model model) {
        TitulacionEntity titulacion = titulacionRepository.findById(titulacionform.getIdtitulacion()).orElse(null);
        List<AsignaturaEntity> asignaturas = asignaturaRepository.findAll();
        titulacion.setNombre(titulacionform.getNombre());
        TitulacionEntity titulacionantigua = titulacion;
        for(AsignaturaEntity a: asignaturas){
            if(titulacionantigua.getAsignaturaByAsignatura().contains(a) && !titulacionform.getAsignaturaByAsignatura().contains(a)) {
                List<TitulacionEntity> titulaciones = a.getTitulacionByIdtitulacion();
                titulaciones.remove(titulacionantigua);
                a.settitulacionByIdtitulacion(titulaciones);
                asignaturaRepository.save(a);
            } else if(!titulacionantigua.getAsignaturaByAsignatura().contains(a) && titulacionform.getAsignaturaByAsignatura().contains(a)) {
                List<TitulacionEntity> titulaciones = a.getTitulacionByIdtitulacion();
                titulaciones.add(titulacion);
                a.settitulacionByIdtitulacion(titulaciones);
                asignaturaRepository.save(a);
            }
        }
        titulacion.setAsignaturaByAsignatura(titulacionform.getAsignaturaByAsignatura());
        titulacionRepository.save(titulacion);
        return "redirect:titulacion?idcentro=" + titulacion.getCentroByCentro().getIdcentro();
    }
}
