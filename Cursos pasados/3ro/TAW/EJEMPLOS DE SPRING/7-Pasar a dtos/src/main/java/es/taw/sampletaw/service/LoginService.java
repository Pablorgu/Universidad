package es.taw.sampletaw.service;

import es.taw.sampletaw.dao.AdministradorRepository;
import es.taw.sampletaw.dto.AdministradorDTO;
import es.taw.sampletaw.entity.Administrador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

@Service
public class LoginService {

    @Autowired
    protected AdministradorRepository administradorRepository;

    public AdministradorDTO doAutenticarUsuario (String user, String password) {
        Administrador admin = this.administradorRepository.autenticar(user, password);
        return (admin == null? null : admin.toDTO());
    }

}
