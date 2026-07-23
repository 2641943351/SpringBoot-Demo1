package com.edu.seiryo.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.edu.seiryo.mapper.GoodsUnitMapper;
import com.edu.seiryo.pojo.GoodsUnit;
import com.edu.seiryo.service.GoodsUnitService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsUnitServiceImpl extends ServiceImpl<GoodsUnitMapper, GoodsUnit> implements GoodsUnitService {
}

