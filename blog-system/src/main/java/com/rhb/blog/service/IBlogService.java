package com.rhb.blog.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.rhb.blog.domain.Blog;
import com.rhb.blog.domain.R;
import com.rhb.blog.domain.Role;

public interface IBlogService {
    R<Page<Blog>> getBlogList(int page, int size);

    R<Blog> getBlogById(Integer blogId);

    R<Boolean> addBlog(Blog blog);

    R<Boolean> updateBlog(Blog blog);

    R<Boolean> deleteBlog(Integer blogId);
}
