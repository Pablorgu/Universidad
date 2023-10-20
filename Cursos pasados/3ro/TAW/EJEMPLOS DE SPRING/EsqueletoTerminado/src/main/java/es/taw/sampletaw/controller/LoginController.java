package es.taw.sampletaw.controller;

import es.taw.sampletaw.dao.AdministradorRepository;
import es.taw.sampletaw.entity.Administrador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @Autowired
    protected AdministradorRepository administradorRepository;

    @GetMapping("/")
    public String doLogin() {
        return "login";
    }

    @PostMapping("/")
    public String doAutenticar (@RequestParam("usuario") String user,
                                @RequestParam("clave") String contrasena,
                                Model model, HttpSession session) {
        String urlTo = "redirect:/customer/";
        Administrador admin = this.administradorRepository.autenticar(user, contrasena);
        if (admin==null) {
            model.addAttribute("error", "Credenciales incorrectos");
            urlTo = "login";
        } else {
            session.setAttribute("admin", admin);
        }

        return urlTo;
    }

    @GetMapping ("/logout")
    public String doLogout (HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }
}
