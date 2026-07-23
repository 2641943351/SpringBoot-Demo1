package com.edu.seiryo.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.edu.seiryo.pojo.OverflowList;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.edu.seiryo.query.OverFlowListQuery;
import org.apache.ibatis.annotations.Param;

/**
 * 报溢单 Mapper接口
 * @author TianTian
 * @date 2022/1/21 14:04
 */
public interface OverflowListMapper extends BaseMapper<OverflowList> {

    String  getOverflowNumber();

    IPage<OverflowList> overFlowList(IPage<OverflowList> page,@Param("overFlowListQuery") OverFlowListQuery overFlowListQuery);
}
