package mk.ukim.finki.emt.shopcar.service.impl;

import lombok.AllArgsConstructor;
import mk.ukim.finki.emt.shopcar.domain.models.Sell;
import mk.ukim.finki.emt.shopcar.domain.models.SellID;
import mk.ukim.finki.emt.shopcar.repository.SellRepository;
import mk.ukim.finki.emt.shopcar.service.SellService;
import mk.ukim.finki.emt.shopcar.service.forms.SellForm;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;


@Service
@Transactional
@AllArgsConstructor
public class SellServiceImpl implements SellService {

    private final SellRepository sellRepository;

    //Data for new sell
    private Sell toDomainObject(SellForm sellForm) throws ParseException {
        var sell = new Sell(sellForm.getCarPrice(), sellForm.getCarId(), sellForm.getUserId(), sellForm.getSellerId());
        return sell;
    }

    //Sold new car
    @Override
    public Optional<SellID> sellCar(SellForm sellForm) throws ParseException {
        var sell = sellRepository.saveAndFlush(toDomainObject(sellForm));
        return Optional.of(sell.getId());
    }

    //Find sold car by id
    @Override
    public Optional<Sell> findById(SellID sellID) {
        return sellRepository.findById(sellID);
    }


    //All sold cars
    @Override
    public List<Sell> findAll() {
        return this.sellRepository.findAll();
    }

    //Delete sold car
    @Override
    public void deleteById(SellID sellID) {
        this.sellRepository.deleteById(sellID);
    }
}
