package com.edu.seiryo.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.edu.seiryo.model.RespBean;
import com.edu.seiryo.pojo.Goods;
import com.edu.seiryo.query.GoodsQuery;
import com.edu.seiryo.service.GoodsService;
import com.edu.seiryo.service.GoodsTypeService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

import java.util.HashMap;
import java.util.Map;

/**
 * 商品控制器
 * @author TianTian
 * @date 2022/1/18 22:50
 */
@Controller
@RequestMapping("/goods")
public class GoodsController {

	@Autowired
    private GoodsService goodsService;

    //	商品列表查询
    @RequestMapping("list")
    @ResponseBody
    public Map<String,Object> list(GoodsQuery goodsQuery){

    	// 分页对象
        Page<Goods> page = new Page<>(goodsQuery.getPage(),goodsQuery.getLimit());
        // 分页条件
        QueryWrapper<Goods> queryWrapper = new QueryWrapper<>();

        // 判断是否要商品名称搜索
        if(goodsQuery.getGoodsName()!=null && !goodsQuery.getGoodsName().trim().isEmpty()){
        	// 添加条件
            queryWrapper.like("name", goodsQuery.getGoodsName());
        }
        // 商品类别查询
        if(goodsQuery.getTypeId()!=null){
            queryWrapper.eq("type_id", goodsQuery.getTypeId());
        }
        
        goodsService.page(page,queryWrapper);
        
        Map<String,Object> map = new HashMap<>();

        map.put("code",0);
        map.put("msg","");
        map.put("count",page.getTotal());
        map.put("data",page.getRecords());

        return map;
    }
	
}
