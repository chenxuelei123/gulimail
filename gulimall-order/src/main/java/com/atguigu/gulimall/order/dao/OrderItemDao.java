package com.atguigu.gulimall.order.dao;

import com.atguigu.gulimall.order.entity.OrderItemEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 订单项信息
 *
 * @author xueleichen
 * @email xueleichen@mall.com
 * @date 2021-11-07 14:41:56
 */
@Mapper
public interface OrderItemDao extends BaseMapper<OrderItemEntity> {

}
