package H5Editor.Model;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by MrCJ on 2016/12/8.
 */

public interface UserRepository extends CrudRepository<User, Integer> {
    User findByUsername(String username);
    User findByUsernameAndType(String username, int type);

    @Query("select u from User u where u.type = 1")     //ignore this error report
    List<User> getAllUser();

    @Query("INSERT INTO user ( username,  password, email, tel, type, available ) VALUES ( {name},{pass},{email},{tel}, 1, {available} );")     //ignore this error report
    int addUser();

    @Query("UPDATE user SET available=0 WHERE user_id={id} and type=1")     //ignore this error report
    int deleteUser();

    @Query("select u from User u where u.type = 1")     //ignore this error report
    int modifyUser();

    @Query("select u from User u where u.type = 1")     //ignore this error report
    User queryUser();
}
