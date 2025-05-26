
package br.com.ulbra.apirest.services;

import br.com.ulbra.apirest.models.Car;
import br.com.ulbra.apirest.repositories.CarRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {
    private CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public Car getCar(int id) {
        return this.carRepository.getCar(id);
    }

    public List<Car> getCars() {
        return this.carRepository.getCars();
    }

    public Car createCar(Car car) {
        return this.carRepository.createCar(car);
    }

    public void deleteCar(int id) {
        this.carRepository.deleteCar(id);
    }
}
