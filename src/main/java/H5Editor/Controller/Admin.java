package H5Editor.Controller;

import H5Editor.Service.UserJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by MrCJ on 2016/12/19.
 */

@Controller
public class Admin {

    @Autowired
    private UserJson userJson;

    @RequestMapping(value = "/admin/getUserList",
                    method = RequestMethod.GET,
                    produces = "application/json")
    @ResponseBody
    public Object getUserList() {
        return userJson.getUserList();
    }


    @RequestMapping(value = "/admin/addUser",
            method = RequestMethod.POST,
            produces = "application/json")
    @ResponseBody
    public Object addUser() {
        return userJson.addUser();  //
    }

    @RequestMapping(value = "/admin/deleteUser",
            method = RequestMethod.POST,
            produces = "application/json")
    @ResponseBody
    public Object deleteUser() {
        return userJson.deleteUser();  //
    }

    @RequestMapping(value = "/admin/modifyUser",
            method = RequestMethod.POST,
            produces = "application/json")
    @ResponseBody
    public Object modifyUser() {
        return userJson.modifyUser();  //
    }


    @RequestMapping(value = "/admin/queryUser",
            method = RequestMethod.POST,
            produces = "application/json")
    @ResponseBody
    public Object queryUser() {
        return userJson.queryUser();  //
    }


}
