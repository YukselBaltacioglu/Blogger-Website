package businnes.abstracts;

import core.utilities.result.DataResult;
import core.utilities.result.Result;
import entities.concretes.Blog;
import entities.dtos.BlogDto;

import java.util.List;

public interface BlogService {
    DataResult<List<Blog>> getAllByCategories(String category);
    DataResult<List<Blog>> getAll();
    DataResult<List<Blog>> getAllByContentAndCategories(String content, String category);
    DataResult<List<Blog>> getAllByContent(String content);

    Result add(BlogDto blogDto);

    Result add2(BlogDto blogDto);

    DataResult<Blog> getBlog(int blogId);

}
