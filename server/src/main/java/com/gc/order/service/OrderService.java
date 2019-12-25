package com.gc.order.service;

import com.gc.order.dto.OrderDTO;

public interface OrderService {

    OrderDTO create(OrderDTO orderDTO);

    OrderDTO finish(String orderId);
}
