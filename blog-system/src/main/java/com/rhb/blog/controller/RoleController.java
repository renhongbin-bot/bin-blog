package com.rhb.blog.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.rhb.blog.domain.R;
import com.rhb.blog.domain.Role;
import com.rhb.blog.service.IRoleService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/role")
@Tag(name = "RoleController", description = "角色API")
public class RoleController {
    private final IRoleService roleService;

    @Operation(summary = "添加角色",description = "添加角色信息")
    @PostMapping
    public R<Boolean> addRole(@Validated @RequestBody Role role) {
        return roleService.addRole(role);
    }

    @Operation(summary = "获取角色列表",description = "获取角色列表")
    @GetMapping("/list")
    public R<Page<Role>> getRoleList(int page, int size) {
        return roleService.getRoleList(page, size);
    }

    @Operation(summary = "获取角色信息",description = "根据角色ID获取角色详情信息")
    @GetMapping("/{roleId}")
    public R<Role> getRoleById(@PathVariable("roleId") Integer roleId) {
        return roleService.getRoleById(roleId);
    }

    @Operation(summary = "更新角色信息",description = "根据角色实体更新角色信息")
    @PutMapping
    public R<Boolean> updateRole(@Validated @RequestBody Role role) {
        return roleService.updateRole(role);
    }

    @Operation(summary = "删除角色信息",description = "根据角色ID删除角色")
    @DeleteMapping("/{roleId}")
    public R<Boolean> deleteRole(@PathVariable("roleId") Integer roleId) {
        return roleService.deleteRole(roleId);
    }


}
