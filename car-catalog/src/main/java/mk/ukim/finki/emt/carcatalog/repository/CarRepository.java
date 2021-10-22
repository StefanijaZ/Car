package mk.ukim.finki.emt.carcatalog.repository;

import mk.ukim.finki.emt.carcatalog.domain.models.Car;
import mk.ukim.finki.emt.carcatalog.domain.models.CarID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, CarID> {


}
