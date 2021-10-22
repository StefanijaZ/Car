package mk.ukim.finki.emt.shopcar.xport.rest;

import lombok.AllArgsConstructor;
import mk.ukim.finki.emt.shopcar.domain.models.Sell;
import mk.ukim.finki.emt.shopcar.domain.models.SellID;
import mk.ukim.finki.emt.shopcar.domain.models.valueobjects.UserId;
import mk.ukim.finki.emt.shopcar.service.SellService;
import mk.ukim.finki.emt.shopcar.service.forms.SellForm;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.stream.Collectors;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/sold")
@AllArgsConstructor
public class SellController {

    private final SellService sellService;

    //User cars
    @GetMapping("/{userId}")
    public List<Sell> getCarsById(@PathVariable UserId userId) {
        return sellService.findAll().stream().filter(x->x.getUserId().getId().compareTo(userId.getId()) == 0).collect(Collectors.toList());
    }

    //All sold cars
    @GetMapping
    public List<Sell> getAll() {
        return sellService.findAll();
    }


    //Delete sold car
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteById(@PathVariable String id) {
        this.sellService.deleteById(SellID.of(id));
        if(this.sellService.findById(SellID.of(id)).isEmpty()) return ResponseEntity.ok().build();
        return ResponseEntity.badRequest().build();
    }

    //new sell
    @PostMapping("/sell")
    public ResponseEntity sellCar(@RequestBody SellForm sellForm) throws ParseException {
        return this.sellService.sellCar(sellForm)
                .map(rentId -> ResponseEntity.ok().body(rentId))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }


}
