package mk.ukim.finki.emt.servicecar.service.forms;

import com.sun.istack.NotNull;
import lombok.Data;
import mk.ukim.finki.emt.sharedkernel.domain.financial.Currency;


//Dto for service
@Data
public class ServiceForm {

    @NotNull
    private Currency currency;

}
