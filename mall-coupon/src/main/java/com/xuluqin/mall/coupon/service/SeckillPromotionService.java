package com.xuluqin.mall.coupon.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xuluqin.common.utils.PageUtils;
import com.xuluqin.mall.coupon.entity.SeckillPromotionEntity;

import java.util.Map;

/**
 * 秒杀活动
 *
 * @author xuluqin
 * @email 13262816312@163.com
 * @date 2024-04-01 13:20:04
 */
public interface SeckillPromotionService extends IService<SeckillPromotionEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

