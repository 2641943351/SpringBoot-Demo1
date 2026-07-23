package com.edu.seiryo.controller;

import com.edu.seiryo.model.RespBean;
import com.edu.seiryo.pojo.PurchaseList;
import com.edu.seiryo.service.PurchaseListService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 进货单控制器
 * @author TianTian
 * @date 2022/1/19 12:32
 */
@Controller
@RequestMapping("/purchase")
public class PurchaseListController {

	// 注入 进货单服务类
	@Autowired
	private PurchaseListService purchaseListService;

	// 进货入库主页跳转
	@RequestMapping("index")
	public String index(Model model){

	    // 生成进货单号方法
	    String purchaseNumber = purchaseListService.createPurchaseNumber();
	    
	    model.addAttribute("purchaseNumber", purchaseNumber);
	    
	    return "purchase/purchase";
	}
	
    // 保存进货单
    @RequestMapping("save")
    @ResponseBody
    public RespBean save(PurchaseList purchaseList, String goodsJson){
    	purchaseListService.save(purchaseList);
        return RespBean.success("添加成功");
    }
}
