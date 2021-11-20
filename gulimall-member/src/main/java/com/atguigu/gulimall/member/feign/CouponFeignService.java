package com.atguigu.gulimall.member.feign;

import com.atguigu.common.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

//用来调用远程服务，参数是服务名
@FeignClient("gulimall-coupon")
public interface CouponFeignService {
    //要调用的远程服务的方法
    @RequestMapping("/coupon/coupon/member/list")
    public R membercoupons();
}
