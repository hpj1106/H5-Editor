package h5editor.model.User;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by MrCJ on 2016/12/8.
 * 普通用户仓库
 */

public interface UserRepository extends CrudRepository<User, Long> {

    /**
     * 根据用户名查找用户,不区分普通用户和管理员
     * */
    User findByUsername(String username);

    /**
     * 根据用户ID查找普通用户
     * */
    @Query("select u from User u where u.userId = ?1 and u.type = 1")
    User getUserById(long userId);

    /**
     * 获取所有普通用户，未分页
     * */
    @Query("select u from User u where u.type = 1")
    List<User> getAllUser();

    /**
     * 获取所有普通用户，已分页
     * */
    @Query("select u from User u where u.type = 1")
    Page<User> getAllUser(Pageable pageable);



    /*
    @Modifying // 不添加该注释，抛出org.hibernate.hql.QueryExecutionRequestException: Not supported for DML operations
    @Transactional  // 不添加该注释，抛出InvalidDataAccessApiUsageException: Executing an update/delete query
    @Query("update User u set u.username = ?2, u.password = ?3, u.email = ?4," +
            "u.tel = ?5, u.type = ?6, u.available = ?7" +
            " where u.userId = ?1")
    void modifyUserById(long userId, String username, String password, String email,
                        String tel, int type, boolean available);
    */
}
