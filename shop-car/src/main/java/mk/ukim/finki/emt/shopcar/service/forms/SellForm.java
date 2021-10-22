package mk.ukim.finki.emt.shopcar.service.forms;

import javax.validation.Valid;
import com.sun.istack.NotNull;
import lombok.Data;
import mk.ukim.finki.emt.sharedkernel.domain.financial.Money;
import mk.ukim.finki.emt.shopcar.domain.models.valueobjects.CarId;
import mk.ukim.finki.emt.shopcar.domain.models.valueobjects.UserId;

//Dto for sell a car
@Data
public class SellForm {

    @Valid
    @NotNull
    private CarId carId;

    @Valid
    @NotNull
    private UserId userId;

    @Valid
    @NotNull
    private Money carPrice;

    @Valid
    @NotNull
    private UserId sellerId;
}
