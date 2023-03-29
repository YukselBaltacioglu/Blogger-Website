package businnes.concretes;

import businnes.abstracts.ImageService;
import core.utilities.result.DataResult;
import core.utilities.result.Result;
import core.utilities.result.SuccessDataResult;
import core.utilities.result.SuccessResult;
import dataAccess.abstracts.BlogDao;
import dataAccess.abstracts.ImageDao;
import entities.concretes.Blog;
import entities.concretes.Image;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ImageManager implements ImageService {

    private ImageDao imageDao;
    private BlogDao blogDao;

    @Autowired
    public ImageManager(ImageDao imageDao, BlogDao blogDao){
        this.imageDao = imageDao;
        this.blogDao = blogDao;
    }


    @Override
    public DataResult<List<Image>> getBlogImages(int blogId) {
        return new SuccessDataResult<>(this.imageDao.getByBlog_Id(blogId));
    }

    @Override
    public Result add(int blogId, String imgUrl, String imgContent, String imgName) {
        Blog blog = this.blogDao.findById(blogId).get();
        Image image = new Image(imgUrl,imgContent,imgName);
        this.imageDao.save(image);
        blog.getImages().add(image);
        this.blogDao.save(blog);
        return new SuccessResult("Resim eklendi.");


    }
}
