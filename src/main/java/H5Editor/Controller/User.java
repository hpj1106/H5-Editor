package H5Editor.Controller;

import H5Editor.Service.Json.FileJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import springfox.documentation.annotations.ApiIgnore;

/**
 * Created by MrCJ on 2016/12/20.
 * 用户控制器
 */
@Controller
@ApiIgnore
public class User {

    @Autowired
    private FileJson fileJson;

    /**
     * 获取普通用户上传的素材列表
     * */
    @RequestMapping(value = "/user/getFileList/{userId}",
                    method = RequestMethod.GET,
                    produces = "application/json")
    @ResponseBody
    public Object getFileList(@PathVariable("userId") int userId) {
        return null;
        //return fileJson.getFileListForUser(userId);
    }
}
