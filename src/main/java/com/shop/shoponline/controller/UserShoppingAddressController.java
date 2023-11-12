package com.shop.shoponline.controller;

import com.shop.shoponline.common.exception.ServerException;
import com.shop.shoponline.common.result.Result;
import com.shop.shoponline.service.UserShoppingAddressService;
import com.shop.shoponline.vo.AddressVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.shop.shoponline.common.utils.ObtainUserIdUtils.getUserId;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author zero
 * @since 2023-11-07
 */
@Tag(name = "地址管理")
@RestController
@RequestMapping("member")
@AllArgsConstructor
public class UserShoppingAddressController {
    private final UserShoppingAddressService userShippingAddressService;
    @Resource
    private HttpServletRequest request;

    @Operation(summary = "添加收货地址")
    @PostMapping("address")
    public Result<Integer> saveAddress(@RequestBody @Validated AddressVO addressVO) {
        Integer userId = getUserId(request);
        addressVO.setUserId(userId);
        Integer addressId = userShippingAddressService.saveShippingAddress(addressVO);
        return Result.ok(addressId);
    }

    @Operation(summary = "修改收货地址")
    @PutMapping("address")
    public Result<Integer> editAddress(@RequestBody @Validated AddressVO addressVO, HttpServletRequest request) {
        if (addressVO.getId() == null) {
            throw new ServerException("请求参数不能为空");
        }
        addressVO.setUserId(getUserId(request));
        Integer addressId = userShippingAddressService.editShippingAddress(addressVO);
        return Result.ok(addressId);
    }

    @Operation(summary = "获取收货地址")
    @GetMapping("address")
    public Result<List<AddressVO>> getList(HttpServletRequest request) {
        Integer userId = getUserId(request);
        List<AddressVO> list = userShippingAddressService.getList(userId);
        return Result.ok(list);
    }

    @Operation(summary = "收货地址详情")
    @GetMapping("address/detail")
    public Result<AddressVO> getAddress(@RequestParam Integer id, HttpServletRequest request) {
        AddressVO addressVO = userShippingAddressService.getAddress(id);
        return Result.ok(addressVO);
    }

    @Operation(summary = "删除收货地址")
    @DeleteMapping("address")
    public Result<Integer> deleteAddress(@RequestParam Integer id, HttpServletRequest request) {
        Integer integer = userShippingAddressService.deleteShippingAddress(id);
        return Result.ok(integer);
    }

}
