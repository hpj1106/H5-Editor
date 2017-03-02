package H5Editor.Service.Json;

import H5Editor.Model.User.User;
import H5Editor.Model.User.UserRepository;
import H5Editor.common.Constant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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

    @Autowired
    public UserJsonService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Deprecated
    @Override
    public Object getUserList() {
        return userRepository.getAllUser();
    }

    @Override
    public Object getUserList(int page, int size) {
        Sort sort = new Sort(Sort.Direction.ASC, "userId"); // 升序排列
        Pageable pageable = new PageRequest(page, size, sort);
        try {
            Page<User> userPage = userRepository.getAllUser(pageable);
            Constant.RES_SUCCESS_WITH_DATA.setData(userPage);
            return Constant.RES_SUCCESS_WITH_DATA;
        } catch (Exception e) {
            LOGGER.error("FindAllUser Error", e);
            Constant.RES_FAIL.setInfo("Error");
            return Constant.RES_FAIL;
        }
    }

    @Override
    public Object addUser(User user) {
        User expectSavedUser = userRepository.save(user);
        if (expectSavedUser != null) {
            return Constant.RES_SUCCESS_NO_DATA;
        } else {
            Constant.RES_FAIL.setInfo("Saved Error");
            return Constant.RES_FAIL;
        }
    }

    @Override
    public Object getUserById(long userId) {
        User expectedUser = userRepository.getUserById(userId);
        if (expectedUser != null) {
            Constant.RES_SUCCESS_WITH_DATA.setData(expectedUser);
            return Constant.RES_SUCCESS_WITH_DATA;
        } else {
            Constant.RES_FAIL.setInfo("No User");
            return Constant.RES_FAIL;
        }
    }

    @Override
    public Object removeUserById(long userId) {
        try {
            userRepository.delete(userId);
            return Constant.RES_SUCCESS_NO_DATA;
        } catch (Exception e) {
            Constant.RES_FAIL.setInfo("Delete Error");
            return Constant.RES_FAIL;
        }
    }

    @Override
    public Object modifyUserById(User user) {
        try {
            userRepository.save(user);
            //userRepository.modifyUserById(user.getUserId(), user.getUsername(), user.getPassword(), user.getEmail(), user.getTel(), user.getType(), user.isAvailable());
            return Constant.RES_SUCCESS_NO_DATA;
        } catch (Exception e) {
            System.out.println(e);
            Constant.RES_FAIL.setInfo("Modify Error");
            return Constant.RES_FAIL;
        }
    }
}


