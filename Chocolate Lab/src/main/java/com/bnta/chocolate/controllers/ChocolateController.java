package com.bnta.chocolate.controllers;


import com.bnta.chocolate.models.Chocolate;
import com.bnta.chocolate.repositories.ChocolateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.annotation.Repeatable;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("chocolates") //localhost8080/chocolates
public class ChocolateController {

    @Autowired
    ChocolateRepository chocolateRepository;

//INDEX
//  get for  returning a list of all chocolates on route localhost:8080/chocolates

//    @GetMapping
//    public ResponseEntity<List<Chocolate>> getAllChocolates() {
//        return new ResponseEntity<>(chocolateRepository.findAll(), HttpStatus.OK);
//
//    }
    //get for the advanced query
//    @GetMapping - localhost:8080/chocolates?cocoaPercentage=69
//    public ResponseEntity<List<Chocolate>>getAllChocolatesOfCocoaPercentage(
//            @RequestParam(name= "cocoaPercentage") Integer cocoaPercentage ){
//
//        return new ResponseEntity<>(chocolateRepository.findByCocoaPercentageGreaterThan(cocoaPercentage)
//                , HttpStatus.OK);


        //Note that having the above get requests causes ambiguous mapping, so have to combine them together
        //each works by themselves by together causes issues
//}

    //So we combine into one which:

//    Handles following:
//    * GET /chocolates
//    * GET /chocolates?cocoaPercentage=69

    @GetMapping
    public ResponseEntity<List<Chocolate>> getAllChocolatesAndFilters(
            @RequestParam(required = false, name = "cocoaPercentage") Integer cocoaPercentage
    ){
//        GET /chocolates?cocoaPercentage=69
        if(cocoaPercentage != null){
            return new ResponseEntity<>(chocolateRepository.findByCocoaPercentageGreaterThan(cocoaPercentage), HttpStatus.OK);
        }
//        GET /chocolates
        return new ResponseEntity<>(chocolateRepository.findAll(), HttpStatus.OK);
    }

    //SHOW route
    @GetMapping(value = "/{id}") //localhost8080/chocolates/1
    //method to display individual chocolate
    public ResponseEntity<Optional<Chocolate>> getChocolate(@PathVariable Long id ){
        return new ResponseEntity<>(chocolateRepository.findById(id), HttpStatus.OK);
    }

    //POST route
    // method to create new chocolate

    @PostMapping // localhost:8080/chocolates
    public  ResponseEntity<Chocolate>createChocolate(@RequestBody Chocolate newChocolate){

        chocolateRepository.save(newChocolate);

        return new ResponseEntity<>(newChocolate, HttpStatus.CREATED);
    }

}
