package com.edu.seiryo.service;

import com.edu.seiryo.pojo.Goods;
import com.baomidou.mybatisplus.extension.service.IService;
import com.edu.seiryo.query.GoodsQuery;

import java.io.Serializable;
import java.util.Map;

/**
 * 商品表服务
 * @author TianTian
 * @date 2022/1/19 13:55
 */
public interface GoodsService extends IService<Goods> {

	/**
     * 商品分页查询
     */
    Map<String,Object> goodsList(GoodsQuery goodsQuery);

    /**
     * 修改期初库存
     */
    void updateStock(Goods goods);

    /**
     * 删除期初库存
     */
    void deleteStock(Integer id);
}
