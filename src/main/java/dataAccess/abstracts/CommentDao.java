package dataAccess.abstracts;

import entities.concretes.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentDao extends JpaRepository<Comment, Integer> {

    List<Comment> getCommentsByBlog_Id(int blogId);
}
