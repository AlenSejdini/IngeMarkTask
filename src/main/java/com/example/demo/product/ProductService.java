package com.example.demo.product;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    public static double getEuros() {

        RestTemplate restTemplate = new RestTemplate();
        final String url = "https://api.hnb.hr/tecajn/v1?valuta=EUR";


        ResponseEntity<Object[]> responseEntity =
                restTemplate.getForEntity(url, Object[].class);

        Object[] objects = responseEntity.getBody();
        ObjectMapper mapper = new ObjectMapper();

        var data = Arrays.stream(objects)
                .map(object -> mapper.convertValue(object, EuroConverter.class))
                .map(EuroConverter::getSrednjiZaDevize)
                .collect(Collectors.toList());

        var value = Double.parseDouble(data.get(0).replace(',', '.'));
        return value;
    }

    //using an optional to check if the code is taken if is we have basic exception if not then we save it
    public void addNewProduct(Product product) {
        if (product.getCode().length() != 10) {
            throw new IllegalStateException("Product code length must be 10 characters.");
        }
        //dohvatiti iz gornnje metode zadnju vrijednost tcaja
        double kunaValue = getEuros();
        double euroPrice = Math.round((product.getPrice_hrk() / kunaValue) * 100.0) / 100.0;
        product.setPrice_eur(euroPrice);
        System.out.println(kunaValue);
        //uzet iz producta vrijednos u kunma i pomnoziti sa zadnjim tecajem
        //dodati to u product objekt i spremiti u bazu
        Optional<Product> productOptional = productRepository
                .findProductByCode(product.getCode());
        if (productOptional.isPresent()) {
            throw new IllegalStateException("Code has already been taken/used");
        }

        System.out.println(getEuros());
        productRepository.save(product);
    }

    public void deleteProduct(Long productId) {
        boolean exists = productRepository.existsById(productId);
        if (!exists) {
            throw new IllegalStateException(
                    "The product with " + productId + " does not exist");
        }
        productRepository.deleteById(productId);
    }

    //Used transactional because this makes it so I dont need any JPQL query and i can use getters and setters from Entity.
    @Transactional
    public void updateProduct(Long productId, String name, String description) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new IllegalStateException(
                        "Product with id " + productId + " does not exist"));
        if (name != null && name.length() > 0 & !Objects.equals(product.getName(), name)) {
            product.setName(name);
        }

        if (description != null && description.length() > 0 & !Objects.equals(product.getDescription(), description)) {
            product.setDescription(description);
        }

    }

}
