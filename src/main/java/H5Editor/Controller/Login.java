package h5editor.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by MrCJ on 2016/12/8.
 */
@Controller
@Api("登录相关的API")
public class Login {

    @ApiOperation("登录界面")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query", name = "username", dataType = "String", value="用户名", required=true),
            @ApiImplicitParam(paramType="query", name = "password", dataType = "String", value="密码", required=true)
    })
    @GetMapping("/login")
    public String login() {
        return "Login";
    }
}
