package com.life.service;

import com.life.pojo.UserAddress;
import com.life.pojo.bo.AddressBO;

import java.util.List;

/**
 * @author jc
 */
public interface AddressService {
    /**
     * 查询收货id
     * @param userId
     * @return
     */
    List<UserAddress> queryAll(String userId);

    /**
     *添加地址
     * @param addressBO
     */
    void addNewUserAddress(AddressBO addressBO);

    /**
     * 更新地址
     * @param addressBO
     */
    void updateUserAddress(AddressBO addressBO);

    /**
     * delete user address
     * @param userId
     * @param addressId
     */
    void deleteUserAddress(String userId, String addressId);

    /**
     * 更新默认地址
     * @param userId
     * @param addressId
     */
    void updateUserAddressToBeDefault(String userId, String addressId);

    /**
     *根据用户id和地址id，查询具体的用户地址对象信息
     * @param userId
     * @param addressId
     * @return
     */
    UserAddress queryUserAddres(String userId, String addressId);
}
