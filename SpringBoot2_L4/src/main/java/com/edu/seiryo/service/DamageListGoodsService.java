package com.edu.seiryo.service;

import com.edu.seiryo.pojo.DamageListGoods;
import com.baomidou.mybatisplus.extension.service.IService;
import com.edu.seiryo.query.DamageListGoodsQuery;

import java.util.Map;

/**
 * 报损单商品服务表
 * @author TianTian
 * @date 2022/1/21 13:42
 */
public interface DamageListGoodsService extends IService<DamageListGoods> {

    Map<String, Object> damageListGoodsList(DamageListGoodsQuery damageListGoodsQuery);
}
