package com.lzcoke.controller;

import com.lzcoke.pojo.User;
import com.lzcoke.utils.ResultUtils;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(tags = "用户接口", hidden = true)
public class UserController {
    @GetMapping("/user")
    public ResultUtils<User> index() {
        User user = new User();
        ResultUtils resultData = new ResultUtils();
        resultData.setCode(200);
        resultData.setData(user);
        return resultData;
    }
}
