package mk.ukim.finki.emt.servicecar.domain.model;

import lombok.NonNull;
import mk.ukim.finki.emt.sharedkernel.domain.base.DomainObjectId;

public class ServiceId extends DomainObjectId {


    private ServiceId() {
        super(ServiceId.randomId(ServiceId.class).getId());
    }

    public ServiceId(@NonNull String uuid) {
        super(uuid);
    }

    public static ServiceId of(String uuid) {
        ServiceId id = new ServiceId(uuid);
        return id;
    }

}
