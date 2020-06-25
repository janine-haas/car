package at.technikumwien.carwebapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// see http://localhost:8081/resources/persons
// see http://localhost:8081/resources/persons/1

@RestController
@RequestMapping("resources/cars")
public class CarRessource {
    @Autowired
    private CarRepository carRepository;

    @GetMapping
    public List<Car> retrieveAll() {
        return carRepository.findAll();
    }
}
