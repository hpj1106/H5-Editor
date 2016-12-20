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

    public Object addUser(){
        int i=userRepository.addUser();
        Response resp;
        if(i==1)
            resp = new Response("true", "success", null);
        else
            resp = new Response("false", "insertion failed", null);
        return resp;
    }

    public Object deleteUser(){
        int i=userRepository.deleteUser();
        Response resp;
        if(i==1)
            resp = new Response("true", "success", null);
        else
            resp = new Response("false", "insertion failed", null);
        return resp;
    }
    public Object modifyUser(){
        int i=userRepository.addUser();
        Response resp;
        if(i==1)
            resp = new Response("true", "success", null);
        else
            resp = new Response("false", "insertion failed", null);
        return resp;
    }
    public Object queryUser(){
        User user = userRepository.queryUser();
        Response resp = new Response("true", "success", user);
        return resp;
    }

}


