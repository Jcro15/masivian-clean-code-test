package edu.eci.masivianTest.controllers;

import edu.eci.masivianTest.exceptions.RouletteNotFoundException;
import edu.eci.masivianTest.exceptions.RouletteRestrictionsException;
import edu.eci.masivianTest.model.Bet;
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
        catch (RouletteNotFoundException rouletteNotFoundException){

            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping(path = "/{rouletteId}/bets")
    public ResponseEntity<?>addBet(@PathVariable Long rouletteId,@RequestHeader("userId") Long userId,@RequestBody Bet bet) {
        try {
            bet.setUserId(userId);
            rouletteServices.addBetToRoulette(bet, rouletteId);

            return new ResponseEntity<>(HttpStatus.OK);
        } catch (RouletteNotFoundException rouletteNotFoundException) {

            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (RouletteRestrictionsException rouletteRestrictionsException) {

            return new ResponseEntity<>(rouletteRestrictionsException.getMessage(),HttpStatus.CONFLICT);
        }
    }
    @PatchMapping(path = "/{rouletteId}/close")
    public ResponseEntity<?>closeRoulette(@PathVariable Long rouletteId){
        try{

            return new ResponseEntity<>(rouletteServices.closeRoulette(rouletteId),HttpStatus.OK);
        }
        catch (RouletteNotFoundException rouletteNotFoundException){

            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping
    public ResponseEntity<?>getAllRoulettes(){
        return new ResponseEntity<>(rouletteServices.getAllRoulettes(),HttpStatus.OK);
    }
}
