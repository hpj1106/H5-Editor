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
        return new Response("true", "success", userList);
    }

    // TODO: 2017/2/27  
    @Override
    public Object addUser(User user) {
        return null;
    }

    // TODO: 2017/2/27  
    @Override
    public Object getUser(int username) {
        return null;
    }

    // TODO: 2017/2/27  
    @Override
    public Object removeUser() {
        return null;
    }

    // TODO: 2017/2/27  
    @Override
    public Object modifyUser(User user) {
        return null;
    }
}


