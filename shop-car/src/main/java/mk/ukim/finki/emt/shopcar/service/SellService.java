package mk.ukim.finki.emt.shopcar.service;

import mk.ukim.finki.emt.sharedkernel.domain.financial.Money;
import mk.ukim.finki.emt.shopcar.domain.models.Sell;
import mk.ukim.finki.emt.shopcar.domain.models.SellID;
import mk.ukim.finki.emt.shopcar.service.forms.SellForm;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface SellService {

    Optional<SellID> sellCar(SellForm sellForm) throws ParseException;
    Optional<Sell> findById(SellID sellID);
    List<Sell> findAll();
    void deleteById(SellID sellID);
}
