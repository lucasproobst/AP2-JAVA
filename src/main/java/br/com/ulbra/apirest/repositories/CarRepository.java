package br.com.ulbra.apirest.repositories;

import br.com.ulbra.apirest.models.Car;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
public class CarRepository {
    private List<Car> lista = new ArrayList<>();

    public CarRepository() {
        lista.add(new Car(1, "Toyota", "Corolla", 2020));
        lista.add(new Car(2, "Honda", "Civic", 2019));
        lista.add(new Car(3, "Ford", "Focus", 2018));
    }

    public List<Car> getCars() {
        return lista;
    }

    public Car getCar(int id) {
        return lista
                .stream()
                .filter(item -> Objects.equals(item.getId(), id))
                .findFirst()
                .orElseThrow();
    }

    public Car createCar(Car car) {
        lista.add(car);
        return car;
    }

    public void deleteCar(int id) {
        Car car = lista
                .stream()
                .filter(item -> Objects.equals(item.getId(), id))
                .findFirst()
                .orElseThrow();

        lista.remove(car);
    }

    public Car updateCar(int id, Car car) {
        Car existingCar = lista
                .stream()
                .filter(item -> Objects.equals(item.getId(), id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Car not found with id " + id));

        existingCar.setBrand(car.getBrand());
        existingCar.setModel(car.getModel());
        existingCar.setYear(car.getYear());
        existingCar.setColor(car.getColor());
        existingCar.setPrice(car.getPrice());

        return existingCar;
    }
}
