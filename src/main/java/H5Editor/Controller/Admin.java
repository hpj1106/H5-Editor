package H5Editor.Controller;

import H5Editor.Model.File.FileRepository;
import H5Editor.Service.Json.FileJson;
import H5Editor.Service.Json.UserJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by MrCJ on 2016/12/19.
 */

@Controller
public class Admin {

    @Autowired
    private UserJson userJson;

    @Autowired
    private FileJson fileJson;

    @RequestMapping(value = "/admin/getUserList",
                    method = RequestMethod.GET,
                    produces = "application/json")
    @ResponseBody
    public Object getUserList() {
        return userJson.getUserList();
    }

    @RequestMapping(value = "/admin/getFileList",
                    method = RequestMethod.GET,
                    produces = "application/json")
    @ResponseBody
    public Object getFileList() {
        return fileJson.getFileListForAdmin();
    }

}
