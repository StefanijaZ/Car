package mk.ukim.finki.emt.carcatalog.xport.rest;


import lombok.AllArgsConstructor;
import mk.ukim.finki.emt.carcatalog.domain.models.Car;
import mk.ukim.finki.emt.carcatalog.domain.models.CarID;
import mk.ukim.finki.emt.carcatalog.service.CarService;
import mk.ukim.finki.emt.carcatalog.service.form.CarForm;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/car")
@AllArgsConstructor
public class CarController {
    private final CarService carService;

    @GetMapping
    public List<Car> getAll() {
        return carService.findAll();
    }


    @PostMapping("/add")
    public ResponseEntity<CarID> add(@RequestBody CarForm carForm) {
        return this.carService.importCar(carForm)
                .map(carTypeId -> ResponseEntity.ok().body(carTypeId))
                .orElseGet(() -> ResponseEntity.badRequest().build());

    }


}
