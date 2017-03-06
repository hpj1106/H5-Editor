package h5editor.service.Json;

import h5editor.model.User.User;

/**
 * Created by MrCJ on 2016/12/19.
 * 用户相关的JSON接口
 */
public interface UserJson {

    Object getUserList();
    Object getUserList(int page, int size);
    Object addUser(User user);
    Object removeUserById(long userId);
    Object getUserById(long userId);
    Object modifyUserById(User user);
}
