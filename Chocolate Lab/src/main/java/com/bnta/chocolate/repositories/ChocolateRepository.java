package com.bnta.chocolate.repositories;

import com.bnta.chocolate.models.Chocolate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChocolateRepository extends JpaRepository<Chocolate, Long> {

    //    Create a simple derived query to list all Chocolate with 69% (you can choose the number) or higher cocoa content.
    //returning all chocolates  with cococa percentage 69% or higher.
    //this is the general derived query
    List<Chocolate> findByCocoaPercentageGreaterThan(int cocoaPercentage);
}

