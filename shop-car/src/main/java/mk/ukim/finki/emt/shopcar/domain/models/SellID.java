package mk.ukim.finki.emt.shopcar.domain.models;
import lombok.NonNull;
import mk.ukim.finki.emt.sharedkernel.domain.base.DomainObjectId;


public class SellID extends DomainObjectId {

    private SellID() {
        super(SellID.randomId(SellID.class).getId());
    }

    public SellID(@NonNull String uuid) {
        super(uuid);
    }

    public static SellID of(String uuid) {
        SellID id = new SellID(uuid);
        return id;
    }


}
