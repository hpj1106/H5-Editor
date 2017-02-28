package H5Editor.Service.Json;

import H5Editor.Model.User.User;
import H5Editor.Model.User.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by MrCJ on 2016/12/19.
 * 与普通用户相关的Service
 */

@Service
public class UserJsonService implements UserJson {

    private UserRepository userRepository;

    private static final Logger LOGGER = LoggerFactory.getLogger(UserJsonService.class);

    private static Response RES_SUCCESS_NO_DATA = new Response("true", "success", null);
    private static Response RES_SUCCESS_WITH_DATA = new Response("true", "success", null);
    private static Response RES_FAIL = new Response("false", "", null);

    @Autowired
    public UserJsonService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Object getUserList() {
        List<User> userList = userRepository.getAllUser();
        RES_SUCCESS_WITH_DATA.setData(userList);
        return RES_SUCCESS_WITH_DATA;
    }

    @Override
    public Object addUser(User user) {
        User expectSavedUser = userRepository.save(user);
        if (expectSavedUser != null) {
            return RES_SUCCESS_NO_DATA;
        } else {
            RES_FAIL.setInfo("Saved Error");
            return RES_FAIL;
        }
    }

    @Override
    public Object getUserById(int userId) {
        User expectedUser = userRepository.getUserById(userId);
        if (expectedUser != null) {
            RES_SUCCESS_WITH_DATA.setData(expectedUser);
            return RES_SUCCESS_WITH_DATA;
        } else {
            RES_FAIL.setInfo("No User");
            return RES_FAIL;
        }
    }

    @Override
    public Object removeUserById(int userId) {
        try {
            userRepository.delete(userId);
            return RES_SUCCESS_NO_DATA;
        } catch (Exception e) {
            RES_FAIL.setInfo("Delete Error");
            return RES_FAIL;
        }
    }

    @Override
    public Object modifyUserById(User user) {
        try {
            userRepository.modifyUserById(
                    user.getUserId(), user.getUsername(), user.getPassword(),
                    user.getEmail(), user.getTel(), user.getType(),
                    user.isAvailable());
            return RES_SUCCESS_NO_DATA;
        } catch (Exception e) {
            RES_FAIL.setInfo("Modify Error");
            return RES_FAIL;
        }
    }
}


