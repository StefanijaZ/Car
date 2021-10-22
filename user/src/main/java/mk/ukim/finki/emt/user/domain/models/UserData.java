package mk.ukim.finki.emt.user.domain.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import mk.ukim.finki.emt.sharedkernel.domain.base.AbstractEntity;
import mk.ukim.finki.emt.sharedkernel.domain.valueObjects.Role;
import org.hibernate.annotations.Cascade;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


//Entity for user
@Entity
@Table(name = "user_data")
@Getter
public class UserData extends AbstractEntity<UserID> {

    private String name;

    private String surname;

    private String email;

//    @ManyToOne
//    @Cascade(value={CascadeType.ALL})
//    @JsonIgnore
    private mk.ukim.finki.emt.sharedkernel.domain.valueObjects.Role role;

    private UserData() {
        super(UserID.randomId(UserID.class));
    }

    // Client Aggregate Root of Bounded Context 3.
    public UserData(String userID, String name, String surname, String email, Role role) {
        super(UserID.of(userID));
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.role = role;
    }

}
