package com.edu.seiryo.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.edu.seiryo.model.CountResultModel;
import com.edu.seiryo.pojo.PurchaseList;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.edu.seiryo.query.PurchaseListQuery;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 进货单接口
 * @author TianTian
 * @date 2022/1/21 18:27
 */
@Mapper
public interface PurchaseListMapper extends BaseMapper<PurchaseList> {

	IPage<PurchaseList> selectPurchaseListPage(Page<PurchaseList> page,@Param(Constants.WRAPPER) Wrapper<PurchaseList> wrapper);
	
	IPage<Map<String,Object>> countPurchase(Page<Map<String,Object>> page,@Param("query") PurchaseListQuery query);
	
}
