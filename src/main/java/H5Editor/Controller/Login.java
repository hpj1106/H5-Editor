package H5Editor.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by MrCJ on 2016/12/8.
 */
@Controller
public class Login {

    @GetMapping("/login")
    public String login() {
        return "login";
    }
}
