package dataAccess.abstracts;

import entities.concretes.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ImageDao extends JpaRepository<Image, Integer> {


    List<Image> getByBlog_Id(int blogId);
}
