package es.taw.sampletaw.dao;

import es.taw.sampletaw.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}