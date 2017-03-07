package H5Editor.Service.Json;

import H5Editor.Model.User.User;

/**
 * Created by MrCJ on 2016/12/19.
 * 用户相关的JSON接口
 */
public interface UserJsonService {

    Object getUserList();
    Object getUserList(int page, int size);
    Object addUser(User user);
    Object removeUserById(long userId);
    Object getUserById(long userId);
    Object modifyUserById(User user);
}
