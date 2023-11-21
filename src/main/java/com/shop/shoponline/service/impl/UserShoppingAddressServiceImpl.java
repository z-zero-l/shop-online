package com.shop.shoponline.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.shop.shoponline.common.exception.ServerException;
import com.shop.shoponline.convert.AddressConvert;
import com.shop.shoponline.entity.UserShoppingAddress;
import com.shop.shoponline.enums.AddressDefaultEnum;
import com.shop.shoponline.enums.DeleteFlagEnum;
import com.shop.shoponline.mapper.UserShoppingAddressMapper;
import com.shop.shoponline.service.UserShoppingAddressService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.shop.shoponline.vo.AddressVO;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 服务实现类
 * </p>
 *
 * @author zero
 * @since 2023-11-12
 */
@Service
public class UserShoppingAddressServiceImpl extends ServiceImpl<UserShoppingAddressMapper, UserShoppingAddress> implements UserShoppingAddressService {

    @Override
    public Integer saveShoppingAddress(AddressVO addressVO) {
        // 接收数据转换为实体类
        UserShoppingAddress convert = AddressConvert.INSTANCE.convert(addressVO);
        // 是否需要设为默认地址
        if (addressVO.getIsDefault().equals(AddressDefaultEnum.DEFAULT_ADDRESS.getValue())) {
            // 根据用户查询是否存在默认地址
            LambdaQueryWrapper<UserShoppingAddress> wrapper = new LambdaQueryWrapper<>();
            wrapper.eq(UserShoppingAddress::getIsDefault, AddressDefaultEnum.DEFAULT_ADDRESS.getValue()).eq(UserShoppingAddress::getUserId, addressVO.getUserId());
            List<UserShoppingAddress> list = baseMapper.selectList(wrapper);
            // 如果存在，返回500
            if (list.size() > 0) {
                throw new ServerException("已存在默认地址，请勿重复操作");
            }
        }
        convert.setId(0);
        save(convert); // 实体对象插入
        return convert.getId();
    }

    @Override
    public Integer editShoppingAddress(AddressVO addressVO) {
        // 判断地址是否存在
        UserShoppingAddress userShoppingAddress = baseMapper.selectById(addressVO.getId());
        if (userShoppingAddress == null) {
            throw new ServerException("地址不存在");
        }
        // 查询该用户是否存在默认地址
        if (addressVO.getIsDefault().equals(AddressDefaultEnum.DEFAULT_ADDRESS.getValue())) {
            LambdaQueryWrapper<UserShoppingAddress> wrapper = new LambdaQueryWrapper<>();
            wrapper.eq(UserShoppingAddress::getIsDefault, AddressDefaultEnum.DEFAULT_ADDRESS.getValue()).eq(UserShoppingAddress::getUserId, addressVO.getUserId());
            UserShoppingAddress address = baseMapper.selectOne(wrapper);
            // 如果存在 更新之前默认地址
            if (address != null) {
                address.setIsDefault(AddressDefaultEnum.NOT_DEFAULT_ADDRESS.getValue());
                updateById(address);
            }
        }
        UserShoppingAddress address = AddressConvert.INSTANCE.convert(addressVO);
        updateById(address);
        return address.getId();
    }

    @Override
    public List<AddressVO> getList(Integer userId) {
        LambdaQueryWrapper<UserShoppingAddress> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(UserShoppingAddress::getUserId, userId);
        wrapper.orderByDesc(UserShoppingAddress::getIsDefault);
        List<UserShoppingAddress> addressList = baseMapper.selectList(wrapper);
        return AddressConvert.INSTANCE.convertToAddressVOList(addressList);
    }

    @Override
    public AddressVO getAddress(Integer id, Integer userId) {
        // 查询地址信息 仅能查询到自己的地址
        LambdaQueryWrapper<UserShoppingAddress> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(UserShoppingAddress::getId, id).eq(UserShoppingAddress::getUserId, userId);
        UserShoppingAddress address = baseMapper.selectOne(wrapper);
        // 判断地址是否存在
        if (address == null) {
            throw new ServerException("地址不存在");
        }
        return AddressConvert.INSTANCE.convertToAddressVO(address);
    }

    @Override
    public Integer deleteShoppingAddress(Integer id, Integer userId) {
        // 方法一
        UpdateWrapper<UserShoppingAddress> updateWrapper = new UpdateWrapper<>();
        updateWrapper.lambda().set(UserShoppingAddress::getIsDefault, AddressDefaultEnum.NOT_DEFAULT_ADDRESS.getValue()).set(UserShoppingAddress::getDeleteFlag, DeleteFlagEnum.OPEN_DELETE_FLAG.getValue()).eq(UserShoppingAddress::getId, id).eq(UserShoppingAddress::getUserId, userId);
        boolean update = update(updateWrapper);
        if (!update) {
            throw new ServerException("地址不存在");
        }
        // 方法二
//        LambdaQueryWrapper<UserShoppingAddress> wrapper = new LambdaQueryWrapper<>();
//        wrapper.eq(UserShoppingAddress::getId, id).eq(UserShoppingAddress::getUserId, userId);
//        UserShoppingAddress address = baseMapper.selectOne(wrapper);
//        if (address == null) {
//            throw new ServerException("地址不存在");
//        }
//        baseMapper.deleteById(id);
        return id;
    }
}
