package H5Editor.Controller;

import H5Editor.Model.File.FileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;

/**
 * Created by MrCJ on 2016/12/20.
 */
@Controller
public class User {

    @Autowired
    private FileRepository fileRepository;

    @RequestMapping(value = "/user/getFileList/{userId}",
                    method = RequestMethod.GET,
                    produces = "application/json")
    @ResponseBody
    public Object getFileList(@PathVariable("userId") int userId) {
        return fileRepository.findAll(new ArrayList<>());
    }
}
