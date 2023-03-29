package businnes.concretes;

import businnes.abstracts.CategoryService;
import core.utilities.result.DataResult;
import core.utilities.result.SuccessDataResult;
import dataAccess.abstracts.CategoryDao;
import entities.concretes.Category;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CategoryManager implements CategoryService {

    private CategoryDao categoryDao;

    @Autowired
    public CategoryManager(CategoryDao categoryDao){
        this.categoryDao = categoryDao;
    }


    @Override
    public DataResult<List<Category>> getAll() {
        return new SuccessDataResult<>(this.categoryDao.findAll());
    }
}
