package com.lsheng.blog.service.impl;

import com.lsheng.blog.entity.Category;
import com.lsheng.blog.mapper.CategoryMapper;
import com.lsheng.blog.service.CategoryService;
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
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService {

}
