package com.rhb.blog.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.rhb.blog.domain.Blog;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BlogMapper extends BaseMapper<Blog> {
    int deleteByBlogId(Integer blogId);
}
