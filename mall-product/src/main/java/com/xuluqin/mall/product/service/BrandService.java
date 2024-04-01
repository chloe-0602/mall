package com.xuluqin.mall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xuluqin.common.utils.PageUtils;
import com.xuluqin.mall.product.entity.BrandEntity;

import java.util.Map;

/**
 * 品牌
 *
 * @author xuluqin
 * @email 13262816312@163.com
 * @date 2024-04-01 00:31:43
 */
public interface BrandService extends IService<BrandEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

