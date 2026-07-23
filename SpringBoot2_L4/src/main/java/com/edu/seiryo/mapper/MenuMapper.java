package com.edu.seiryo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.edu.seiryo.dto.TreeDto;
import com.edu.seiryo.pojo.Menu;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;
@Mapper
public interface MenuMapper extends BaseMapper<Menu> {

}
