package es.taw.starwars.Controller;

import es.taw.starwars.dao.EspecieRepository;
import es.taw.starwars.dao.FamiliaEspecieRepository;
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
public class PlanetaController {

    @Autowired
    protected PlanetaRepository planetaRepository;

    @Autowired
    protected EspecieRepository especieRepository;

    @Autowired
    protected FamiliaEspecieRepository familiaEspecieRepository;

    @GetMapping("/")
    public String doListar (Model model) {
        List<Planeta> planetas = this.planetaRepository.findAll();
        Filtro filtro = new Filtro();
        List<String> climas= this.planetaRepository.buscarClimas();
        model.addAttribute("clima", climas);
        model.addAttribute("filtro", filtro);
        model.addAttribute("planetas", planetas);
        return "planetas";
    }

    @GetMapping("/filtrar")
    public String doFiltrar(@ModelAttribute("filtro") Filtro filtro, Model model){
        List<Planeta> planetas = this.planetaRepository.buscarPlanetasPorClima(filtro.getClima());
        model.addAttribute("clima", this.planetaRepository.buscarClimas());
        model.addAttribute("filtro", filtro);
        model.addAttribute("planetas", planetas);
        return "planetas";
    }

    @GetMapping("/especie")
    public String doEspecie(@RequestParam("id") Integer id, Model model) {
        Especie especie = especieRepository.findById(id).orElse(null);
        model.addAttribute("Especie", especie);
        List<FamiliaEspecie> familias = familiaEspecieRepository.findAll();
        model.addAttribute("familias", familias);
        return "especie";
    }

    @PostMapping("/guardar")
    public String doGuardar(@ModelAttribute("Especie") Especie especieform, Model model) {
        Especie especie = especieRepository.findById(especieform.getEspecieId()).orElse(null);
        especie.setEspecie(especieform.getEspecie());
        especie.setPesoMedio(especieform.getPesoMedio());
        especie.setEsperanzaVida(especieform.getEsperanzaVida());
        especie.setIdioma(especieform.getIdioma());
        especie.setClasificacion(especieform.getClasificacion());
        especieRepository.save(especie);
        return "redirect:/";
    }
}
