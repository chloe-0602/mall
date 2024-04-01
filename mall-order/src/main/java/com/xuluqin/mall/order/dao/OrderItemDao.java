package com.xuluqin.mall.order.dao;

import com.xuluqin.mall.order.entity.OrderItemEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 订单项信息
 * 
 * @author xuluqin
 * @email 13262816312@163.com
 * @date 2024-04-01 16:15:52
 */
@Mapper
public interface OrderItemDao extends BaseMapper<OrderItemEntity> {
	
}
