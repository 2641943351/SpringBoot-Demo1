package com.edu.seiryo.controller;


import com.edu.seiryo.dto.TreeDto;
import com.edu.seiryo.model.RespBean;
import com.edu.seiryo.pojo.GoodsType;
import com.edu.seiryo.service.GoodsTypeService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author TianTian
 * @date 2022/1/19 8:36
 */
@Controller
@RequestMapping("/goodsType")
public class GoodsTypeController {

	@Resource
    private GoodsTypeService goodsTypeService;

    //查询所有商品类别（树状图）
    @RequestMapping("queryAllGoodsTypes")
    @ResponseBody
    public List<TreeDto> queryAllGoodsTypes(){

    	return goodsTypeService.queryAllGoodsTypes();

    }

}
