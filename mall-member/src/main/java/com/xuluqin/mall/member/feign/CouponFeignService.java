package com.xuluqin.mall.member.feign;

import com.xuluqin.common.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/*
声明式远程调用
 */
@FeignClient("mall-coupon")
public interface CouponFeignService {
    // 如果我们以后调用接口的memberCoupons方法，就会去注册中心中找远程服务， 调用mall-coupon服务所在位置，然后再去调用/coupon/coupon/member/list这个请求对应的方法
    @RequestMapping("/coupon/coupon/member/list")
    public R memberCoupons();
}
