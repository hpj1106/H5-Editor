package H5Editor.Controller;

import H5Editor.Service.Json.FileJson;
import H5Editor.Service.Json.Response;
import H5Editor.Service.Json.UserJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

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

    @RequestMapping(value = "/admin/uploadFile")
    public ResponseEntity<Response> uploadFile(@RequestPart("file") MultipartFile file) {
        return null;
    }
}
