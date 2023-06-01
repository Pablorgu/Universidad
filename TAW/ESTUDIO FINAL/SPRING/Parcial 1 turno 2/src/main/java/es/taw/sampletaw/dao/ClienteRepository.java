package es.taw.sampletaw.dao;

import es.taw.sampletaw.entity.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.criteria.CriteriaBuilder;

public interface ClienteRepository extends JpaRepository<ClienteEntity, Integer> {
}
