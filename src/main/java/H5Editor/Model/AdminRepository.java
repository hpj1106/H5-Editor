package H5Editor.Model;

import org.springframework.data.repository.CrudRepository;

/**
 * Created by MrCJ on 2016/12/8.
 */

public interface AdminRepository extends CrudRepository<Admin, Long> {
    Admin findByUsername(String username);
}
