package com.lsheng.blog.service.impl;

import com.lsheng.blog.entity.User;
import com.lsheng.blog.mapper.UserMapper;
import com.lsheng.blog.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zhonglunsheng
 * @since 2020-08-02
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
