package businnes.abstracts;

import core.utilities.result.DataResult;
import entities.concretes.Content;

import java.util.List;

public interface ContentService {

    DataResult<List<Content>> getAll();
}
