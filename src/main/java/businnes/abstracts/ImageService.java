package businnes.abstracts;

import core.utilities.result.DataResult;
import core.utilities.result.Result;
import entities.concretes.Image;

import java.util.List;

public interface ImageService {
    DataResult<List<Image>> getBlogImages(int blogId);

    Result add(int blogId,String imgUrl, String imgContent, String imgName);
}
