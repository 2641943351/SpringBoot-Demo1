	package com.edu.seiryo.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.edu.seiryo.model.RespBean;
import com.edu.seiryo.pojo.PurchaseList;
import com.edu.seiryo.query.PurchaseListQuery;
import com.edu.seiryo.service.PurchaseListService;
import com.edu.seiryo.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.security.Principal;

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

	@Autowired
	private UserService userService;

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
	public RespBean save(PurchaseList purchaseList, String goodsJson, Principal principal){

	    purchaseList.setUserId(userService.findForName(principal.getName()).getId());

	    // 判断供应商
	    if(purchaseList.getSupplierId() == null || purchaseList.getSupplierId() == 0){
	        return RespBean.error("请选择供应商");
	    }

	    // 判断商品
	    if(goodsJson == null || goodsJson.trim().equals("") || goodsJson.equals("[]")){
	        return RespBean.error("请选择进货商品");
	    }


	    // 判断商品数量
	    try {
	        ObjectMapper objectMapper = new ObjectMapper();
	        List<Map<String,Object>> goodsList = objectMapper.readValue(goodsJson, List.class);
	        
	        for(Map<String,Object> goods : goodsList){

	            Object numObj = goods.get("num");

	            if(numObj == null || Integer.parseInt(numObj.toString()) <= 0){
	                return RespBean.error("商品数量不能为0");
	            }
	        }

	    } catch (Exception e) {
	        return RespBean.error("商品数据格式错误");
	    }

	    purchaseListService.save(purchaseList);

	    return RespBean.success("添加成功");
	}
    

    //进货单查询页面
    @RequestMapping("/searchPage")
    public String search(){
        return "purchase/purchase_search";
    }
    
    /**
     * 	进货单列表查询
     */
    @RequestMapping("list")
    @ResponseBody
    public Map<String,Object> list(PurchaseListQuery purchaseListQuery){

        Page<PurchaseList> page =
                new Page<>(purchaseListQuery.getPage(), purchaseListQuery.getLimit());

        QueryWrapper<PurchaseList> queryWrapper = new QueryWrapper<>();

        if(purchaseListQuery.getPurchaseNumber()!=null
                && !purchaseListQuery.getPurchaseNumber().trim().isEmpty()){
            queryWrapper.like("purchase_number",
                    purchaseListQuery.getPurchaseNumber());
        }


        if(purchaseListQuery.getSupplierId()!=null){
            queryWrapper.eq("supplier_id",
                    purchaseListQuery.getSupplierId());
        }


        if(purchaseListQuery.getState()!=null){
            queryWrapper.eq("state",
                    purchaseListQuery.getState());
        }


        if(purchaseListQuery.getStartDate()!=null
                && !purchaseListQuery.getStartDate().trim().isEmpty()){

            queryWrapper.apply(
                "purchase_date >= TO_DATE('" 
                + purchaseListQuery.getStartDate()
                + " 00:00:00','YYYY-MM-DD HH24:MI:SS')"
            );
        }


        if(purchaseListQuery.getEndDate()!=null
                && !purchaseListQuery.getEndDate().trim().isEmpty()){

            queryWrapper.apply(
                "purchase_date <= TO_DATE('" 
                + purchaseListQuery.getEndDate()
                + " 23:59:59','YYYY-MM-DD HH24:MI:SS')"
            );
        }


        IPage<PurchaseList> result =
                purchaseListService.selectPurchaseListPage(page,queryWrapper);


        Map<String,Object> map=new HashMap<>();

        map.put("code",0);
        map.put("msg","");
        map.put("count",result.getTotal());
        map.put("data",result.getRecords());

        return map;
    }
    
    /**
     * 	删除进货单
     */
    @RequestMapping("delete")
    @ResponseBody
    public RespBean delete(Integer id){
    	
        boolean flag = purchaseListService.removeById(id);
        
        if(flag){
            return RespBean.success("删除成功");
        }else{
            return RespBean.error("删除失败");
        }

    }
    
    /**
     * 商品采购统计列表
     */
    @RequestMapping("countPurchase")
    @ResponseBody
    public Map<String,Object> countPurchase(PurchaseListQuery query){

        List<Map<String,Object>> list = purchaseListService.countPurchase(query);

        Map<String,Object> map=new HashMap<>();

        map.put("code",0);
        map.put("msg","");
        map.put("count",list.size());
        map.put("data",list);

        return map;
    }
}
