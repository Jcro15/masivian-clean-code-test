package edu.eci.masivianTest.controllers;

import edu.eci.masivianTest.services.RouletteServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/roulettes")
public class RouletteController {
    @Autowired
    private RouletteServices rouletteServices;
    @PostMapping
    public ResponseEntity<?>createRoulette(){
        Long rouletteId= rouletteServices.createRoulette();
        return new ResponseEntity<>(rouletteId , HttpStatus.CREATED);
    }

}
