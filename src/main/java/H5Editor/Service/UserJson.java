package H5Editor.Service;

import H5Editor.Model.UserRepository;

/**
 * Created by MrCJ on 2016/12/19.
 */
public interface UserJson {
    Object getUserList();
    Object addUser(UserRepository repository, String id, String name, String email, String tel,
                   String pass, int type, int available);
    Object deleteUser(String id);
    Object modifyUser(String id,String name,String email, String tel, String pass,int type,int available);
    Object queryUser(String id);

}
