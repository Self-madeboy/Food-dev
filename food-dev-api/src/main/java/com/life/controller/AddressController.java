package com.life.controller;

import com.life.common.api.Result;
import com.life.common.exception.Asserts;
import com.life.common.util.MobileEmailUtils;
import com.life.pojo.UserAddress;
import com.life.pojo.bo.AddressBO;
import com.life.service.AddressService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.n3r.idworker.Sid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author jc
 */
@Api(value = "地址相关", tags = {"地址相关的api接口"})
@RequestMapping("address")
@RestController
public class AddressController {
    /**
     * 用户在确认订单页面，可以针对收货地址做如下操作：
     * 1. 查询用户的所有收货地址列表
     * 2. 新增收货地址
     * 3. 删除收货地址
     * 4. 修改收货地址
     * 5. 设置默认地址
     */
    @Autowired
    private AddressService addressService;

    @ApiOperation(value = "根据用户id查询收货地址列表", notes = "根据用户id查询收货地址列表", httpMethod = "POST")
    @PostMapping("/list")
    public Result list(
            @RequestParam String userId) {

        Asserts.checkTrue(StringUtils.isBlank(userId), "请输入正确的userId");

        List<UserAddress> list = addressService.queryAll(userId);
        return Result.success(list);
    }

    @ApiOperation(value = "用户新增地址", notes = "用户新增地址", httpMethod = "POST")
    @PostMapping("/add")
    public Result add(@RequestBody AddressBO addressBO) {

        Result checkRes = checkAddress(addressBO);
        if (checkRes.getCode() != 200) {
            return checkRes;
        }

        addressService.addNewUserAddress(addressBO);

        return Result.success();
    }

    private Result checkAddress(AddressBO addressBO) {
        String receiver = addressBO.getReceiver();
        if (StringUtils.isBlank(receiver)) {
            return Result.failed("收货人不能为空");
        }
        if (receiver.length() > 12) {
            return Result.failed("收货人姓名不能太长");
        }

        String mobile = addressBO.getMobile();
        if (StringUtils.isBlank(mobile)) {
            return Result.failed("收货人手机号不能为空");
        }
        if (mobile.length() != 11) {
            return Result.failed("收货人手机号长度不正确");
        }
        boolean isMobileOk = MobileEmailUtils.checkMobileIsOk(mobile);
        if (!isMobileOk) {
            return Result.failed("收货人手机号格式不正确");
        }

        String province = addressBO.getProvince();
        String city = addressBO.getCity();
        String district = addressBO.getDistrict();
        String detail = addressBO.getDetail();
        if (StringUtils.isBlank(province) ||
                StringUtils.isBlank(city) ||
                StringUtils.isBlank(district) ||
                StringUtils.isBlank(detail)) {
            return Result.failed("收货地址信息不能为空");
        }

        return Result.success();
    }

    @ApiOperation(value = "用户修改地址", notes = "用户修改地址", httpMethod = "POST")
    @PostMapping("/update")
    public Result update(@RequestBody AddressBO addressBO) {

        if (StringUtils.isBlank(addressBO.getAddressId())) {
            return Result.failed("修改地址错误：addressId不能为空");
        }

        Result checkRes = checkAddress(addressBO);
        if (checkRes.getCode() != 200) {
            return checkRes;
        }

        addressService.updateUserAddress(addressBO);

        return Result.success();
    }

    @ApiOperation(value = "用户删除地址", notes = "用户删除地址", httpMethod = "POST")
    @PostMapping("/delete")
    public Result delete(
            @RequestParam String userId,
            @RequestParam String addressId) {

        if (StringUtils.isBlank(userId) || StringUtils.isBlank(addressId)) {
            return Result.failed("");
        }

        addressService.deleteUserAddress(userId, addressId);
        return Result.success();
    }
    @ApiOperation(value = "用户设置默认地址", notes = "用户设置默认地址", httpMethod = "POST")
    @PostMapping("/setDefalut")
    public Result setDefalut(
            @RequestParam String userId,
            @RequestParam String addressId) {

        if (StringUtils.isBlank(userId) || StringUtils.isBlank(addressId)) {
            return Result.failed("");
        }

        addressService.updateUserAddressToBeDefault(userId, addressId);
        return Result.success();
    }
}
