package com.lsheng.blog.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author zhonglunsheng
 * @since 2020-08-02
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("t_blog_category")
public class Category extends Model<Category> {

    private static final long serialVersionUID=1L;

    /**
     * 主键ID
     */
    private Integer id;

    /**
     * 分类名
     */
    private String categoryName;

    /**
     * 分类排序
     */
    private Integer categorySort;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
