package com.rhb.blog.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.rhb.blog.domain.R;
import com.rhb.blog.domain.Role;

public interface IRoleService {
    R<Page<Role>> getRoleList(int page, int size);

    R<Role> getRoleById(Integer roleId);

    R<Boolean> addRole(Role role);

    R<Boolean> updateRole(Role role);

    R<Boolean> deleteRole(Integer roleId);
}
