package es.taw.junio2023.Controller;

import es.taw.junio2023.dao.AsignaturaRepository;
import es.taw.junio2023.dao.CentrosRepository;
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

import javax.persistence.criteria.CriteriaBuilder;
import java.util.ArrayList;
import java.util.List;

@Controller
public class CentroController {

    @Autowired
    protected CentrosRepository centrosRepository;


    @Autowired
    protected TitulacionRepository titulacionRepository;

    @Autowired
    protected AsignaturaRepository asignaturaRepository;

    @GetMapping("/")
    public String doListarCentros(Model model){
        List<CentroEntity> centros = centrosRepository.findAll();
        model.addAttribute("centros", centros);
        model.addAttribute("centroSeleccionado", new CentroEntity());
        return "listarCentros";
    }

    @GetMapping("/titulaciones")
    public String doEnviar(@RequestParam("idcentro") Short id, Model model) {
        List<TitulacionEntity> titulaciones = titulacionRepository.buscarTitulacionPorCentro(id);
        model.addAttribute("titulaciones", titulaciones);
        return "listarTitulaciones";
    }

    @GetMapping("/editar")
    public String doEditar(@RequestParam("idtitulacion") Short id, Model model) {
        TitulacionEntity titulacion = titulacionRepository.findById(id).orElse(null);
        List<AsignaturaEntity> asignaturas = asignaturaRepository.findAll();
        model.addAttribute("titulacion", titulacion);
        model.addAttribute("asignaturas", asignaturas);
        return "editarTitulacion";
    }

    @PostMapping("/guardar")
    public String doGuardar(@ModelAttribute("titulacion") TitulacionEntity titulacionform, Model model) {
        TitulacionEntity titulacion = titulacionRepository.findById(titulacionform.getIdtitulacion()).orElse(null);
        titulacion.setNombre(titulacionform.getNombre());
        titulacionRepository.save(titulacion);
        return "redirect:/titulaciones?idtitulacion=" + titulacionform.getIdtitulacion();
    }



}