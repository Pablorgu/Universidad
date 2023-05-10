package es.taw.sampletaw.dao;

import es.taw.sampletaw.entity.Administrador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AdministradorRepository extends JpaRepository<Administrador, Integer> {

    @Query ("select a from Administrador a where a.email = :user and a.password = :password")
    public Administrador autenticar (@Param("user") String user, @Param ("password") String password);
}
