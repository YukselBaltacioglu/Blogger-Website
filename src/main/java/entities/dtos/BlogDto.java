package entities.dtos;

import entities.concretes.Statistic;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BlogDto {

    private int userId;
    private int popularity;
    private List<Integer> categories;
    private String title;
    private List<Integer> contents;
    private LocalDateTime releaseDate;
    private int statsId;
    private List<Integer> comments;
    private List<Integer> images;

}
