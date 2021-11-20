package com.atguigu.gulimall.order.dao;

import com.atguigu.gulimall.order.entity.OrderSettingEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 订单配置信息
 *
 * @author xueleichen
 * @email xueleichen@mall.com
 * @date 2021-11-07 14:41:56
 */
@Mapper
public interface OrderSettingDao extends BaseMapper<OrderSettingEntity> {

}
