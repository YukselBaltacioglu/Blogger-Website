package businnes.concretes;

import businnes.abstracts.ContentService;
import core.utilities.result.DataResult;
import core.utilities.result.SuccessDataResult;
import dataAccess.abstracts.ContentDao;
import entities.concretes.Content;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ContentManager implements ContentService {

    private ContentDao contentDao;

    @Autowired
    public ContentManager(ContentDao contentDao){
        this.contentDao = contentDao;
    }


    @Override
    public DataResult<List<Content>> getAll() {
        return new SuccessDataResult<>(this.contentDao.findAll());
    }
}
