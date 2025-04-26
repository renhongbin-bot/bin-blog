package com.rhb.blog.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.rhb.blog.domain.Role;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RoleMapper extends BaseMapper<Role> {
    int deleteByRoleId(Integer roleId);
}
