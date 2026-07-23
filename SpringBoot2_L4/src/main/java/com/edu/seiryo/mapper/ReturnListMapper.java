package com.edu.seiryo.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.edu.seiryo.pojo.ReturnList;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.edu.seiryo.query.ReturnListQuery;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 退货单表 Mapper 接口
 * </p>
 *
 * @author 老李
 * @since 2021-03-27
 */
public interface ReturnListMapper extends BaseMapper<ReturnList> {

    String  getNextReturnNumber();

    IPage<ReturnList>  returnList(IPage<ReturnList> page, @Param("returnListQuery") ReturnListQuery returnListQuery);
}
