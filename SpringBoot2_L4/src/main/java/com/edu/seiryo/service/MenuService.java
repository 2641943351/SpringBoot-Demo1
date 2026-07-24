package com.edu.seiryo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.edu.seiryo.dto.TreeDto;
import com.edu.seiryo.pojo.Menu;
import com.edu.seiryo.utils.PageResultUtil;
import io.swagger.models.auth.In;

import javax.lang.model.type.IntersectionType;
import java.util.List;
import java.util.Map;
/**
 * 菜单表服务类
 * @author TianTian
 * @date 2022/1/19 13:57
 */
public interface MenuService extends IService<Menu> {

	/**
     * 查询所有菜单（树形）
     */
    List<TreeDto> listAllMenu();
	
}
