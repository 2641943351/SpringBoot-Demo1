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
	
	@Override
	public void updateMenu(Menu menu) {

	    // 查询修改前的菜单
	    Menu oldMenu = getById(menu.getId());

	    // 计算层级变化
	    int change = menu.getGrade() - oldMenu.getGrade();

	    // 修改当前菜单
	    updateById(menu);

	    // 修改子菜单层级
	    if(change != 0){
	        updateChildGrade(menu.getId(), change);
	    }
	}
	
	/**
	 * 修改子菜单层级
	 */
	private void updateChildGrade(Integer parentId, int change) {

	    QueryWrapper<Menu> wrapper = new QueryWrapper<>();
	    wrapper.eq("p_id", parentId);

	    List<Menu> children = list(wrapper);

	    for (Menu child : children) {

	        int newGrade = child.getGrade() + change;

	        // 最大三级，最小一级
	        if (newGrade > 2) {
	            newGrade = 2;
	        }
	        if (newGrade < 0) {
	            newGrade = 0;
	        }

	        child.setGrade(newGrade);

	        updateById(child);

	        // 继续处理孙菜单
	        updateChildGrade(child.getId(), change);
	    }
	}
}

