package mk.ukim.finki.emt.shopcar.domain.models.valueobjects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import mk.ukim.finki.emt.sharedkernel.domain.base.ValueObject;
import mk.ukim.finki.emt.sharedkernel.domain.financial.Money;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;

public class Car implements ValueObject {

    private final String brand;

    private final CarId id;

    private final String yearProduction;

    private final Money price;

    private Car() {
        this.id = CarId.randomId(CarId.class);
        this.yearProduction = null;
        this.price = null;
        this.brand = null;
    }

    @JsonCreator
    public Car(@JsonProperty("id")CarId id,
               @JsonProperty("brand")String brand,
               @JsonProperty("yearProduction")String yearProduction,
               @JsonProperty("carPrice") Money price) {
        this.price = price;
        this.id = id;
        this.yearProduction = yearProduction;
        this.brand = brand;
    }


}
