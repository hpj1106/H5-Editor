package H5Editor.Controller;

import H5Editor.Model.User.User;
import H5Editor.Service.FileStorage;
import H5Editor.Service.Json.FileJson;
import H5Editor.Service.Json.UserJson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private static final Logger LOGGER = LoggerFactory.getLogger(Admin.class);

    /*用户接口*/
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

    /**
     * 新增普通用户
     * @param user 要新增的用户JSON
     * @return JSON Response
     * */
    @RequestMapping(value = "/admin/addUser",
                    method = RequestMethod.POST,
                    consumes = "application/json",
                    produces = "application/json")
    @ResponseBody
    public Object addUser(@RequestBody User user) {
        return userJson.addUser(user);
    }

    /**
     * 删除普通用户
     * @return JSON Response
     * */
    @RequestMapping(value = "/admin/deleteUser",
                    method = RequestMethod.DELETE,
                    produces = "application/json")
    @ResponseBody
    public Object removeUser(@RequestParam int userId) {
        return userJson.removeUserById(userId);
    }

    /**
     * 查询普通用户
     * @param userId 要查询的用户ID
     * @return JSON Response
     * */
    @RequestMapping(value = "/admin/getUser",
                    method = RequestMethod.GET,
                    produces = "application/json")
    @ResponseBody
    public Object getUser(@RequestParam int userId) {
        // RequestParam 简单参数的绑定，可以直接体现在URL上
        return userJson.getUserById(userId);
    }

    /**
     * 修改普通用户
     * @param user 要修改的用户JSON
     * @return JSON Response
     * */
    @RequestMapping(value = "/admin/modifyUser",
                    method = RequestMethod.PUT,
                    consumes = "application/json",
                    produces = "application/json")
    @ResponseBody
    public Object modifyUser(@RequestBody User user) {
        return userJson.modifyUserById(user);
    }

    /*素材接口*/
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
