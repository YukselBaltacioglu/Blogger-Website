package dataAccess.abstracts;

import entities.concretes.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlogDao extends JpaRepository<Blog, Integer> {

    List<Blog> getByCategories(String category);
    List<Blog> getByContents(String content);
    List<Blog> getByContentsAndCategories(String content, String category);


}
