package businnes.concretes;

import businnes.abstracts.CommentService;
import core.utilities.result.DataResult;
import core.utilities.result.Result;
import core.utilities.result.SuccessDataResult;
import core.utilities.result.SuccessResult;
import dataAccess.abstracts.BlogDao;
import dataAccess.abstracts.CommentDao;
import entities.concretes.Blog;
import entities.concretes.Comment;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class CommentManager implements CommentService {

    private CommentDao commentDao;
    private BlogDao blogDao;

    @Autowired
    public CommentManager(CommentDao commentDao, BlogDao blogDao){
        this.blogDao = blogDao;
        this.commentDao = commentDao;
    }


    @Override
    public Result add(int blogId, String name, StringBuilder comment) {

        Blog blog = this.blogDao.findById(blogId).get();
        String userName = blog.getUser().getName();
        String userEmail = blog.getUser().getEmail();
        int popularity = 0;
        LocalDateTime now = LocalDateTime.now();
        Comment comment1 = new Comment(popularity,name,userEmail,comment,now);
        this.commentDao.save(comment1);
        blog.getComments().add(comment1);
        this.blogDao.save(blog);
        return new SuccessResult("Yorum eklendi.");

    }

    @Override
    public DataResult<List<Comment>> getAllByPopularity(int blogId) {
        Blog blog = this.blogDao.findById(blogId).get();
        PriorityQueue<Comment> queue = new PriorityQueue<>(Comparator.comparing(Comment::getPopularity).reversed());
        List<Comment> populerList = null;
        for (int i = 0; i < blog.getComments().size(); i++) {
            if (!blog.getComments().get(i).isDeleted()){

                queue.add(blog.getComments().get(i));
            }
        }
        for (int i = 0; i < queue.size(); i++) {
            populerList.add(queue.poll());
        }
        blog.setComments(populerList);
        this.blogDao.save(blog);
        return new SuccessDataResult<>(this.blogDao.findById(blogId).get().getComments());


    }

    @Override
    public DataResult<List<Comment>> getAllByNewest(int blogId) {
        Blog blog = this.blogDao.findById(blogId).get();
        PriorityQueue<Comment> queue = new PriorityQueue<>(Comparator.comparing(Comment::getCommentDate).reversed());
        List<Comment> newestList = null;
        for (int i = 0; i < blog.getComments().size(); i++) {
            if (!blog.getComments().get(i).isDeleted()){
                queue.add(blog.getComments().get(i));
            }
        }
        for (int i = 0; i < queue.size(); i++) {
            newestList.add(queue.poll());
        }
        blog.setComments(newestList);
        this.blogDao.save(blog);
        return new SuccessDataResult<>(this.blogDao.findById(blogId).get().getComments());
    }

    @Override
    public DataResult<List<Comment>> getAllByOldest(int blogId) {
        Blog blog = this.blogDao.findById(blogId).get();
        PriorityQueue<Comment> queue = new PriorityQueue<>(Comparator.comparing(Comment::getCommentDate));
        List<Comment> oldestList = null;
        for (int i = 0; i < blog.getComments().size(); i++) {
            if (!blog.getComments().get(i).isDeleted()){
                queue.add(blog.getComments().get(i));
            }
        }
        for (int i = 0; i < queue.size(); i++) {
            oldestList.add(queue.poll());
        }
        blog.setComments(oldestList);
        this.blogDao.save(blog);
        return new SuccessDataResult<>(this.blogDao.findById(blogId).get().getComments());
    }

    @Override
    public DataResult<Comment> getComment(int commentId) {
        return new SuccessDataResult<>(this.commentDao.findById(commentId).get());
    }

    @Override
    public Result likeComment(int commentId) {
        Comment comment = this.commentDao.findById(commentId).get();
        comment.upVote();
        this.commentDao.save(comment);
        return new SuccessResult("Yorum beğenildi.");


    }

    @Override
    public Result dislikeComment(int commentId) {
        Comment comment = this.commentDao.findById(commentId).get();
        comment.deVote();
        this.commentDao.save(comment);
        return new SuccessResult("Yorum beğenilmedi.");

    }
}
