package H5Editor.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by MrCJ on 2016/12/5.
 */
@Controller
public class ShowPage {

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
}
