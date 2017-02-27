package H5Editor.Controller;

import H5Editor.Model.File.File;
import H5Editor.Model.File.FileRepository;
import H5Editor.Service.Json.FileJson;
import H5Editor.Service.Json.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by MrCJ on 2016/12/20.
 * 用户控制器
 */
@Controller
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
        return fileJson.getFileListForUser(userId);
    }
}
