package com.rhb.blog.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@TableName("blog")
@Schema(name = "Blog", description = "文章实体")
public class Blog implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableId(value = "blog_id", type = IdType.AUTO)//指定自增策略
    @Schema(description = "文章Id")
    private Integer blogId;

    @Schema(description = "文章标题")
    @NotNull(message = "文章标题不能为空")
    private String title;

    @Schema(description = "分类ID")
    @NotNull(message = "分类不能为空")
    private String categoryId;

    @Schema(description = "标签列表")
    private String tagList;

    @Schema(description = "文章封面")
    @NotNull(message = "封面不能为空")
    private String cover;

    @Schema(description = "文章状态")
    private Integer status;

    @Schema(description = "浏览次数")
    private Integer hot;

    @Schema(description = "排序")
    private Integer sort;

    @Schema(description = "文章内容")
    @NotNull(message = "文章内容不能为空")
    private String content;

    @Schema(description = "创建时间")
    private LocalDateTime createAt;

    @Schema(description = "更新时间")
    private LocalDateTime updateAt;

    @Schema(description = "是否删除")
    private Integer isDelete;


}
