package com.bnta.chocolate.controllers;

import com.bnta.chocolate.models.Chocolate;
import com.bnta.chocolate.models.Estate;
import com.bnta.chocolate.repositories.EstateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("estates") //localhost8080/estates
public class EstateController {

    @Autowired
    EstateRepository estateRepository;

    //returning a list of all chocolates on route localhost:8080/estates
    @GetMapping
    public ResponseEntity<List<Estate>> getAllEstates(){
        return new ResponseEntity<>(estateRepository.findAll(), HttpStatus.OK);

    }

    //SHOW route
    @GetMapping(value = "/{id}") //localhost8080/estates/1
    //method to display individual chocolate
    public ResponseEntity<Optional<Estate>> getChocolate(@PathVariable Long id ){
        return new ResponseEntity<>(estateRepository.findById(id), HttpStatus.OK);
    }

    //POST route -
    // method to create new estate

    @PostMapping
    public  ResponseEntity<Estate>createChocolate(@RequestBody Estate newEstate){

        estateRepository.save(newEstate);
        return new ResponseEntity<>(newEstate, HttpStatus.CREATED);
    }


}
