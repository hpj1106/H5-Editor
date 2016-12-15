package H5Editor.Model;

import org.springframework.data.repository.CrudRepository;

/**
 * Created by MrCJ on 2016/12/8.
 */

public interface UserRepository extends CrudRepository<User, Integer> {
    User findByUsername(String username);
}
