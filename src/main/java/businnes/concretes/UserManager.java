package businnes.concretes;

import businnes.abstracts.UserService;
import core.utilities.result.DataResult;
import core.utilities.result.ErrorDataResult;
import core.utilities.result.SuccessDataResult;
import dataAccess.abstracts.UserDao;
import entities.concretes.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserManager implements UserService {
    private UserDao userDao;

    @Autowired
    public UserManager(UserDao userDao){
        this.userDao = userDao;
    }


    @Override
    public DataResult<User> signIn(String email, String password) {
        List<User> toCheck = this.userDao.findAll();
        boolean flag = false;
        User user = null;
        for (int i = 0; i < toCheck.size(); i++) {
            if (toCheck.get(i).getEmail().equals(email)){
                flag = true;
                user = toCheck.get(i);
                break;
            }
        }
        if(!flag){
            return new ErrorDataResult<>("Invalid email");
        }
        else if (flag && user.getPassword().equals(password)){
            return new SuccessDataResult<>(this.userDao.getUserByEmail(email));
        } else if (flag && !user.getPassword().equals(password)) {
            return new ErrorDataResult<>("Invalid password");
        }
        return new ErrorDataResult<>("No user found");
    }
}
