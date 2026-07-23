package com.edu.seiryo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.edu.seiryo.pojo.Role;
import com.edu.seiryo.query.RoleQuery;

import java.util.List;
import java.util.Map;
/**
 * 角色表服务类
 * @author TianTian
 * @date 2022/1/19 13:59
 */
public interface RoleService extends IService<Role> {
    public Map<String, Object> roleList(RoleQuery roleQuery);
    public void saveRole (Role role);
    public void updateRole (Role role);
    public Role findRoleByRoleName(String roleName);
    public void deleteRole(Integer id);
    public List<Map<String, Object>> queryAllRoles(Integer userId);
    public void addRole(Integer[] mids,Integer roleId);

}
