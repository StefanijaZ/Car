package mk.ukim.finki.emt.servicecar.domain.valueobjects;

import mk.ukim.finki.emt.sharedkernel.domain.base.DomainObjectId;

import javax.persistence.Embeddable;


@Embeddable
public class MechanicId extends DomainObjectId {
    private MechanicId() {
        super(MechanicId.randomId(MechanicId.class).getId());
    }

    public MechanicId(String uuid) {
        super(uuid);
    }
}
