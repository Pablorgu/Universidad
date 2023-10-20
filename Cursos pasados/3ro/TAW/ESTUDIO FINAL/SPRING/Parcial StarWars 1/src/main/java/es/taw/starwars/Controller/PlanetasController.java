package es.taw.starwars.Controller;

import es.taw.starwars.dao.EspecieRepository;
import es.taw.starwars.dao.FamiliaRepository;
import es.taw.starwars.dao.PlanetaRepository;
import es.taw.starwars.entity.Especie;
import es.taw.starwars.entity.FamiliaEspecie;
import es.taw.starwars.entity.Planeta;
import es.taw.starwars.ui.Filtro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class PlanetasController {

    @Autowired
    PlanetaRepository planetaRepository;

    @Autowired
    EspecieRepository especieRepository;

    @Autowired
    FamiliaRepository familiaRepository;

    @GetMapping("/")
    public String doListar (Model model) {
        List<Planeta> planetas = this.planetaRepository.findAll();
        Filtro filtro = new Filtro();
        List<String> climas= this.planetaRepository.buscarClimas();
        model.addAttribute("climas", climas);
        model.addAttribute("filtro", filtro);
        model.addAttribute("planetas", planetas);
        return "planetas";
    }

    @GetMapping("/filtrar")
    public String foFiltrar(@ModelAttribute("filtro") Filtro filtro, Model model){
        List<Planeta> planetas = this.planetaRepository.buscarPorClima(filtro.getClima());
        model.addAttribute("climas", this.planetaRepository.buscarClimas());
        model.addAttribute("filtro", filtro);
        model.addAttribute("planetas", planetas);
        return "planetas";
    }

    @GetMapping("/editarespecie")
    public String doEditar (@RequestParam("id") Integer id, Model model) {
        Especie especie= especieRepository.findById(id).orElse(null);
        List<FamiliaEspecie> familias = this.familiaRepository.findAll();
        model.addAttribute("familias", familias);
        model.addAttribute("Especie", especie);
        return "especie";
    }

    @PostMapping("/guardar")
    public String doGuardar (@ModelAttribute("especie") Especie especie, Model model) {
        this.especieRepository.save(especie);
        return "redirect:/";
    }
}