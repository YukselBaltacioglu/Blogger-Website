package businnes.abstracts;

import core.utilities.result.DataResult;
import core.utilities.result.Result;
import entities.concretes.Comment;

import java.util.List;
import java.util.PriorityQueue;

public interface CommentService {
    Result add(int blogId, String name, StringBuilder comment);

    DataResult<List<Comment>> getAllByPopularity(int blogId);
    DataResult<List<Comment>> getAllByNewest(int blogId);
    DataResult<List<Comment>> getAllByOldest(int blogId);

    DataResult<Comment> getComment(int commentId);

    Result likeComment(int commentId);
    Result dislikeComment(int commentId);

}
