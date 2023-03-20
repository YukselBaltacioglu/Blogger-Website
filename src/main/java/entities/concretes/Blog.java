package entities.concretes;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Time;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "blogs")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Blog {

    @Id
    @Column(name = "blog_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "categories_of_blog", joinColumns = @JoinColumn(name = "blog_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    private List<Category> categories;

    @Column(name = "title")
    private String title;

    @ManyToMany
    @JoinTable(name = "contents_of_blog", joinColumns = @JoinColumn(name = "blog_id"),
            inverseJoinColumns = @JoinColumn(name = "content_id"))
    private List<Content> contents;

    @Column(name = "release_date")
    private LocalDateTime releaseDate;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "stats_id")
    private Statistic stats;

    @OneToMany(mappedBy = "comment", fetch = FetchType.LAZY)
    private List<Comment> comments;

    @ManyToMany
    @JoinTable(name = "images_of_blog", joinColumns = @JoinColumn(name = "blog_id"),
            inverseJoinColumns = @JoinColumn(name = "image_id"))
    private List<Image> images;

}
