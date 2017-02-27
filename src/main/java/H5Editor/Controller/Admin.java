package H5Editor.Controller;

import H5Editor.Model.User.User;
import H5Editor.Service.FileStorage;
import H5Editor.Service.Json.FileJson;
import H5Editor.Service.Json.UserJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * Created by MrCJ on 2016/12/19.
 * 管理员控制器
 */

@Controller
public class Admin {

    @Autowired
    private UserJson userJson;

    @Autowired
    private FileJson fileJson;

    @Autowired
    private FileStorage fileStorage;

    /**
     * 获取所有普通用户
     * @return JSON Response
     * */
    @RequestMapping(value = "/admin/getUserList",
                    method = RequestMethod.GET,
                    produces = "application/json")
    @ResponseBody
    public Object getUserList() {
        return userJson.getUserList();
    }

    // TODO: 2017/2/27
    /**
     * 新增普通用户
     * @param user 要新增的用户JSON
     * @return JSON Response
     * */
    @RequestMapping(value = "/admin/addUser",
                    method = RequestMethod.POST)
    public Object addUser(@RequestBody User user) {
        return userJson.addUser(user);
    }

    // TODO: 2017/2/27
    /**
     * 删除普通用户
     * @return JSON Response
     * */
    public Object removeUser() {
        return userJson.removeUser();
    }

    // TODO: 2017/2/27
    /**
     * 查询普通用户
     * @param userId 要查询的用户ID
     * @return JSON Response
     * */
    public Object getUser(@RequestParam int userId) {
        return userJson.getUser(userId);
    }

    // TODO: 2017/2/27
    /**
     * 修改普通用户
     * @param user 要修改的用户JSON
     * @return JSON Response
     * */
    public Object modifyUser(@RequestBody User user) {
        return userJson.modifyUser(user);
    }

    /**
     * 获取所有素材
     * @return JSON Response
     * */
    @RequestMapping(value = "/admin/getFileList",
                    method = RequestMethod.GET,
                    produces = "application/json")
    @ResponseBody
    public Object getFileList() {
        return fileJson.getFileListForAdmin();
    }

    /**
     * 上传素材
     * @return todo
     * */
    @GetMapping(value = "/admin/uploadFile")
    public String uploadFile() {
        return "uploadFile";
    }

    /**
     * 处理素材上传
     * @return todo
     * */
    @PostMapping(value = "/admin/uploadFile")
    public String handleFileupload(@RequestParam("file") MultipartFile file,
                                   RedirectAttributes redirectAttributes) {
        System.out.println(file.getOriginalFilename());
        fileStorage.store(file);
        redirectAttributes.addFlashAttribute("message",
                "You successfully uploaded " + file.getOriginalFilename());
        return "redirect:/admin/show";
    }
}
