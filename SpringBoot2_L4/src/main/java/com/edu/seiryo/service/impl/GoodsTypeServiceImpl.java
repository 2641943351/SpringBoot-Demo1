package com.edu.seiryo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.edu.seiryo.dto.TreeDto;
import com.edu.seiryo.pojo.GoodsType;
import com.edu.seiryo.mapper.GoodsTypeMapper;
import com.edu.seiryo.service.GoodsTypeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.edu.seiryo.utils.AssertUtil;
import com.edu.seiryo.utils.PageResultUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 商品表类型实现类
 * @author TianTian
 * @date 2022/1/19 14:51
 */
@Service
public class GoodsTypeServiceImpl extends ServiceImpl<GoodsTypeMapper, GoodsType> implements GoodsTypeService {

	@Override
	public List<TreeDto> queryAllGoodsTypes() {
		 List<GoodsType> goodsTypes = this.list();

		    List<TreeDto> treeDtos = new ArrayList<>();

		    for (GoodsType goodsType : goodsTypes) {

		    	TreeDto treeDto = new TreeDto();

		        treeDto.setId(goodsType.getId());
		        treeDto.setName(goodsType.getName());
		        treeDto.setpId(goodsType.getpId());

		        treeDtos.add(treeDto);
		    }
		    return treeDtos;
	}
	
}
