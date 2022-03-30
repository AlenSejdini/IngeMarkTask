package com.example.demo.product;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class ProductConfig {

    @Bean
    CommandLineRunner commandLineRunner(ProductRepository repository){
        return args -> {
            Product keyboard = new Product(
                "keychron k3","1234567890", "slim key borad", 750.00, 100.00, true
            );

            Product mouse = new Product(
                    "mx master", "0123456789", "main stream but amazing", 600.00, 92.00, true
            );


            repository.saveAll(
                    List.of(keyboard,mouse)
            );
        };
    }
}
