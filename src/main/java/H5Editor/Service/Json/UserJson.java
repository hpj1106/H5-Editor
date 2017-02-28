package H5Editor.Service.Json;

import H5Editor.Model.User.User;

/**
 * Created by MrCJ on 2016/12/19.
 * 用户相关的JSON接口
 */
public interface UserJson {
    Object getUserList();
    Object addUser(User user);
    Object removeUserById(int userId);
    Object getUserById(int userId);
    Object modifyUserById(User user);
}
