package mk.ukim.finki.emt.user.domain.models.value_objects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import mk.ukim.finki.emt.sharedkernel.domain.base.ValueObject;
import mk.ukim.finki.emt.sharedkernel.domain.financial.Money;
import mk.ukim.finki.emt.user.domain.models.UserID;


@Getter
public class Sell implements ValueObject {

        private final SellId id;
        private final Money carPrice;

        private final CarId carId;

        private final UserID userID;

        private Sell() {
            this.id = SellId.randomId(SellId.class);
            this.carPrice = null;
            this.carId = null;
            this.userID = null;
        }

        @JsonCreator
        public Sell(@JsonProperty("id") SellId id,
                    @JsonProperty("carPrice") Money carPrice,
                    @JsonProperty("carId") CarId carId,
                    @JsonProperty("clientId")UserID userID) {
            this.id = id;
            this.carPrice = carPrice;
            this.carId = carId;
            this.userID = userID;
        }
}

