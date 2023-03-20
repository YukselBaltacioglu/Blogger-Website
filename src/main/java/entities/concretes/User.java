package entities.concretes;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @Column(name = "user_id")
    private long id;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<Blog> blogs;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "whoAmI")
    private StringBuilder whoAmI;

    @Email
    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "instagram")
    private String instagram;

    @Column(name = "twitter")
    private String twitter;




}
