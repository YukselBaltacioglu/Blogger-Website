package businnes.concretes;

import businnes.abstracts.InboxService;
import core.utilities.result.*;
import dataAccess.abstracts.BlogDao;
import dataAccess.abstracts.InboxDao;
import dataAccess.abstracts.UserDao;
import entities.concretes.Blog;
import entities.concretes.Inbox;
import entities.concretes.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class InboxManager implements InboxService {

    private InboxDao inboxDao;
    private BlogDao blogDao;
    private UserDao userDao;

    @Autowired
    public InboxManager(InboxDao inboxDao, BlogDao blogDao, UserDao userDao){
        this.blogDao = blogDao;
        this.inboxDao = inboxDao;
        this.userDao = userDao;
    }

    @Override
    public Result add(int userId, String name, String email, String content, StringBuilder message) {
        User user = this.userDao.findById(userId).get();
        Inbox inbox = new Inbox(name,email,content,message);
        this.inboxDao.save(inbox);
        user.getInboxes().add(inbox);
        this.userDao.save(user);
        return new SuccessResult("Mesaj gönderildi.");
    }

    @Override
    public DataResult<List<Inbox>> getAll(int userId) {
        if (this.inboxDao.getInboxByUser_Id(userId) != null || this.inboxDao.getInboxByUser_Id(userId).size() != 0){
            return new SuccessDataResult<>(this.inboxDao.getInboxByUser_Id(userId));
        }
        else
            return new ErrorDataResult<>("Henüz mesaj yok.");
    }

    @Override
    public DataResult<Inbox> getMessage(int userId, int inboxId) {
        return new SuccessDataResult<>(this.inboxDao.findById(inboxId).get());
    }

    @Override
    public Result makeItRead(int inboxId) {
        Inbox inbox = this.inboxDao.findById(inboxId).get();
        inbox.setRead(true);
        this.inboxDao.save(inbox);
        return new SuccessResult("Okundu olarak işaretlendi.");
    }

    @Override
    public Result makeItUnread(int inboxId) {
        Inbox inbox = this.inboxDao.findById(inboxId).get();
        inbox.setRead(false);
        this.inboxDao.save(inbox);
        return new SuccessResult("Okunmadı olarak işaretlendi.");
    }

    @Override
    public DataResult<List<Inbox>> getAllUnread(int userId) {
        User user = this.userDao.findById(userId).get();
        List<Inbox> unreadList = null;
        for (int i = 0; i < user.getInboxes().size(); i++) {
            if (!user.getInboxes().get(i).isRead()){
                unreadList.add(user.getInboxes().get(i));
            }
        }
        return new SuccessDataResult<>(unreadList);
    }

    @Override
    public DataResult<List<Inbox>> getAllRead(int userId) {
        User user = this.userDao.findById(userId).get();
        List<Inbox> readList = null;
        for (int i = 0; i < user.getInboxes().size(); i++) {
            if (user.getInboxes().get(i).isRead()){
                readList.add(user.getInboxes().get(i));
            }
        }
        return new SuccessDataResult<>(readList);
    }


}
