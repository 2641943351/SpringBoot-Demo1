package com.edu.seiryo.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.edu.seiryo.pojo.CustomerReturnList;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.edu.seiryo.query.CustomerReturnListQuery;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 客户退货单表 Mapper 接口
 * </p>
 *
 * @author 老李
 */
public interface CustomerReturnListMapper extends BaseMapper<CustomerReturnList> {

    String  getNextCustomerReturnNumber();

    IPage<CustomerReturnList>  customerReturnList(IPage<CustomerReturnList> page, @Param("customerReturnListQuery") CustomerReturnListQuery customerReturnListQuery);
}
