package com.edu.seiryo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.edu.seiryo.dto.TreeDto;
import com.edu.seiryo.mapper.MenuMapper;
import com.edu.seiryo.pojo.Menu;
import com.edu.seiryo.service.MenuService;
import com.edu.seiryo.service.RoleMenuService;
import com.edu.seiryo.utils.AssertUtil;
import com.edu.seiryo.utils.PageResultUtil;
import com.edu.seiryo.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements MenuService {

	@Override
    public List<TreeDto> listAllMenu() {
        return baseMapper.listAllMenu();
    }
	
	@Override
	public boolean deleteMenu(Integer id) {

	    QueryWrapper<Menu> wrapper = new QueryWrapper<>();
	    wrapper.eq("p_id", id);

	    Integer count = count(wrapper);

	    AssertUtil.isTrue(count > 0, "存在子级菜单，无法删除");

	    return removeById(id);
	}
	
}

