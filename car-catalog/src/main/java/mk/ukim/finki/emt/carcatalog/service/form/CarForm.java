package mk.ukim.finki.emt.carcatalog.service.form;


import com.sun.istack.NotNull;
import lombok.Data;

import javax.validation.Valid;


//Car Dto for new object
@Data
public class CarForm {

    @Valid
    @NotNull
    private String brand;

    @Valid
    @NotNull
    private String yearProduction;

    @Valid
    @NotNull
    private String currency;

    @Valid
    @NotNull
    private double amount;
}
