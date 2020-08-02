package com.lsheng.blog.service.impl;

import com.lsheng.blog.entity.Article;
import com.lsheng.blog.mapper.ArticleMapper;
import com.lsheng.blog.service.ArticleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 博客文章表 服务实现类
 * </p>
 *
 * @author zhonglunsheng
 * @since 2020-08-02
 */
@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article> implements ArticleService {

}
