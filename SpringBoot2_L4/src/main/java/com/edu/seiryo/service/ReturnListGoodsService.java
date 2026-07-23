package com.edu.seiryo.service;

import com.edu.seiryo.pojo.ReturnListGoods;
import com.baomidou.mybatisplus.extension.service.IService;
import com.edu.seiryo.query.ReturnListGoodsQuery;

import java.util.Map;

/**
 * <p>
 * 退货单商品表 服务类
 * </p>
 *
 * @author 老李
 */
public interface ReturnListGoodsService extends IService<ReturnListGoods> {

    Map<String, Object> returnListGoodsList(ReturnListGoodsQuery returnListGoodsQuery);
}
