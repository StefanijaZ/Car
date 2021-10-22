package mk.ukim.finki.emt.carcatalog.service;

import mk.ukim.finki.emt.carcatalog.domain.exceptions.CarIdNotFoundException;
import mk.ukim.finki.emt.carcatalog.domain.models.Car;
import mk.ukim.finki.emt.carcatalog.domain.models.CarID;
import mk.ukim.finki.emt.carcatalog.service.form.CarForm;

import java.util.List;
import java.util.Optional;

public interface CarService {

    Optional<CarID> importCar(CarForm carForm);
    List<Car> findAll();
    Optional<Car> findById(CarID carID);
    void deleteCar(CarID carID) throws CarIdNotFoundException;
    void sellCar(CarID carID) throws CarIdNotFoundException;
}
