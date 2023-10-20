package es.taw.starwars.Controller;

import es.taw.starwars.entity.FraseCelebre;
import es.taw.starwars.entity.Pelicula;
import es.taw.starwars.entity.Personaje;
import es.taw.starwars.repository.FrasesCelebresRepository;
import es.taw.starwars.repository.PeliculaRepository;
import es.taw.starwars.repository.PersonajesRepository;
import es.taw.starwars.ui.Filtro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Controller
public class FrasesCelebresController {

    @Autowired
    FrasesCelebresRepository fraseRepository;

    @Autowired
    PeliculaRepository peliculaRepository;

    @Autowired
    PersonajesRepository personajesRepository;


    @GetMapping("/")
    public String doListar(Model model) {
        return doFiltrar(null, model);
    }


    @PostMapping("/filtrar")
    public String doFiltrar(@ModelAttribute("filt") Filtro filtro, Model model) {
        List<FraseCelebre> frases;
        if(filtro==null || !filtro.getPelicula() && !filtro.getPersonaje()) {
            frases = fraseRepository.findAll();
            filtro= new Filtro();
        } else if (filtro.getPelicula() && filtro.getPersonaje()) {
            frases = fraseRepository.ordenarporpersonajeypeli();
        } else if (filtro.getPelicula()) {
            frases = fraseRepository.ordenarporpelicula();
        } else {
            frases = fraseRepository.ordenarporpersonaje();
        }
        model.addAttribute("ListaFrase", frases);
        model.addAttribute("filt", filtro);
        return "frases";
    }

    @GetMapping("/pelicula")
    public String doPelicula(Model model, @RequestParam("id") Integer id){
        Pelicula p = this.peliculaRepository.findById(id).orElse(null);
        List<Personaje> personajespeli = p.getPersonajeList();
        List<Personaje> personajes = personajesRepository.findAll();
        model.addAttribute("personajes", personajes);
        model.addAttribute("ListaPersonajes", personajespeli);
        model.addAttribute("peli", p);
        return "pelicula";
    }

    @PostMapping("/pelicula/guardar")
    public String doGuardar(@ModelAttribute("pelicula") Pelicula pelicula){
    this.peliculaRepository.save(pelicula);
    return "redirect:/";
    }
}