package com.edu.seiryo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.edu.seiryo.mapper.MenuMapper;
import com.edu.seiryo.mapper.RoleMenuMapper;
import com.edu.seiryo.pojo.Menu;
import com.edu.seiryo.pojo.RoleMenu;
import com.edu.seiryo.service.RoleMenuService;
import org.springframework.boot.autoconfigure.rsocket.RSocketProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoleMenuServiceImpl extends ServiceImpl<RoleMenuMapper, RoleMenu> implements RoleMenuService {
  @Override
  public List<Integer> queryExRoles(Integer roles) {
    return this.baseMapper.queryExRoles(roles);
  }

  @Override
  public List<String> findAuthoritiesByRoleName(List<String> roleName) {
      if (roleName.isEmpty()) {
          return roleName;
      }
      return this.baseMapper.findAuthoritiesByRoleName(roleName);
  }
}
