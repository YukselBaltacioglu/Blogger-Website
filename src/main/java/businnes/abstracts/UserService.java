package businnes.abstracts;

import core.utilities.result.DataResult;
import entities.concretes.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserService{

    DataResult<User> signIn(String email, String password);
}
