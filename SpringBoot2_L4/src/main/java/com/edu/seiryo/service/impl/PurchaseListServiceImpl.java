package com.edu.seiryo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.edu.seiryo.model.CountResultModel;
import com.edu.seiryo.pojo.Goods;
import com.edu.seiryo.pojo.PurchaseList;
import com.edu.seiryo.mapper.PurchaseListMapper;
import com.edu.seiryo.pojo.PurchaseListGoods;
import com.edu.seiryo.query.PurchaseListQuery;
import com.edu.seiryo.service.GoodsService;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.edu.seiryo.service.GoodsTypeService;
import com.edu.seiryo.service.PurchaseListGoodsService;
import com.edu.seiryo.service.PurchaseListService;
import com.edu.seiryo.utils.AssertUtil;
import com.edu.seiryo.utils.DateUtil;
import com.edu.seiryo.utils.PageResultUtil;
import com.edu.seiryo.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 进货单 服务实现类
 * </p>
 *
 * @author 老李
 */
@Service
public class PurchaseListServiceImpl extends ServiceImpl<PurchaseListMapper, PurchaseList> implements PurchaseListService {

	// 生成单号方法
	@Override
	public String createPurchaseNumber() {

	    // 获取当前日期 yyyyMMdd
	    String date = new SimpleDateFormat("yyyyMMdd").format(new Date());

	    // 查询当天已有多少进货单
	    QueryWrapper<PurchaseList> wrapper = new QueryWrapper<>();

	    wrapper.likeRight("purchase_number", "JH" + date);

	    int count = this.count(wrapper);

	    // 生成三位流水号
	    String serialNumber = String.format("%03d", count + 1);

	    return "JH" + date + serialNumber;
	}

}
