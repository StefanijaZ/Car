package mk.ukim.finki.emt.user.repository;

import mk.ukim.finki.emt.user.domain.models.UserData;
import mk.ukim.finki.emt.user.domain.models.UserID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserData, UserID> {
}
