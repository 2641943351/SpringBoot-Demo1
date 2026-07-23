package com.edu.seiryo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.edu.seiryo.mapper.UserRoleMapper;
import com.edu.seiryo.pojo.UserRole;
import com.edu.seiryo.service.UserRoleService;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * 用户角色表服务类
 * @author TianTian
 * @date 2022/1/19 14:43
 */
@Service
public class userRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRole> implements UserRoleService{
    @Override
    public List<String> findRoleByUserName(String userName) {
       return this.baseMapper.findRoleByUserName(userName);
    }
}
