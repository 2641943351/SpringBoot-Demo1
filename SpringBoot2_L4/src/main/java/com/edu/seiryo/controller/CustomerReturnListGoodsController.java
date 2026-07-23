package com.edu.seiryo.controller;


import com.edu.seiryo.query.CustomerReturnListGoodsQuery;
import com.edu.seiryo.service.CustomerReturnListGoodsService;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Map;

/**
 * 客户退货单商品表
 * @author TianTian
 * @date 2022/1/19 22:59
 */
@Controller
@RequestMapping("/customerReturnListGoods")
public class CustomerReturnListGoodsController {
    @Resource
    private CustomerReturnListGoodsService customerReturnListGoodsService;

    @RequestMapping("list")
    @ResponseBody
    public Map<String,Object> customerReturnListGoodsList(CustomerReturnListGoodsQuery customerReturnListGoodsQuery){
        return customerReturnListGoodsService.customerReturnListGoodsList(customerReturnListGoodsQuery);
    }
}
