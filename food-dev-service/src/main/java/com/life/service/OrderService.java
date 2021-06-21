package com.life.service;

import com.life.pojo.bo.SubmitOrderBO;
import com.life.pojo.vo.OrderVO;

public interface OrderService {
    /**
     * 创建订单
     * @param submitOrderBO
     * @return
     */
    OrderVO createOrder(SubmitOrderBO submitOrderBO);
}
