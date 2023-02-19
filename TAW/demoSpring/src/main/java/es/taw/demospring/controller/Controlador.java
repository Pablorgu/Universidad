package es.taw.demospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Controlador {

    @GetMapping("/")
    public String doHola () {
        return "hola";
    }

    @GetMapping("/sumar")
    public String doSumar (@RequestParam("op1") Double operando1, @RequestParam("op2") Double operando2) {
        return "hola";
    }

}
