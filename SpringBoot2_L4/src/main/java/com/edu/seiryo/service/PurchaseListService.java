package com.edu.seiryo.service;

import com.edu.seiryo.pojo.PurchaseList;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.edu.seiryo.pojo.PurchaseListGoods;
import com.edu.seiryo.query.PurchaseListQuery;

import java.util.List;
import java.util.Map;

/**
 * 进货单服务类
 * @author TianTian
 * @date 2022/1/19 13:58
 */
public interface PurchaseListService extends IService<PurchaseList> {
	
	// 生成单号
	String createPurchaseNumber();
	IPage<PurchaseList> selectPurchaseListPage(Page<PurchaseList> page,Wrapper<PurchaseList> wrapper);

	IPage<Map<String,Object>> countPurchase(Page<Map<String,Object>> page,PurchaseListQuery query);
	
}
