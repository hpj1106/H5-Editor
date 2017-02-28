package H5Editor.Service.Json;

import H5Editor.Model.User.User;
import H5Editor.Model.User.UserRepository;
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

    @Autowired
    public UserJsonService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Object getUserList() {
        List<User> userList = userRepository.getAllUser();
        //return new Response("true", "success", userList);
        return Response.getResponse("true", "success", userList);
    }

    @Override
    public Object addUser(User user) {
        User expectSavedUser = userRepository.save(user);
        if (expectSavedUser != null) {
            return Response.getResponse("true", "success", null);
        } else {
            return Response.getResponse("false", "Saved Error", null);
        }
    }

    @Override
    public Object getUserById(int username) {
        User expectUser = userRepository.findOne(username);
        if (expectUser != null) {
            return Response.getResponse("true", "success", null);
        } else {
            return Response.getResponse("false", "no user", null);
        }
    }

    @Override
    public Object removeUserById(int userId) {
        try {
            userRepository.delete(userId);
            return Response.getResponse("true", "success", null);
        } catch (Exception e) {
            return Response.getResponse("false", "Delete Error", null);
        }
    }

    @Override
    public Object modifyUserById(User user) {
        userRepository.modifyUserById(
                user.getUserId(), user.getUsername(), user.getPassword(),
                user.getEmail(), user.getTel(), user.getType(),
                user.isAvailable());
        return null;
    }
}


