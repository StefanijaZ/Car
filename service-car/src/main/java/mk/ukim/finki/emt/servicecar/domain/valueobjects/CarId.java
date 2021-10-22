package mk.ukim.finki.emt.servicecar.domain.valueobjects;


import mk.ukim.finki.emt.servicecar.domain.model.ServiceId;
import mk.ukim.finki.emt.sharedkernel.domain.base.DomainObjectId;

import javax.persistence.Embeddable;

@Embeddable
public class CarId extends DomainObjectId {

    private CarId() {
        super(CarId.randomId(CarId.class).getId());
    }

    public CarId(String uuid) {
        super(uuid);
    }

}
