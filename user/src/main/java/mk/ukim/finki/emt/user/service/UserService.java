package mk.ukim.finki.emt.user.service;

import mk.ukim.finki.emt.user.domain.models.UserData;
import mk.ukim.finki.emt.user.domain.models.UserID;
import mk.ukim.finki.emt.user.service.form.UserForm;

import java.util.List;
import java.util.Optional;

public interface UserService {

    Optional<UserID> addUser(UserForm userForm);

    UserData findById(UserID userID);

    public List<UserData> findAll();

    void deleteUserById(UserID userID);
}
