package com.edu.seiryo.controller;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.edu.seiryo.model.RespBean;
import com.edu.seiryo.pojo.DamageList;
import com.edu.seiryo.pojo.DamageListGoods;
import com.edu.seiryo.pojo.PurchaseListGoods;
import com.edu.seiryo.query.DamageListQuery;
import com.edu.seiryo.query.SaleListQuery;
import com.edu.seiryo.service.DamageListService;
import com.edu.seiryo.service.UserService;
import com.edu.seiryo.utils.AssertUtil;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.security.Principal;
import java.util.List;
import java.util.Map;

    /**
     * 报损表单控制器
     * @author TianTian
     * @date 2022/1/21 13:36
     */
@Controller
@RequestMapping("/damage")
public class DamageListController {

    @Resource
    private DamageListService damageListService;

    @Resource
    private UserService userService;


    /**
     * 商品报损主页
     * @return
     */
    @RequestMapping("index")
    public String index(Model model){
        model.addAttribute("damageNumber",damageListService.getNextDamageNumber());
        return "damage/damage";
    }

    @RequestMapping("save")
    @ResponseBody
    public RespBean save(DamageList damageList, String goodsJson, Principal principal){
        String userName = principal.getName();
        damageList.setUserId(userService.findForName(userName).getId());
        Gson gson = new Gson();
        List<DamageListGoods> plgList = gson.fromJson(goodsJson,new TypeToken<List<DamageListGoods>>(){}.getType());
        damageListService.saveDamageList(damageList,plgList);
        return RespBean.success("商品报损出库成功!");
    }


    @RequestMapping("list")
    @ResponseBody
    public Map<String,Object> damageList(DamageListQuery damageListQuery){
        return damageListService.damageList(damageListQuery);
    }


    @RequestMapping("delete")
    @ResponseBody
    public RespBean delete(Integer id) {
        damageListService.deletedamageList(id);
        return RespBean.success("删除成功");
    }

}
