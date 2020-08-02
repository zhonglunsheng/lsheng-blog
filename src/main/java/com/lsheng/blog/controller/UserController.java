package com.lsheng.blog.controller;


import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zhonglunsheng
 * @since 2020-08-02
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String redict(HttpServletResponse response) throws IOException {
        return "forword:/index2.html";
    }
}

