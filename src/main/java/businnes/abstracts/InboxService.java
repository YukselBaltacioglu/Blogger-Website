package businnes.abstracts;

import core.utilities.result.DataResult;
import core.utilities.result.Result;
import entities.concretes.Blog;
import entities.concretes.Inbox;

import java.util.List;

public interface InboxService {

    Result add(int userId, String name, String email, String content, StringBuilder message);
    DataResult<List<Inbox>> getAll(int userId);

    DataResult<Inbox> getMessage(int userId, int inboxId);
    Result makeItRead(int inboxId);
    Result makeItUnread(int inboxId);
    DataResult<List<Inbox>> getAllUnread(int userId);
    DataResult<List<Inbox>> getAllRead(int userId);

}
