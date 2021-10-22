package mk.ukim.finki.emt.user.domain.models;

import lombok.NonNull;
import mk.ukim.finki.emt.sharedkernel.domain.base.DomainObjectId;

public class UserID extends DomainObjectId {
    private UserID() {
        super(UserID.randomId(UserID.class).getId());
    }

    public UserID(@NonNull String uuid) {
        super(uuid);
    }

    public static UserID of(String uuid) {
        UserID id = new UserID(uuid);
        return id;
    }
}
