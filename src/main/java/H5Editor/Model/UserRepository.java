package H5Editor.Model;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by MrCJ on 2016/12/8.
 */

public interface UserRepository extends CrudRepository<User, Integer> {
    User findByUsername(String username);
    User findByUsernameAndType(String username, int type);

    @Query("select u from user u where u.type = 1")     //ignore this error report
    List<User> getAllUser();

    // 是否已经有username 在别的地方实现  how to insert here
    @Query("INSERT INTO user ( username,  password, email, tel, type, available ) VALUES ( {name},{pass},{email},{tel}, 1, {available} );")     //ignore this error report
    int addUser();

    @Modifying
    @Query("update User u set u.availble = 1 where u.available = 1 and u.user_id=?1")
    int deleteUser(String id);

    @Modifying
    @Query("update user u SET u.username=?2,u.password=?5,u.email=?3," +
            "u.tel=?4,u.available=?7 WHERE u.user_id=?1 AND u.type=?6")     //ignore this error report
    int modifyUser(String id,String name,String email, String tel, String pass,int type,int available);

    @Query("select u from User u where u.type = 1 and u.user_id= ?1")     //ignore this error report
    User queryUser(String id);
}
