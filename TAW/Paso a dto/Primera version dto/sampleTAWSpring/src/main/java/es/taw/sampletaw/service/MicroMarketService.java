package es.taw.sampletaw.service;

import es.taw.sampletaw.dao.MicroMarketRepository;
import es.taw.sampletaw.dto.MicroMarketDTO;
import es.taw.sampletaw.entity.MicroMarket;
import es.taw.sampletaw.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MicroMarketService {

    @Autowired
    protected MicroMarketRepository microMarketRepository;

    public List<MicroMarketDTO> listarSupermercados () {
        List<MicroMarket> supermercados = this.microMarketRepository.findAll();
        return this.listaEntidadesADTO(supermercados);
    }

    protected List<MicroMarketDTO> listaEntidadesADTO (List<MicroMarket> lista) {
        ArrayList dtos = new ArrayList<MicroMarketDTO>();

        lista.forEach((final MicroMarket microMarket) -> dtos.add(microMarket.toDTO()));

        return dtos;
    }

}
