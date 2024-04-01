package com.xuluqin.mall.member.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xuluqin.common.utils.PageUtils;
import com.xuluqin.mall.member.entity.MemberReceiveAddressEntity;

import java.util.Map;

/**
 * 会员收货地址
 *
 * @author xuluqin
 * @email 13262816312@163.com
 * @date 2024-04-01 15:46:10
 */
public interface MemberReceiveAddressService extends IService<MemberReceiveAddressEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

