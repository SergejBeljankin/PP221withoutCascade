package hiber.dao;

import hiber.model.Car;

import java.util.List;

public interface CarDao {
   void add(Car car);
   List<Car> listCar();
   List<Car> findCar(String name, String lastName);
}
