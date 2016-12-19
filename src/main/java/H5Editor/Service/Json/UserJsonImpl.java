package H5Editor.Service.Json;

import H5Editor.Model.User;
import H5Editor.Model.UserRepository;
import H5Editor.Service.UserJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by MrCJ on 2016/12/19.
 */

@Component
public class UserJsonImpl implements UserJson {

    private UserRepository userRepository;

    @Autowired
    public UserJsonImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Object getUserList() {
        List<User> userList = userRepository.getAllUser();
        Response resp = new Response("true", "success", userList);
        return resp;
    }

}


