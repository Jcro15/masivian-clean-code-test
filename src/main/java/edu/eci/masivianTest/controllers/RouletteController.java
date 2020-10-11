package edu.eci.masivianTest.controllers;

import edu.eci.masivianTest.exceptions.RouletteException;
import edu.eci.masivianTest.services.RouletteServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/roulettes")
public class RouletteController {
    @Autowired
    private RouletteServices rouletteServices;
    @PostMapping
    public ResponseEntity<?>createRoulette(){
        Long rouletteId = rouletteServices.createRoulette();

        return new ResponseEntity<>(rouletteId , HttpStatus.CREATED);
    }
    @PatchMapping(path = "/{rouletteId}/open")
    public ResponseEntity<?>openRoulette(@PathVariable Long rouletteId){
        try{
            rouletteServices.openRoulette(rouletteId);

            return new ResponseEntity<>(HttpStatus.OK);
        }
        catch (RouletteException rouletteException){

            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
