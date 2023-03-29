package businnes.concretes;

import businnes.abstracts.BlogService;
import core.utilities.result.DataResult;
import core.utilities.result.Result;
import core.utilities.result.SuccessDataResult;
import core.utilities.result.SuccessResult;
import dataAccess.abstracts.*;
import entities.concretes.Blog;
import entities.concretes.Category;
import entities.concretes.Image;
import entities.concretes.User;
import entities.dtos.BlogDto;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class BlogManager implements BlogService {
    private BlogDao blogDao;
    private UserDao userDao;
    private CategoryDao categoryDao;
    private ContentDao contentDao;
    private CommentDao commentDao;
    private ImageDao imageDao;

    @Autowired
    public BlogManager(BlogDao blogDao, UserDao userDao, CategoryDao categoryDao, ContentDao contentDao, CommentDao commentDao, ImageDao imageDao){
        this.blogDao = blogDao;
        this.userDao = userDao;
        this.categoryDao = categoryDao;
        this.contentDao = contentDao;
        this.commentDao = commentDao;
        this.imageDao = imageDao;
    }

    @Override
    public DataResult<List<Blog>> getAllByCategories(String category) {
        return new SuccessDataResult<>(this.blogDao.getByCategories(category));
    }

    @Override
    public DataResult<List<Blog>> getAll() {
        return new SuccessDataResult<>(this.blogDao.findAll());
    }

    @Override
    public DataResult<List<Blog>> getAllByContentAndCategories(String content, String category) {
        return new SuccessDataResult<>(this.blogDao.getByContentsAndCategories(content,category));
    }

    @Override
    public DataResult<List<Blog>> getAllByContent(String content) {
        return new SuccessDataResult<>(this.blogDao.getByContents(content));
    }

    @Override
    public Result add(BlogDto blogDto) {
        Blog blog = new Blog(blogDto);
        this.blogDao.save(blog);
        return new SuccessResult("Blog eklendi.");
    }

    @Override
    public Result add2(BlogDto blogDto) {
        Blog blog = new Blog(blogDto);
        for (int i = 0; i < blog.getCategories().size(); i++) {

        }
        this.blogDao.save(blog);
        return new SuccessResult("Blog eklendi.");
    }

    @Override
    public DataResult<Blog> getBlog(int blogId) {
        return new SuccessDataResult<>(this.blogDao.findById(blogId).get());
    }
}
