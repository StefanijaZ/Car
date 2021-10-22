package mk.ukim.finki.emt.carcatalog.domain.models;

import lombok.NonNull;
import mk.ukim.finki.emt.sharedkernel.domain.base.DomainObjectId;

public class CarID extends DomainObjectId {

    private CarID() {
        super(CarID.randomId(CarID.class).getId());
    }

    protected CarID(@NonNull String uuid) {
        super(uuid);
    }

    public static CarID of(String uuid) {
        CarID id = new CarID(uuid);
        return id;
    }



}
