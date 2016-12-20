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

    public Object addUser(UserRepository repository,String id,String name,String email, String tel,
                          String pass,int type,int available){


        //查用户名
        repository.save(new User(name,pass,email,tel,type,available )); //插入

        Response  resp = new Response("true", "success", null);
        return resp;
    }

    public Object deleteUser(String id){
        int i=userRepository.deleteUser(id);
        Response resp;
        if(i==1)
            resp = new Response("true", "success", null);
        else
            resp = new Response("false", "insertion failed", null);
        return resp;
    }
    public Object modifyUser(String id,String name,String email, String tel,
                             String pass,int type,int available){
        int i=userRepository.modifyUser(id,name,email,tel,pass, type,available);
        Response resp;
        if(i==1)
            resp = new Response("true", "success", null);
        else
            resp = new Response("false", "insertion failed", null);
        return resp;
    }
    public Object queryUser(String id){
        User user = userRepository.queryUser(id);
        Response resp = new Response("true", "success", user);
        return resp;
    }

}


