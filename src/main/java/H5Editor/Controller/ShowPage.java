package H5Editor.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by MrCJ on 2016/12/5.
 */
@Controller
public class ShowPage {

    @GetMapping("/")
    public String showIndex() {
        return "index";
    }

}
