package mk.ukim.finki.emt.user.domain.models;

import lombok.NonNull;
import mk.ukim.finki.emt.sharedkernel.domain.base.DomainObjectId;

public class RoleId extends DomainObjectId {

    private RoleId() {
        super(RoleId.randomId(RoleId.class).getId());
    }

    protected RoleId(@NonNull String uuid) {
        super(uuid);
    }

    public static RoleId of(String uuid) {
        RoleId id = new RoleId(uuid);
        return id;
    }
}
