package mk.ukim.finki.emt.shopcar.domain.models;

import lombok.Getter;
import mk.ukim.finki.emt.sharedkernel.domain.base.AbstractEntity;
import mk.ukim.finki.emt.sharedkernel.domain.financial.Money;
import mk.ukim.finki.emt.shopcar.domain.models.valueobjects.CarId;
import mk.ukim.finki.emt.shopcar.domain.models.valueobjects.UserId;

import javax.persistence.*;

@Entity
@Table(name="sold")
@Getter
public class Sell extends AbstractEntity<SellID> {

    @AttributeOverrides({@AttributeOverride(name = "amount", column =
    @Column(name = "price")), @AttributeOverride(name = "currency", column =
    @Column(name = "price_currency"))})
    private Money carPrice;

    @AttributeOverride(name="id", column = @Column(name="car_id", nullable = false))
    private CarId carId;

    @AttributeOverride(name="id", column = @Column(name="user_id", nullable = false))
    private UserId userId;

    @AttributeOverride(name="id", column = @Column(name="seller_id", nullable = false))
    private UserId sellerId;

    private Sell() {
        super(SellID.randomId(SellID.class));
    }

    public Sell(Money carPrice, CarId carId, UserId userId, UserId sellerId) {
        super(SellID.randomId(SellID.class));
        this.carPrice = carPrice;
        this.carId = carId;
        this.userId = userId;
        this.sellerId = sellerId;
    }

}