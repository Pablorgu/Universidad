package es.taw.sampletaw.service;

import es.taw.sampletaw.dao.DiscountCodeRepository;
import es.taw.sampletaw.dto.DiscountCodeDTO;
import es.taw.sampletaw.entity.DiscountCode;
import es.taw.sampletaw.entity.MicroMarket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DiscountCodeService {

    @Autowired
    protected DiscountCodeRepository discountCodeRepository;

    public List<DiscountCodeDTO> listarCodigosDescuento () {
        List<DiscountCode> listadescuentos = this.discountCodeRepository.findAll();
        return this.listaEntidadesADTO(listadescuentos);
    }


    protected List<DiscountCodeDTO> listaEntidadesADTO (List<DiscountCode> lista) {
        ArrayList dtos = new ArrayList<DiscountCodeDTO>();

        lista.forEach((final DiscountCode discountCode) -> dtos.add(discountCode.toDTO()));

        return dtos;
    }
}
