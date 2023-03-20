package entities.concretes;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "inbox")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Inbox {

    @Id
    @Column(name = "inbox_id")
    private String id;

    @Column(name = "name")
    private String name;

    @Email
    @Column(name = "email")
    private String email;

    @Column(name = "content")
    private String content;

    @Column(name = "message")
    private StringBuilder message;

}
