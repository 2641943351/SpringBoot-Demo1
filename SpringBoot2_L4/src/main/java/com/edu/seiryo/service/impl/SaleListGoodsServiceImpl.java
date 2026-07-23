package com.edu.seiryo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.edu.seiryo.pojo.ReturnListGoods;
import com.edu.seiryo.pojo.SaleListGoods;
import com.edu.seiryo.mapper.SaleListGoodsMapper;
import com.edu.seiryo.query.saleListGoodsQuery;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.edu.seiryo.service.SaleListGoodsService;
import com.edu.seiryo.utils.AssertUtil;
import com.edu.seiryo.utils.PageResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 销售单销售表服务器
 * @author TianTian
 * @date 2022/1/19 14:42
 */
@Service
public class SaleListGoodsServiceImpl extends ServiceImpl<SaleListGoodsMapper, SaleListGoods> implements SaleListGoodsService {

    @Override
    public Integer getSaleTotalByGoodsId(Integer id) {
        SaleListGoods saleListGoods = this.getOne(new QueryWrapper<SaleListGoods>().select("sum(num) as num").eq("goods_id",id));
        return null == saleListGoods?0:saleListGoods.getNum();
    }


    @Override
    public Map<String, Object> saleListGoodsList(saleListGoodsQuery saleListGoodsQuery) {
        IPage<SaleListGoods> page = new Page<SaleListGoods>(saleListGoodsQuery.getPage(),saleListGoodsQuery.getLimit());
        QueryWrapper<SaleListGoods> queryWrapper =new QueryWrapper<SaleListGoods>();
        if(null != saleListGoodsQuery.getSaleListId()){
            queryWrapper.eq("sale_list_id",saleListGoodsQuery.getSaleListId());
        }
        page =  this.baseMapper.selectPage(page,queryWrapper);
        return PageResultUtil.setResult(page.getTotal(),page.getRecords());
    }


}
