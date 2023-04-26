package es.taw.sampletaw.service;

import es.taw.sampletaw.dao.ProductRepository;
import es.taw.sampletaw.dto.ProductDTO;
import es.taw.sampletaw.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    protected ProductRepository productRepository;

    public List<ProductDTO> listarProductos () {
        List<Product> productList = this.productRepository.findAll();
        return this.listaEntidadesADTO(productList);
    }

    protected List<ProductDTO> listaEntidadesADTO (List<Product> lista) {
        ArrayList dtos = new ArrayList<ProductDTO>();

        lista.forEach((final Product producto) -> dtos.add(producto.toDTO()));

        return dtos;
    }

}
