package H5Editor.Controller;

import H5Editor.Model.File.File;
import H5Editor.Model.User.User;
import H5Editor.Service.FileStorageService;
import H5Editor.Service.Json.FileJsonService;
import H5Editor.Service.Json.Response;
import H5Editor.Service.Json.UserJsonService;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.util.stream.Collectors;

/**
 * Created by MrCJ on 2016/12/19.
 * 管理员控制器
 */

@Controller
@Api("管理员相关的API")
public class Admin {

    private UserJsonService userJsonService;

    private FileJsonService fileJsonService;

    private FileStorageService fileStorageService;

    @Autowired
    public Admin(UserJsonService userJsonService, FileJsonService fileJsonService,
                 FileStorageService fileStorageService) {
        this.userJsonService = userJsonService;
        this.fileJsonService = fileJsonService;
        this.fileStorageService = fileStorageService;
    }

    private static final Logger LOGGER = LoggerFactory.getLogger(Admin.class);

    /*用户接口*/
    /**
     * 获取所有普通用户
     * @param page 表示第几页，从0开始，默认为第0页
     * @param size 表示每一页的大小，默认为20
     * @return JSON Response
     * */
    @ApiOperation("获取所有普通用户")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query", name = "page", dataType = "int",
                    value="要查询的页数", required = true, defaultValue = "1"),
            @ApiImplicitParam(paramType="query", name = "size", dataType = "int",
                    value="每页的条目数", required = true, defaultValue = "1")
    })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "成功返回所有普通用户", response = Response.class)
    })
    @RequestMapping(value = "/admin/getUserList",
                    method = RequestMethod.GET,
                    produces = "application/json")
    @ResponseBody
    public Object getUserList(@RequestParam int page, @RequestParam int size) {
        return userJsonService.getUserList(page, size);
    }

    /**
     * 新增普通用户
     * @param user 要新增的用户JSON
     * @return JSON Response
     * */
    @ApiOperation("新增普通用户")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "body", name = "user", dataType = "json",
                    value = "要新增的用户json", required = true)
    })
    @ApiResponses({
            @ApiResponse(code = 200, message = "成功新增普通用户", response = Response.class)
    })
    @RequestMapping(value = "/admin/addUser",
                    method = RequestMethod.POST,
                    consumes = "application/json",
                    produces = "application/json")
    @ResponseBody
    public Object addUser(@RequestBody User user) {
        LOGGER.info("userId", user.getUsername());
        LOGGER.info("userTel", user.getPassword());
        return userJsonService.addUser(user);
    }

    /**
     * 删除普通用户
     * @param userId 普通用户ID
     * @return JSON Response
     * */
    @ApiOperation("删除普通用户")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "userId", dataType = "long",
                    value = "要删除的用户的ID", required = true)
    })
    @ApiResponses({
            @ApiResponse(code = 200, message = "成功删除普通用户", response = Response.class)
    })
    @RequestMapping(value = "/admin/deleteUser",
                    method = RequestMethod.DELETE,
                    produces = "application/json")
    @ResponseBody
    public Object removeUser(@RequestParam long userId) {
        return userJsonService.removeUserById(userId);
    }

    /**
     * 查询普通用户
     * @param userId 要查询的用户ID
     * @return JSON Response
     * */
    @ApiOperation("查询普通用户")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "userId", dataType = "long",
                    value = "要查询的用户ID", required = true)
    })
    @ApiResponses({
            @ApiResponse(code = 200, message = "成功查询普通用户", response = Response.class)
    })
    @RequestMapping(value = "/admin/getUser",
                    method = RequestMethod.GET,
                    produces = "application/json")
    @ResponseBody
    public Object getUser(@RequestParam long userId) {
        // RequestParam 简单参数的绑定，可以直接体现在URL上
        return userJsonService.getUserById(userId);
    }

    /**
     * 修改普通用户
     * @param user 要修改的用户JSON
     * @return JSON Response
     * */
    @ApiOperation("修改普通用户")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "body", name = "user", dataType = "json",
                    value = "要修改的用户json", required = true)
    })
    @ApiResponses({
            @ApiResponse(code = 200, message = "成功修改普通用户", response = Response.class)
    })
    @RequestMapping(value = "/admin/modifyUser",
                    method = RequestMethod.PUT,
                    consumes = "application/json",
                    produces = "application/json")
    @ResponseBody
    public Object modifyUser(@RequestBody User user) {
        return userJsonService.modifyUserById(user);
    }

    /*素材接口*/
    /**
     * 获取所有素材
     * @param page 表示第几页，从0开始，默认为第0页
     * @param size 表示每一页的大小，默认为20
     * @return JSON Response
     * */
    @ApiOperation("获取所有素材文件")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query", name = "page", dataType = "int",
                    value="要查询的页数", required = true, defaultValue = "1"),
            @ApiImplicitParam(paramType="query", name = "size", dataType = "int",
                    value="每页的条目数", required = true, defaultValue = "1")
    })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "成功返回所有素材文件", response = Response.class)
    })
    @RequestMapping(value = "/admin/getFileList",
                    method = RequestMethod.GET,
                    produces = "application/json")
    @ResponseBody
    public Object getFileList(@RequestParam int page, @RequestParam int size) {
        return fileJsonService.getFileListForAdmin(page, size);
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
        //System.out.println(file.getOriginalFilename());
        fileStorageService.store(file);
        redirectAttributes.addFlashAttribute("message",
                "You successfully uploaded " + file.getOriginalFilename());
        return "redirect:/admin/show";
    }

    /**
     * 显示所有已上传文件，点击下载
     * */
    @GetMapping(value = "/admin/files")
    public String listUploadedFiles(Model model) throws IOException {
        model.addAttribute("files",
                fileStorageService
                        .loadAll()
                        .map(path -> MvcUriComponentsBuilder
                                .fromMethodName(Admin.class,
                                        "serveFile",
                                        path.getFileName().toString()).build().toString())
                        .collect(Collectors.toList())
        );
        return "uploadedFiles";
    }

    /**
     * 下载素材文件
     * */
    @GetMapping(value = "/admin/files/{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> serveFile(@PathVariable String filename) {
        Resource file = fileStorageService.loadAsResource(filename);
        return ResponseEntity
                .ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\""+file.getFilename()+"\"")
                .body(file);
    }

    /**
     * 删除素材
     * @return JSON Response
     * */
    @ApiOperation("删除素材文件")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "fileId", dataType = "long",
                    value = "要删除的素材的ID", required = true)
    })
    @ApiResponses({
            @ApiResponse(code = 200, message = "成功删除素材文件", response = Response.class)
    })
    @RequestMapping(value = "/admin/removeFile",
                    method = RequestMethod.DELETE,
                    produces = "application/json")
    @ResponseBody
    public Object removeFile(@RequestParam long fileId) {
        return fileJsonService.removeFileByFileIdForAdmin(fileId);
    }

    /**
     * 修改素材
     * @return JSON Response
     * */
    @ApiOperation("修改素材文件")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "body", name = "file", dataType = "json",
                    value = "要修改的素材的ID", required = true)
    })
    @ApiResponses({
            @ApiResponse(code = 200, message = "成功修改素材文件", response = Response.class)
    })
    @RequestMapping(value = "/admin/modifyFile",
                    method = RequestMethod.PUT,
                    consumes = "application/json",
                    produces = "application/json")
    @ResponseBody
    public Object modifyFile(@RequestBody File file) {
        return fileJsonService.modifyFileByFileIdForAdmin(file);
    }

    /**
     * 查询素材
     * @return JSON Response
     * */
    @ApiOperation("查询素材文件")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "fileId", dataType = "long",
                    value = "要查询的素材的ID", required = true)
    })
    @ApiResponses({
            @ApiResponse(code = 200, message = "成功查询素材文件", response = Response.class)
    })
    @RequestMapping(value = "/admin/getFile",
                    method = RequestMethod.GET,
                    produces = "application/json")
    @ResponseBody
    public Object getFile(@RequestParam long fileId) {
        return fileJsonService.getFileByIdForAdmin(fileId);
    }
}
