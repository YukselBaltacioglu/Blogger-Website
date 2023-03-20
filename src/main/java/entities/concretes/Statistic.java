package entities.concretes;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "statistics")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Statistic {

    @Id
    @Column(name = "stats_id")
    private int id;

    @OneToOne(mappedBy = "stats")
    private Blog blog;

    @Column(name = "site_url")
    private String siteUrl;

    @Column(name = "view_amount")
    private int viewAmount;

    @Column(name = "time_spent")
    private int timeSpent;



}
