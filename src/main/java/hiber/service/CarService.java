package hiber.service;

import hiber.model.Car;


import java.util.List;

public interface CarService {
    void add(Car car);
    List<Car> listCar();
    List<Car> findCar(String firstName, String lastName);
}
