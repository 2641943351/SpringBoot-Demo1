package com.edu.seiryo.service;

import com.edu.seiryo.pojo.PurchaseList;
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

}
