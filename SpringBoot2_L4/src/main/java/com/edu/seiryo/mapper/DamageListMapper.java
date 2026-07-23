package com.edu.seiryo.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.edu.seiryo.pojo.DamageList;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.edu.seiryo.query.DamageListQuery;
import org.apache.ibatis.annotations.Param;
import org.springframework.test.context.ActiveProfiles;

/**
 * 报损单 Mapper接口
 * @author TianTian
 * @date 2022/1/21 14:03
 */
public interface DamageListMapper extends BaseMapper<DamageList> {

    String  getNextDamageNumber();

    IPage<DamageList>  damageList(IPage<DamageList> page, @Param("damageListQuery") DamageListQuery damageListQuery);
}
