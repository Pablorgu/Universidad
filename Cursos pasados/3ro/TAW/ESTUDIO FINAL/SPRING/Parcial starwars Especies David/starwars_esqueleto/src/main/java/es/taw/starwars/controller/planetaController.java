package es.taw.starwars.controller;

import es.taw.starwars.entity.*;
import es.taw.starwars.repository.especieRepository;
import es.taw.starwars.repository.familiaEspecieRepository;
import es.taw.starwars.repository.personajeRepository;
import es.taw.starwars.repository.planetaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class planetaController {
    @Autowired
    protected planetaRepository planetaRepository;
    @Autowired
    protected especieRepository especieRepository;
    @Autowired
    protected familiaEspecieRepository familiaEspecieRepository;
    @Autowired
    protected personajeRepository personajeRepository;

    @GetMapping("/")
    public String doListar(Model model){
        return gestorfiltro(null,model);
    }
    @GetMapping("/editar")
    public String doEditar(@RequestParam("id")Integer id, Model model){
        Especie especie = especieRepository.findById(id).get();
        List<FamiliaEspecie> familiaEspecie = this.familiaEspecieRepository.findAll();
        List<Personaje> listapersonajes = this.personajeRepository.listaPersonajesPorEspecie(especie);
        model.addAttribute("listapersonajes",listapersonajes);
        model.addAttribute("especieat", especie);
        model.addAttribute("familiaEspecie",familiaEspecie);
        return "editar";
    }
    @PostMapping("/guardar")
    public String doGuardar(@ModelAttribute("especieat")Especie especie){
        this.especieRepository.save(especie);
        return "redirect:/";
    }

    @PostMapping ("/filtro")
    public String doFiltrar(@ModelAttribute("filtro")Filtro filtro, Model model){
        return gestorfiltro(filtro,model);
    }

    public String gestorfiltro(Filtro filtro, Model model){
        List<Planeta> listaplanetas = this.planetaRepository.findAll();
        List<String> listaclimas = new ArrayList<String>();
        for (Planeta p: listaplanetas){
            if(!listaclimas.contains(p.getClima()) && p.getClima() != null){
                listaclimas.add(p.getClima());
            }
        }
        if(filtro == null || filtro.getClima() == "") {
            filtro = new Filtro();
        }else{
            listaplanetas = this.planetaRepository.listaplaneta(filtro.getClima());
        }

        model.addAttribute("listaplanetas", listaplanetas);
        model.addAttribute("listaclimas", listaclimas);
        model.addAttribute("filtro", filtro);
        return "listar";
    }
}
