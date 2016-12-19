package H5Editor.Model;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by MrCJ on 2016/12/8.
 */

public interface UserRepository extends CrudRepository<User, Integer> {
    User findByUsername(String username);

    @Query("select u from User u where u.type = 1")
    List<User> getAllUser();
}
