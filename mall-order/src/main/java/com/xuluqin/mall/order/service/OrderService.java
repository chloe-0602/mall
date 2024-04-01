package com.xuluqin.mall.order.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xuluqin.common.utils.PageUtils;
import com.xuluqin.mall.order.entity.OrderEntity;

import java.util.Map;

/**
 * 订单
 *
 * @author xuluqin
 * @email 13262816312@163.com
 * @date 2024-04-01 16:15:52
 */
public interface OrderService extends IService<OrderEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

