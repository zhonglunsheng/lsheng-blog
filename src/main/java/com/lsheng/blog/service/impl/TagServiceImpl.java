package com.lsheng.blog.service.impl;

import com.lsheng.blog.entity.Tag;
import com.lsheng.blog.mapper.TagMapper;
import com.lsheng.blog.service.TagService;
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
public class TagServiceImpl extends ServiceImpl<TagMapper, Tag> implements TagService {

}
