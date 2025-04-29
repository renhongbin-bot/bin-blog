package com.rhb.blog.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Data
@TableName("role")
@Schema(name = "Role", description = "角色实体")
public class Role implements Serializable {
    private static final long serialVersionUID = 1L;
    @TableId(value = "role_id", type = IdType.AUTO)//指定自增策略
    @Schema(description = "角色Id")
    private Integer roleId;

    @Schema(description = "角色名称")
    @NotNull(message = "角色名称不能为空")
    private String title;

    @Schema(description = "角色介绍")
    private String introduction;

    @Schema(description = "创建时间")
    private LocalDateTime createAt;

    @Schema(description = "更新时间")
    private LocalDateTime updateAt;

    @Schema(description = "是否删除")
    private Integer isDelete;
}
