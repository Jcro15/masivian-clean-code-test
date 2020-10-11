package edu.eci.masivianTest.persistence;
import edu.eci.masivianTest.model.Roulette;
import org.springframework.data.repository.CrudRepository;
public interface RouletteRepository extends CrudRepository<Roulette,Long> {
}