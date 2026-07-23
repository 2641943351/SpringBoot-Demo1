package com.edu.seiryo.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.edu.seiryo.pojo.PurchaseListGoods;
import com.edu.seiryo.query.PurchaseListGoodsQuery;
import com.edu.seiryo.query.PurchaseListQuery;
import com.edu.seiryo.service.PurchaseListGoodsService;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * 进货单商品表
 * @author TianTian
 * @date 2022/1/19 12:32
 */
@Controller
@RequestMapping("/purchaseListGoods")
public class PurchaseListGoodsController {

	@Resource
    private PurchaseListGoodsService purchaseListGoodsService;

    //查询进货单商品明细
	@RequestMapping("list")
	@ResponseBody
	public Map<String,Object> list(PurchaseListGoodsQuery query){

		if(query.getPurchaseListId()==null){

		    Map<String,Object> map = new HashMap<>();

		    map.put("code",0);
		    map.put("msg","");
		    map.put("count",0);
		    map.put("data",new ArrayList<>());

		    return map;
		}
		
	    Page<PurchaseListGoods> page =
	            new Page<>(query.getPage(), query.getLimit());

	    QueryWrapper<PurchaseListGoods> wrapper =
	            new QueryWrapper<>();

	    if(query.getPurchaseListId()!=null){
	        wrapper.eq("purchase_list_id",query.getPurchaseListId());
	    }


	    IPage<PurchaseListGoods> result = purchaseListGoodsService.selectPurchaseListGoodsPage(page,wrapper);


	    Map<String,Object> map = new HashMap<>();

	    map.put("code",0);
	    map.put("msg","");
	    map.put("count",result.getTotal());
	    map.put("data",result.getRecords());

	    return map;
    }

}
