package com.example.demo.product;


import jakarta.persistence.*;

import javax.validation.constraints.Min;
import javax.validation.constraints.Size;


@Entity
@Table
public class Product {
    @Id
    @SequenceGenerator(
            name = "product_sequence",
            sequenceName = "product_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "product_sequence"

    )

    private Long id;
    @Column
    private String name;
    @Column
    @Size(min = 10, max = 10, message = "About Me must be 10 characters")
    private String code;
    @Column
    private String description;
    @Column
    @Min(value = 0)
    private Double price_hrk;
    @Column
    @Min(value = 0)
    private Double price_eur;
    @Column
    private Boolean is_available;

    public Product(Long id, String name, String code, String description, Double price_hrk, Double price_eur, Boolean is_available) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.description = description;
        this.price_hrk = price_hrk;
        this.price_eur = price_eur;
        this.is_available = is_available;
    }

    public Product() {
    }

    public Product(String name, String code, String description, Double price_hrk, Double price_eur, Boolean is_available) {
        this.name = name;
        this.code = code;
        this.description = description;
        this.price_hrk = price_hrk;
        this.price_eur = price_eur;
        this.is_available = is_available;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice_hrk() {
        return price_hrk;
    }

    public void setPrice_hrk(Double price_hrk) {
        this.price_hrk = price_hrk;
    }

    public Double getPrice_eur() {
        return price_eur;
    }

    public void setPrice_eur(Double price_eur) {
        this.price_eur = price_eur;
    }

    public Boolean getIs_available() {
        return is_available;
    }

    public void setIs_available(Boolean is_available) {
        this.is_available = is_available;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", description='" + description + '\'' +
                ", price_hrk=" + price_hrk +
                ", price_eur=" + price_eur +
                ", is_available=" + is_available +
                '}';
    }
}
