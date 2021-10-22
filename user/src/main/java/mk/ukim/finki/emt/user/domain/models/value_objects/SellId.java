package mk.ukim.finki.emt.user.domain.models.value_objects;

import lombok.NonNull;
import mk.ukim.finki.emt.sharedkernel.domain.base.DomainObject;
import mk.ukim.finki.emt.sharedkernel.domain.base.DomainObjectId;

public class SellId extends DomainObjectId {
    private SellId() {
        super(SellId.randomId(SellId.class).getId());
    }

    public SellId(@NonNull String uuid) {
        super(uuid);
    }

    public static SellId of(String uuid) {
        SellId c = new SellId(uuid);
        return c;
    }
}
