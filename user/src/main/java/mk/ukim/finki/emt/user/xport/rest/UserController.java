package mk.ukim.finki.emt.user.xport.rest;


import lombok.AllArgsConstructor;
import mk.ukim.finki.emt.user.domain.models.UserData;
import mk.ukim.finki.emt.user.domain.models.UserID;
import mk.ukim.finki.emt.user.domain.models.value_objects.Sell;
import mk.ukim.finki.emt.user.domain.models.value_objects.UserCars;
import mk.ukim.finki.emt.user.service.UserService;
import mk.ukim.finki.emt.user.service.form.UserForm;
import mk.ukim.finki.emt.user.xport.AllCar;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/user")
@AllArgsConstructor
public class UserController {

    private final UserService userService;
    private final AllCar allCar;

    //All user cars
    @GetMapping
    public List<UserCars> getAll() {
        List<UserCars> userCars = new ArrayList<>();
        for (UserData user: userService.findAll()) {
            List<Sell> cars = this.allCar.findById(user.getId()).get();
            userCars.add(new UserCars(user, cars));
        }
        return userCars;
    }

    //Add new user
    @PostMapping("/add")
    public ResponseEntity<UserID> add(@RequestBody UserForm userForm) {

        return this.userService.addUser(userForm)
                .map(clientId -> ResponseEntity.ok().body(clientId))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @DeleteMapping("delete/{id}")
    public void deleteUserById(@PathVariable String id) {
        this.userService.deleteUserById(UserID.of(id));
    }


}
