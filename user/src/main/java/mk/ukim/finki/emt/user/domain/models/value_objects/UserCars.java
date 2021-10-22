package mk.ukim.finki.emt.user.domain.models.value_objects;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import mk.ukim.finki.emt.sharedkernel.domain.base.ValueObject;
import mk.ukim.finki.emt.user.domain.models.UserData;

import java.util.ArrayList;
import java.util.List;

@Getter
public class UserCars implements ValueObject {

    private final UserData userData;
    private final List<Sell> cars;

    private UserCars() {
        this.userData = null;
        this.cars = new ArrayList<>();
    }

    @JsonCreator
    public UserCars(@JsonProperty("userData") UserData userData,
                       @JsonProperty("car")List<Sell> cars) {
        this.userData = userData;
        this.cars = new ArrayList<>();
        this.cars.addAll(cars);
    }
}
