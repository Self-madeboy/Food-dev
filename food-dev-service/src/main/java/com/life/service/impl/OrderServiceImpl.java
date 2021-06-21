package com.life.service.impl;

import com.life.common.enums.YesOrNo;
import com.life.pojo.Orders;
import com.life.pojo.UserAddress;
import com.life.pojo.bo.SubmitOrderBO;
import com.life.pojo.vo.OrderVO;
import com.life.service.AddressService;
import com.life.service.OrderService;
import org.n3r.idworker.Sid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author jc
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private Sid sid;
    @Autowired
    private AddressService addressService;

    @Override
    public OrderVO createOrder(SubmitOrderBO submitOrderBO) {
//        String userId = submitOrderBO.getUserId();
//        String addressId = submitOrderBO.getAddressId();
//        String itemSpecIds = submitOrderBO.getItemSpecIds();
//        Integer payMethod = submitOrderBO.getPayMethod();
//        String leftMsg = submitOrderBO.getLeftMsg();
//        // 包邮费用设置为0
//        Integer postAmount = 0;
//        String orderId = sid.nextShort();
//        UserAddress address = addressService.queryUserAddres(userId, addressId);
//        // 1. 新订单数据保存
//        Orders newOrder = new Orders();
//        newOrder.setId(orderId);
//        newOrder.setUserId(userId);
//        newOrder.setReceiverName(address.getReceiver());
//        newOrder.setReceiverMobile(address.getMobile());
//        newOrder.setReceiverAddress(address.getProvince() + " "
//                + address.getCity() + " "
//                + address.getDistrict() + " "
//                + address.getDetail());
//        newOrder.setTotalAmount();
////        newOrder.setRealPayAmount();
//        newOrder.setPostAmount(postAmount);
//
//        newOrder.setPayMethod(payMethod);
//        newOrder.setLeftMsg(leftMsg);
//
//        newOrder.setIsComment(YesOrNo.NO.type);
//        newOrder.setIsDelete(YesOrNo.NO.type);
//        newOrder.setCreatedTime(new Date());
//        newOrder.setUpdatedTime(new Date());
        return null;
    }
}
