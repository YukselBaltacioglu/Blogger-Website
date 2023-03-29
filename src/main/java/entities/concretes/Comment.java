package entities.concretes;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "comments")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Comment {

    @Id
    @Column(name = "comment_id")
    private int id;

    @Column(name = "popularity")
    private int popularity;

    @ManyToOne
    @JoinColumn(name = "comment_id")
    private Blog blog;

    @Column(name = "name")
    private String name;

    @Email
    @Column(name = "email")
    private String email;

    @Column(name = "comment")
    private StringBuilder comment;

    @Column(name = "comment_date")
    private LocalDateTime commentDate;

    @Column(name = "isDeleted")
    private boolean isDeleted;

    public Comment(int popularity, String name, String email, StringBuilder comment, LocalDateTime commentDate) {
        this.popularity = popularity;
        this.name = name;
        this.email = email;
        this.comment = comment;
        this.commentDate = commentDate;
        this.isDeleted = false;

    }



    public void upVote() {
        this.popularity++;
    }
    public void deVote() {
        this.popularity--;
    }
}
