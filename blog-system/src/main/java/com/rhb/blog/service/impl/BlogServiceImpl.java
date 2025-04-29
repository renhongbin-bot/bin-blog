package com.rhb.blog.service.impl;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.rhb.blog.domain.Blog;
import com.rhb.blog.domain.R;
import com.rhb.blog.domain.Role;
import com.rhb.blog.mapper.BlogMapper;
import com.rhb.blog.mapper.RoleMapper;
import com.rhb.blog.service.IBlogService;
import com.rhb.blog.service.IRoleService;
import com.rhb.blog.utils.CommonUtil;
import com.rhb.blog.utils.ResponseUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class BlogServiceImpl extends ServiceImpl<BlogMapper, Blog> implements IBlogService {
    private final BlogMapper blogMapper;

    @Override
    public R<Page<Blog>> getBlogList(int page, int size) {
        Page<Blog> pageInfo = new Page<>(page, size);
        blogMapper.selectPage(pageInfo, null);
        return ResponseUtil.success(pageInfo);
    }

    @Override
    public R<Blog> getBlogById(Integer blogId) {
        Blog role = blogMapper.selectById(blogId);
        if (role != null) {
            return ResponseUtil.success(role);
        } else {
            return ResponseUtil.fail("文章未找到");
        }
    }

    @Override
    public R<Boolean> addBlog(Blog blog) {
        try {
            blog.setCreateAt(LocalDateTime.now());
            int result = blogMapper.insert(blog);
            return CommonUtil.handleResult(result, "添加文章失败");
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return ResponseUtil.fail("添加文章时发生异常");
        }
    }

    @Override
    public R<Boolean> updateBlog(Blog blog) {
        try {
            blog.setUpdateAt(LocalDateTime.now());
            int result = blogMapper.updateById(blog);
            return CommonUtil.handleResult(result, "更新文章失败");
        } catch (Exception e) {
            return ResponseUtil.fail("更新文章时发生异常");
        }
    }

    @Override
    public R<Boolean> deleteBlog(Integer blogId) {
        try {
            int result = blogMapper.deleteByBlogId(blogId);
            return CommonUtil.handleResult(result, "删除文章失败");
        } catch (Exception e) {
            return ResponseUtil.fail("删除文章时发生异常");
        }
    }
}
