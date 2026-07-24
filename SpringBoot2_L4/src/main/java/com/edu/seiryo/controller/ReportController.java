package com.edu.seiryo.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 统计报表
 * @author TianTian
 * @date 2022/1/22 12:23
 */
@Controller
@RequestMapping("report")
public class ReportController {


    @RequestMapping("countSupplier")
    public String countSupplierPage(){
        return "count/supplier";
    }

    @RequestMapping("countCustomer")
    public String countCustomerPage(){
        return "count/customer";
    }

    // 商品采购统计页面
    @RequestMapping("countPurchase")
    public String countPurchase(){
        return "count/purchase";
    }

    /**
     * 商品销售统计
     * @return
     */
    @RequestMapping("countSale")
    public String countSale(){
        return "count/sale";
    }


    /**
     * 日销售统计
     * @return
     */
    @RequestMapping("countDaySale")
    public String countDaySale(){
        return "count/day_sale";
    }

    /**
     * 月销售统计
     * @return
     */
    @RequestMapping("countMonthSale")
    public String countMonthSale(){
        return "count/month_sale";
    }

}
