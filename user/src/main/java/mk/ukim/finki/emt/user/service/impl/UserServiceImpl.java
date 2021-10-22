package mk.ukim.finki.emt.user.service.impl;


import lombok.AllArgsConstructor;
import mk.ukim.finki.emt.sharedkernel.domain.valueObjects.Role;
import mk.ukim.finki.emt.user.domain.exceptions.UserIdNotFoundException;
import mk.ukim.finki.emt.user.domain.models.UserData;
import mk.ukim.finki.emt.user.domain.models.UserID;
import mk.ukim.finki.emt.user.repository.UserRepository;
import mk.ukim.finki.emt.user.service.UserService;
import mk.ukim.finki.emt.user.service.form.UserForm;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;


    //Adding new user
    @Override
    public Optional<UserID> addUser(UserForm userForm) {
        Objects.requireNonNull(userForm,  "User form must not be null");
        var newUser = userRepository.saveAndFlush(toDomainObject(userForm));
        return Optional.of(newUser.getId());
    }

    //Data for ading new user
    private UserData toDomainObject(UserForm userForm) {
        var user = new UserData(userForm.getUserId(), userForm.getName(), userForm.getSurname(), userForm.getEmail(), Role.valueOf(userForm.getRole()));
        return user;
    }


    //Find user by id
    @Override
    public UserData findById(UserID userID) {
        return this.userRepository.findById(userID).orElseThrow(UserIdNotFoundException::new);
    }

    //ist all users
    @Override
    public List<UserData> findAll() {
        return this.userRepository.findAll();
    }


    //Delete user by id
    @Override
    public void deleteUserById(UserID userID) {
        this.userRepository.deleteById(userID);
    }
}
