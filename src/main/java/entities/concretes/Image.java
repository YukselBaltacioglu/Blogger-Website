package entities.concretes;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "images")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Image {

    @Id
    @Column(name = "image_id")
    private String id;

    @ManyToMany(mappedBy = "images", fetch = FetchType.LAZY)
    private List<Blog> blog;

    @Column(name = "img_url")
    private String imgUrl;

    @Column(name = "img_content")
    private String imgContent;

    @Column(name = "img_name")
    private String imgName;



}
