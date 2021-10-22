package mk.ukim.finki.emt.carcatalog.service.impl;

import lombok.AllArgsConstructor;
import mk.ukim.finki.emt.carcatalog.domain.exceptions.CarIdNotFoundException;
import mk.ukim.finki.emt.carcatalog.domain.models.Car;
import mk.ukim.finki.emt.carcatalog.domain.models.CarID;
import mk.ukim.finki.emt.carcatalog.repository.CarRepository;
import mk.ukim.finki.emt.carcatalog.service.CarService;
import mk.ukim.finki.emt.carcatalog.service.form.CarForm;
import mk.ukim.finki.emt.sharedkernel.domain.financial.Currency;
import mk.ukim.finki.emt.sharedkernel.domain.financial.Money;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;


@Service
@Transactional
@AllArgsConstructor
public class CarServiceImpl implements CarService {
    private final CarRepository carRepository;


    //Import new car
    @Override
    public Optional<CarID> importCar(CarForm carForm) {
        Objects.requireNonNull(carForm,  "car form must not be null");
        var newCar = carRepository.saveAndFlush(toDomainObject(carForm));
        return Optional.of(newCar.getId());
    }

    //Data from car form
    private Car toDomainObject(CarForm carForm) {
        var car= new Car(carForm.getBrand(), carForm.getYearProduction(),
                new Money(Currency.valueOf(carForm.getCurrency()), carForm.getAmount()));
        return car;
    }

    //List all cars
    @Override
    public List<Car> findAll() {
        return carRepository.findAll();
    }

    //Find car by id
    @Override
    public Optional<Car> findById(CarID carID) {
        return carRepository.findById(carID);
    }


    //Delete car
    @Override
    public void deleteCar(CarID carID) throws CarIdNotFoundException {
        var car = this.carRepository.findById(carID).orElseThrow(CarIdNotFoundException::new);
        this.carRepository.delete(car);
    }

    //Sell car to user with role client
    @Override
    public void sellCar(CarID carID) throws CarIdNotFoundException {
        var car = this.carRepository.findById(carID).orElseThrow(CarIdNotFoundException::new);
        this.carRepository.delete(car);
    }
}
