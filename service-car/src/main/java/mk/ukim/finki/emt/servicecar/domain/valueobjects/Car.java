package mk.ukim.finki.emt.servicecar.domain.valueobjects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import mk.ukim.finki.emt.sharedkernel.domain.base.ValueObject;
import mk.ukim.finki.emt.sharedkernel.domain.financial.Currency;
import mk.ukim.finki.emt.sharedkernel.domain.financial.Money;

import java.util.Date;

@Getter
public class Car implements ValueObject {

    private final CarId id;

    private final String brand;

    private final Date yearProduction;

    private final Money price;

    private Car(Date yearProduction) {
        this.yearProduction = yearProduction;
        this.id=CarId.randomId(CarId.class);
        this.brand= "";
        this.price = Money.valueOf(Currency.MKD,0);
    }

    @JsonCreator
    public Car(@JsonProperty("id") CarId id,
                   @JsonProperty("brand") String brand,
                   @JsonProperty("yearProduction") Date yearProduction,
                   @JsonProperty("price") Money price) {
        this.id = id;
        this.brand = brand;
        this.yearProduction = yearProduction;
        this.price = price;
    }
}
