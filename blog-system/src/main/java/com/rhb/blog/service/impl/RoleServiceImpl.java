package com.rhb.blog.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.rhb.blog.domain.R;
import com.rhb.blog.domain.Role;
import com.rhb.blog.mapper.RoleMapper;
import com.rhb.blog.service.IRoleService;
import com.rhb.blog.utils.CommonUtil;
import com.rhb.blog.utils.ResponseUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements IRoleService {
    private final RoleMapper roleMapper;
    @Override
    public R<Page<Role>> getRoleList(int page, int size) {
        Page<Role> pageInfo = new Page<>(page, size);
        roleMapper.selectPage(pageInfo, null);
        return ResponseUtil.success(pageInfo);
    }

    @Override
    public R<Role> getRoleById(Integer roleId) {
        Role role = roleMapper.selectById(roleId);
        if (role != null) {
            return ResponseUtil.success(role);
        } else {
            return ResponseUtil.fail("角色未找到");
        }
    }

    @Override
    public R<Boolean> addRole(Role role) {
        try {
            System.out.println(role.getTitle());
            System.out.println(role.getIntroduction());
            role.setCreateAt(LocalDateTime.now());
            int result = roleMapper.insert(role);
            return CommonUtil.handleResult(result, "添加角色失败");
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return ResponseUtil.fail("添加角色时发生异常");
        }
    }

    @Override
    public R<Boolean> updateRole(Role role) {
        try {
            role.setUpdateAt(LocalDateTime.now());
            int result = roleMapper.updateById(role);
            return CommonUtil.handleResult(result, "更新角色失败");
        } catch (Exception e) {
            return ResponseUtil.fail("更新角色时发生异常");
        }
    }

    @Override
    public R<Boolean> deleteRole(Integer roleId) {
        try {
            int result = roleMapper.deleteByRoleId(roleId);
            return CommonUtil.handleResult(result, "删除角色失败");
        } catch (Exception e) {
            return ResponseUtil.fail("删除角色时发生异常");
        }
    }

}
