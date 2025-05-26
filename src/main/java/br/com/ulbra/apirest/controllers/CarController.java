
package br.com.ulbra.apirest.controllers;

import br.com.ulbra.apirest.models.Car;
import br.com.ulbra.apirest.repositories.CarRepository;
import br.com.ulbra.apirest.services.CarService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/cars")
public class CarController {
    private final CarRepository carRepository;
    private CarService carService;

    public CarController(CarService carService, CarRepository carRepository) {
        this.carService = carService;
        this.carRepository = carRepository;
    }

    @GetMapping
    public ResponseEntity<List<Car>> getCars() {
        return ResponseEntity.ok(this.carService.getCars());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Car> getCar(@PathVariable int id) {
        return ResponseEntity.ok(this.carService.getCar(id));
    }

    @PostMapping
    public ResponseEntity<Car> createCar(@RequestBody Car car) {
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(car.getId()).toUri();

        return ResponseEntity.created(uri).body(this.carService.createCar(car));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCar(@PathVariable int id) {
        this.carService.deleteCar(id);
        return ResponseEntity.noContent().build();
    }
}
