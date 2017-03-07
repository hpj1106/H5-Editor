package H5Editor.Controller;

import H5Editor.Service.FileStorageServiceServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import springfox.documentation.annotations.ApiIgnore;

/**
 * Created by MrCJ on 2016/12/5.
 */
@Controller
@ApiIgnore
public class ShowPage {

    private final FileStorageServiceServiceImpl fileStorageServiceImpl;

    @Autowired
    public ShowPage(FileStorageServiceServiceImpl fileStorageServiceImpl) {
        this.fileStorageServiceImpl = fileStorageServiceImpl;
    }

    @GetMapping("/")
    public String index() {
        return "redirect:/login";
    }

    @GetMapping("/admin/show")
    public String showAdmin(Model model) {
        String desValue = "This is an Admin Page!";
        model.addAttribute("description", desValue);
        return "index";
    }

    @GetMapping("/systemAdmin/show")
    public String showSystemAdmin(Model model) {
        String desValue = "This is a System Page!";
        model.addAttribute("description", desValue);
        return "index";
    }

    @GetMapping("/user/show")
    public String showUser(Model model) {
        String desValue = "This is a User Page!";
        model.addAttribute("description", desValue);
        return "index";
    }

    /*
    @GetMapping("/service/files/{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> serveFile(@PathVariable String filename) {
        Resource file = fileStorageService.loadAsResource(filename);
        return ResponseEntity
                .ok()
                .header(HttpHeaders.ACCEPT, "attachment; filename=\""+file.getFilename()+"\"")
                .body(file);
    }
    */
}
