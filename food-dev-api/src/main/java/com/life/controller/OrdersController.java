package com.life.controller;

import com.life.common.api.Result;
import com.life.common.enums.PayMethod;
import com.life.common.exception.Asserts;
import com.life.pojo.bo.SubmitOrderBO;
import com.life.pojo.vo.OrderVO;
import com.life.service.OrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author jc
 */
@Api(value = "订单相关", tags = {"订单相关的api接口"})
@RequestMapping("orders")
@RestController
public class OrdersController {
    @Autowired
    private OrderService orderService;

    @ApiOperation(value = "用户下单", notes = "用户下单", httpMethod = "POST")
    @PostMapping("/create")
    public Result create(@RequestBody SubmitOrderBO submitOrderBO,
                         HttpServletRequest request,
                         HttpServletResponse response) {
        Asserts.checkTrue(!submitOrderBO.getPayMethod().equals(PayMethod.WEIXIN.type)
                        && !submitOrderBO.getPayMethod().equals(PayMethod.ALIPAY.type),
                "支付方式不支持！");
        // 1. 创建订单
        OrderVO orderVO = orderService.createOrder(submitOrderBO);
        String orderId = orderVO.getOrderId();
        return null;
    }
}
