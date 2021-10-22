package mk.ukim.finki.emt.shopcar.domain.models.valueobjects;

import lombok.NonNull;
import mk.ukim.finki.emt.sharedkernel.domain.base.DomainObjectId;

public class CarId extends DomainObjectId {

    private CarId() {
        super(CarId.randomId(CarId.class).getId());
    }

    public CarId(@NonNull String uuid) {
        super(uuid);
    }
}
