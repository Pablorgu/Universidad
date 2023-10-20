package es.taw.sampletaw.dao;

import es.taw.sampletaw.entity.DiscountCode;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiscountCodeRepository extends JpaRepository<DiscountCode, String> {
}
