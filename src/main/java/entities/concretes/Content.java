package entities.concretes;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "contents")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Content {

    @Id
    @Column(name = "content_id")
    private int id;

    @Column(name = "name")
    private String name;

    @ManyToMany(mappedBy = "contents", fetch = FetchType.LAZY)
    private List<Blog> blogs;

}
