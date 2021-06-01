package com.lzcoke.controller;

import com.lzcoke.mapper.UserMapper;
import com.lzcoke.pojo.Login;
import com.lzcoke.pojo.User;
import com.lzcoke.utils.MybatisUtils;
import com.lzcoke.utils.RedisUtils;
import com.lzcoke.utils.ResultUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@Api(tags = "登录接口")
public class LoginController {

    @Autowired
    private RedisUtils redisUtils;

    @ApiOperation(value = "用户登录", notes = "用户通过邮箱密码登录")
    @PostMapping("/login")
    public ResultUtils<User> index(@RequestBody Login map) {
        ResultUtils resultData = new ResultUtils();
        Map<String, Object> data = new HashMap<>();
        resultData.setData(data);

        String email = map.getEmail();
        String password = map.getPassword();
        if (email == null || password == null) {
            resultData.setCode(500);
            resultData.setMessage("账号密码不存在");
        } else {
            SqlSession sqlSession = MybatisUtils.getSqlSession();
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            User user = mapper.Login(email, password);
            if (user == null) {
                resultData.setCode(500);
                resultData.setMessage("账号密码不存在");
            } else {
                // 登录成功返回token
                resultData.setCode(200);
                resultData.setMessage("登录成功");
                redisUtils.set("token_" + user.getUser_id(), user.getUser_id());
                HashMap<String, Object> objectObjectHashMap = new HashMap<>();
                objectObjectHashMap.put("user", user);
                objectObjectHashMap.put("token", user.getUser_id());
                resultData.setData(objectObjectHashMap);
            }
            sqlSession.close();
        }
        return resultData;
    }

    @ApiOperation(value = "拦截器返回", notes = "用户请求头未提交token", hidden = true)
    @RequestMapping("/500")
    public ResultUtils<Map> result() {
        Map<String, Object> data = new HashMap<>();
        ResultUtils resultData = new ResultUtils();
        resultData.setCode(500);
        resultData.setMessage("未登录账号，请登录");
        resultData.setData(data);
        return resultData;
    }
}
