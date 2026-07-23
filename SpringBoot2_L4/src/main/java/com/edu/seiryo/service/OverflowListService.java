package com.edu.seiryo.service;

import com.edu.seiryo.pojo.OverflowList;
import com.baomidou.mybatisplus.extension.service.IService;
import com.edu.seiryo.pojo.OverflowListGoods;
import com.edu.seiryo.query.OverFlowListQuery;

import java.util.List;
import java.util.Map;

/**
 * 报溢单服务类
 * @author TianTian
 * @date 2022/1/21 13:43
 */
public interface OverflowListService extends IService<OverflowList> {

    String getOverflowNumber();

    void saveOverflowList(OverflowList overflowList, List<OverflowListGoods> plgList);

    Map<String, Object> overFlowList(OverFlowListQuery overFlowListQuery);

    void deleteoverflowList(Integer id);
}
