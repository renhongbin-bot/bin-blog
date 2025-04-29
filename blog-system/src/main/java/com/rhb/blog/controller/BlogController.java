package com.rhb.blog.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.rhb.blog.domain.Blog;
import com.rhb.blog.domain.R;
import com.rhb.blog.domain.Role;
import com.rhb.blog.service.IBlogService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/blog")
@Tag(name = "BlogController", description = "文章API")
public class BlogController {
    private final IBlogService blogService;
    @Operation(summary = "添加文章",description = "添加文章信息")
    @PostMapping
    public R<Boolean> addBlog(@Validated @RequestBody Blog blog) {
        return blogService.addBlog(blog);
    }

    @Operation(summary = "获取文章列表",description = "获取文章列表")
    @GetMapping("/list")
    public R<Page<Blog>> getBlogList(int page, int size) {
        return blogService.getBlogList(page, size);
    }

    @Operation(summary = "获取文章信息",description = "根据文章ID获取详情信息")
    @GetMapping("/{blogId}")
    public R<Blog> getBlogById(@PathVariable("blogId") Integer blogId) {
        return blogService.getBlogById(blogId);
    }

    @Operation(summary = "更新文章信息",description = "根据文章实体更新信息")
    @PutMapping
    public R<Boolean> updateBlog(@Validated @RequestBody Blog blog) {
        return blogService.updateBlog(blog);
    }

    @Operation(summary = "删除文章信息",description = "根据文章ID删除")
    @DeleteMapping("/{blogId}")
    public R<Boolean> deleteBlog(@PathVariable("blogId") Integer blogId) {
        return blogService.deleteBlog(blogId);
    }
}
