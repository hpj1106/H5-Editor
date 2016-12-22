package H5Editor.Controller;

import H5Editor.Service.FileStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by MrCJ on 2016/12/5.
 */
@Controller
public class ShowPage {

    private final FileStorageService fileStorageService;

    @Autowired
    public ShowPage(FileStorageService fileStorageService) {
        this.fileStorageService = fileStorageService;
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

    @GetMapping("/service/files/{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> serveFile(@PathVariable String filename) {

        Resource file = fileStorageService.loadAsResource(filename);
        return ResponseEntity
                .ok()
                .header(HttpHeaders.ACCEPT, "attachment; filename=\""+file.getFilename()+"\"")
                .body(file);
    }
}
