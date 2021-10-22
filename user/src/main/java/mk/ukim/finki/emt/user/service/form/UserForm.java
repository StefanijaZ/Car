package mk.ukim.finki.emt.user.service.form;


import com.sun.istack.NotNull;
import lombok.Data;

import javax.validation.Valid;


//Dto for user
@Data
public class UserForm {
    @Valid
    @NotNull
    private String userId;
    @Valid
    @NotNull
    private String name;
    @Valid
    @NotNull
    private String surname;
    @Valid
    @NotNull
    private String email;
    @NotNull
    private String role;
}
