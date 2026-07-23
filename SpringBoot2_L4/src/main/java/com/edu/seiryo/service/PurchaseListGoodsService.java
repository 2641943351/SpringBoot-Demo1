package com.edu.seiryo.service;

import com.edu.seiryo.pojo.PurchaseListGoods;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.edu.seiryo.query.PurchaseListGoodsQuery;

import java.util.Map;

/**
 * 进货单商品表服务类
 * @author TianTian
 * @date 2022/1/19 13:58
 */
public interface PurchaseListGoodsService extends IService<PurchaseListGoods> {

	IPage<PurchaseListGoods> selectPurchaseListGoodsPage(Page<PurchaseListGoods> page,Wrapper<PurchaseListGoods> wrapper);
	
}
