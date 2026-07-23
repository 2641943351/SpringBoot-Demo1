package com.edu.seiryo.service;

import com.edu.seiryo.dto.TreeDto;
import com.edu.seiryo.pojo.GoodsType;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
 * 商品类别表单服务类
 * @author TianTian
 * @date 2022/1/19 13:56
 */
public interface GoodsTypeService extends IService<GoodsType> {

	List<TreeDto> queryAllGoodsTypes();
	
}
