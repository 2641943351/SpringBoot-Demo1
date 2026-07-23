package com.edu.seiryo.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.edu.seiryo.model.RespBean;
import com.edu.seiryo.pojo.PurchaseList;
import com.edu.seiryo.pojo.Supplier;
import com.edu.seiryo.query.SupplierQuery;
import com.edu.seiryo.service.PurchaseListService;
import com.edu.seiryo.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/supplier")
public class SupplierController {

	// 注入 供应商业务类
	@Autowired
	private SupplierService supplierService;
	
	// 注入 进货单服务类
	@Autowired
	private PurchaseListService purchaseListService;
	
    @RequestMapping("index" )
    public String index(){
        return "/supplier/supplier";
    }
    
    // 前往 新增/修改页面 前的 数据传递 控制方法
    @RequestMapping("addOrUpdateSupplierPage")
    public String addOrUpdateSupplierPage(Integer id, Model model){
    	// 判断前台是否传入id（有则判断为update业务）
        if(id != null){
        	// 使用传入的ID查找需要修改的对象
        	Supplier supplier = supplierService.getById(id);
        	// 将查询到的需要修改的对象放入model中相应给前台
        	model.addAttribute("supplier", supplier);
        }
        // 前往addOrUpdateSupplier页面
        return "/supplier/add_update";
    }
    
    // 供应商打印方法
    @RequestMapping("list")
    // 以JSON形式返回给页面
    @ResponseBody
    // SupplierQuery 存放的是前台请求携带的参数（请求参数），SpringMVC 自动将这些参数封装到 SupplierQuery 对象中。
    public Map<String,Object> list(SupplierQuery supplierQuery){
    	/*
    	 *  创建 MyBatis 分页查询对象
    	 *  supplierQuery.getPage() 在前台发送的一系列参数中，取出当前页参数
    	 *  supplierQuery.getLimit() 在前台发送的一系列参数中，取出每页显示数量的参数
    	 */
        Page<Supplier> page = new Page<>(supplierQuery.getPage(), supplierQuery.getLimit());
        
        /* 创建 MyBatis 查询 条件 构造器。
         * 	用于  分页的同时进行条件查询
         *	 相当于创建一个"查询条件"对象，后面所有的 where 条件都往里面加。
         */
        QueryWrapper<Supplier> queryWrapper = new QueryWrapper<>();
        
        // 判断前台是否传入查询参数 SupplierName
        if (supplierQuery.getSupplierName() != null && !supplierQuery.getSupplierName().trim().isEmpty()) {
        	// 将其存入 queryWrapper 条件构造器，添加一个查询条件
            queryWrapper.like("name", supplierQuery.getSupplierName());
        }

        // 将设置好的分页数据与查询条件，添加到page对象
        supplierService.page(page,queryWrapper);

        Map<String,Object> map = new HashMap<>();

        map.put("code",0);
        map.put("msg","");
        map.put("count",page.getTotal());
        map.put("data",page.getRecords());

        return map;
    }
    
    // 新增方法
    @RequestMapping("save")
    @ResponseBody
    public RespBean save(Supplier supplier) {
    	
        boolean flag = supplierService.save(supplier);

        if (flag) {
        	// 使用RespBean自动打包JSON类，返回给页面
            return RespBean.success("添加成功");
        } else {
            return RespBean.error("添加失败");
        }
    }
    
    // 修改方法
    @RequestMapping("update")
    @ResponseBody
    public RespBean update(Supplier supplier){

        boolean flag = supplierService.updateById(supplier);

        if(flag){
            return RespBean.success("修改成功");
        }else{
            return RespBean.error("修改失败");
        }
    }
    
    // 删除方法、批量删除方法通用控制类
    @RequestMapping("delete")
    @ResponseBody
    public RespBean delete(Integer[] ids){

    	// 判断供应商是否已经被采购记录使用
        int count = purchaseListService.count(new QueryWrapper<PurchaseList>().in("supplier_id", ids));
        // 存在采购记录，不允许删除
        if(count > 0){
            return RespBean.error("该供应商已有采购记录，不能删除！");
        }
        // 不存在关联数据，执行删除
        boolean flag = supplierService.removeByIds(Arrays.asList(ids));
        // 判断删除结果
        if(flag){
            return RespBean.success("删除成功");
        }else{
            return RespBean.error("删除失败");
        }
    }
    
    // 给下单页面提供供货商信息
    @RequestMapping("allGoodsSuppliers")
    @ResponseBody
    public List<Supplier> allGoodsSuppliers(){

        return supplierService.list();

    }
    
}
