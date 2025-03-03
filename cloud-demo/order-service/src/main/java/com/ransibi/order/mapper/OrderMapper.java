package com.ransibi.order.mapper;

import com.ransibi.order.pojo.Order;

public interface OrderMapper {

    Order findById(Long id);
}
