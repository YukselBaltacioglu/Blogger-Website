package businnes.abstracts;

import core.utilities.result.DataResult;
import entities.concretes.Category;

import java.util.List;

public interface CategoryService {

    DataResult<List<Category>> getAll();
}
