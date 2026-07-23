package com.edu.seiryo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.edu.seiryo.pojo.Supplier;
import com.edu.seiryo.query.SupplierQuery;

import java.util.Map;

/**
 * 供应商服务类
 * @author TianTian
 * @date 2022/1/19 13:59
 */
// 继承了IService，自带了大量基础 CRUD 方法
public interface SupplierService extends IService<Supplier> {

}
