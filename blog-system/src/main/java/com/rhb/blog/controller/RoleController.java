package com.rhb.blog.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.rhb.blog.domain.R;
import com.rhb.blog.domain.Role;
import com.rhb.blog.service.IRoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/role")
public class RoleController {
    private final IRoleService roleService;

    @PostMapping
    public R<Boolean> addRole(@RequestBody Role role) {
        return roleService.addRole(role);
    }

    @GetMapping("/list")
    public R<Page<Role>> getRoleList(int page, int size) {
        return roleService.getRoleList(page, size);
    }

    @GetMapping("/{roleId}")
    public R<Role> getRoleById(@PathVariable("roleId") Integer roleId) {
        return roleService.getRoleById(roleId);
    }

    @PutMapping
    public R<Boolean> updateRole(@RequestBody Role role) {
        return roleService.updateRole(role);
    }

    @DeleteMapping("/{roleId}")
    public R<Boolean> deleteRole(@PathVariable("roleId") Integer roleId) {
        return roleService.deleteRole(roleId);
    }


}
