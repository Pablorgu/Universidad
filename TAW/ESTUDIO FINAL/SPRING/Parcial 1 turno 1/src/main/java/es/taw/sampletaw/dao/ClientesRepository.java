package es.taw.sampletaw.dao;

import es.taw.sampletaw.entity.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientesRepository extends JpaRepository<ClienteEntity, Integer> {
}
