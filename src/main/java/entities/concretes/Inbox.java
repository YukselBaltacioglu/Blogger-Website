package entities.concretes;

import jakarta.persistence.*;
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
    private int id;

    @Column(name = "name")
    private String name;

    @Email
    @Column(name = "email")
    private String email;

    @Column(name = "content")
    private String content;

    @Column(name = "message")
    private StringBuilder message;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "isRead")
    private boolean isRead;

    public Inbox(String name, String email, String content, StringBuilder message) {
        this.name = name;
        this.email = email;
        this.content = content;
        this.message = message;
        this.isRead = false;
    }
}
