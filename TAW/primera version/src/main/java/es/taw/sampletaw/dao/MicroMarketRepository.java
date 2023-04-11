package es.taw.sampletaw.dao;

import es.taw.sampletaw.entity.MicroMarket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MicroMarketRepository extends JpaRepository<MicroMarket, String> {
}
