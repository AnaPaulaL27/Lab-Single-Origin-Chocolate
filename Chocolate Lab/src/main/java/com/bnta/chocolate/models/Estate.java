package com.bnta.chocolate.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "estates")
public class Estate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private String name;

    @Column
    private String country;

    @OneToMany(mappedBy = "estate")
    @JsonIgnoreProperties({"estate"})
    private List<Chocolate> chocolates;

    //Constructors (2)

    //(1) - args
    public Estate(String name, String country) {
        this.name = name;
        this.country = country;
        this.chocolates = new ArrayList<Chocolate>();
    }

    //(2)- No args
    public Estate() {
    }


    //Getters + Setters

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
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

    public List<Chocolate> getChocolates() {
        return chocolates;
    }

    public void setChocolates(List<Chocolate> chocolates) {
        this.chocolates = chocolates;
    }

}