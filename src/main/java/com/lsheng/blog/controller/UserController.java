package com.lsheng.blog.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lsheng.blog.common.ResponseCode;
import com.lsheng.blog.common.ResponseInfo;
import com.lsheng.blog.entity.User;
import com.lsheng.blog.service.UserService;
import com.lsheng.blog.util.JwtUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zhonglunsheng
 * @since 2020-08-02
 */
@Controller
@RequestMapping("/admin/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String redict(HttpServletResponse response) throws IOException {
        return "forword:/index2.html";
    }

    @PostMapping("/login")
    @ResponseBody
    public ResponseInfo login(@RequestBody User user) {
        if (user != null) {
            List<User> result = userService.list(new QueryWrapper<>(user, "user_name", "password"));
            if (result == null) {
                return ResponseInfo.createResponseInfoByEnum(ResponseCode.LOGIN_ERROR, null);
            }
            // 生成jwt-token
            String token = JwtUtil.geneJsonWebToken(result.get(0));
            return ResponseInfo.createResponseInfoByEnum(ResponseCode.SUCCESS, token);
        }
        return ResponseInfo.createResponseInfoByEnum(ResponseCode.LOGIN_ERROR, null);
    }

}

