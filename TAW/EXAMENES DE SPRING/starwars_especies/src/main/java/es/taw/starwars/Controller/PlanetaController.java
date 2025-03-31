package es.taw.starwars.Controller;


import es.taw.starwars.dao.EspecieRepository;
import es.taw.starwars.dao.FamiliaRepository;
import es.taw.starwars.dao.PlanetaRepository;
import es.taw.starwars.entity.Especie;
import es.taw.starwars.entity.FamiliaEspecie;
import es.taw.starwars.entity.Planeta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class PlanetaController {

    @Autowired
    protected PlanetaRepository planetaRepository;

    @Autowired
    protected EspecieRepository especieRepository;

    @Autowired
    protected FamiliaRepository familiaRepository;

   @GetMapping("/")
    public String doListar(Model model) {
        List<Planeta> plist = planetaRepository.findAll();
        model.addAttribute("ListaPlanetas", plist);
        return "planetas";
    }

    @GetMapping("/editar/")
    public String doEspecie(@RequestParam("idEspecie") Integer idEspecie, Model model){
        Especie especie = especieRepository.findById(idEspecie).orElse(null);
        model.addAttribute("especie", especie);

        List<FamiliaEspecie> listaespecies = familiaRepository.findAll();
        model.addAttribute("familias", listaespecies);

        return "especie";
    }
}
