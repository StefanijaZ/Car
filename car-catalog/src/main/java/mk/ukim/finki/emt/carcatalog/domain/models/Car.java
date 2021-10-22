package mk.ukim.finki.emt.carcatalog.domain.models;


import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import mk.ukim.finki.emt.sharedkernel.domain.base.AbstractEntity;
import mk.ukim.finki.emt.sharedkernel.domain.financial.Money;
import javax.persistence.*;


//Entity car
@Entity
@Table(name="car")
@Getter
public class Car extends AbstractEntity<CarID> {

    private String brand;

    private String yearProduction;

    @AttributeOverrides({@AttributeOverride(name = "amount", column =
    @Column(name = "price")), @AttributeOverride(name = "currency", column =
    @Column(name = "price_currency"))})
    private Money carPrice;
//
//    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
//    private List<Service> serviceList;

    private Car() {
        super(CarID.randomId(CarID.class));
    }

    public Car(String brand, String yearProduction, Money money) {
        super(CarID.randomId(CarID.class));
        this.brand = brand;
        this.yearProduction = yearProduction;
        this.carPrice = money;
    }


}
