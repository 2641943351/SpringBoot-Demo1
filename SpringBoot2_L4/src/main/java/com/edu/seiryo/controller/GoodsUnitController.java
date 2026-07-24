package com.edu.seiryo.controller;


import com.edu.seiryo.pojo.GoodsUnit;
import com.edu.seiryo.service.GoodsUnitService;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author TianTian
 * @date 2022/1/19 8:54
 */
@Controller
@RequestMapping("/goodsUnit")
public class GoodsUnitController {

	@Resource
    private GoodsUnitService goodsUnitService;


    // 查询所有商品单位
    @RequestMapping("allGoodsUnits")
    @ResponseBody
    public List<GoodsUnit> allGoodsUnits(){

        return goodsUnitService.list();

    }

}
