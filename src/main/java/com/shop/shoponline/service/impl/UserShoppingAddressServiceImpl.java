package com.shop.shoponline.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
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
 * <p>
 * 服务实现类
 * </p>
 *
 * @author zero
 * @since 2023-11-07
 */
@Service
public class UserShoppingAddressServiceImpl extends ServiceImpl<UserShoppingAddressMapper, UserShoppingAddress> implements UserShoppingAddressService {

    @Override
    public Integer saveShippingAddress(AddressVO addressVO) {
        UserShoppingAddress convert = AddressConvert.INSTANCE.convert(addressVO);
        if (addressVO.getIsDefault().equals(AddressDefaultEnum.DEFAULT_ADDRESS.getValue())) {
            List<UserShoppingAddress> list = baseMapper.selectList(new LambdaQueryWrapper<UserShoppingAddress>().eq(UserShoppingAddress::getIsDefault, AddressDefaultEnum.DEFAULT_ADDRESS.getValue()));
            if (list.size() > 0) {
                throw new ServerException("已存在默认地址，请勿重复操作");
            }
        }
        save(convert);
        return convert.getId();
    }

    @Override
    public Integer editShippingAddress(AddressVO addressVO) {
        UserShoppingAddress userShoppingAddress = baseMapper.selectById(addressVO.getId());
        if (userShoppingAddress == null) {
            throw new ServerException("地址不存在");
        }
        // 查询该用户是否存在默认地址
        if (addressVO.getIsDefault().equals(AddressDefaultEnum.DEFAULT_ADDRESS.getValue())) {
            LambdaQueryWrapper<UserShoppingAddress> wrapper = new LambdaQueryWrapper<>();
//            wrapper.eq(UserShoppingAddress::getUserId, AddressDefaultEnum.DEFAULT_ADDRESS.getValue());
            wrapper.eq(UserShoppingAddress::getUserId, addressVO.getUserId());
            UserShoppingAddress address = baseMapper.selectOne(wrapper);
            // 如果存在 更新之前默认地址
            if (address != null) {
                address.setIsDefault(AddressDefaultEnum.NOT_DEFAULT_ADDRESS.getValue());
                updateById(address);
            }
        }
        UserShoppingAddress address = AddressConvert.INSTANCE.convert(addressVO);
        updateById(address);
        System.out.println(address);
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
    public AddressVO getAddress(Integer id) {
        UserShoppingAddress userShoppingAddress = baseMapper.selectById(id);
        if (userShoppingAddress == null) {
            throw new ServerException("地址不存在");
        }
        LambdaQueryWrapper<UserShoppingAddress> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(UserShoppingAddress::getId, id);
        UserShoppingAddress address = baseMapper.selectOne(wrapper);
        return AddressConvert.INSTANCE.convertToAddressVO(address);
    }

    @Override
    public Integer deleteShippingAddress(Integer id) {
//        LambdaUpdateWrapper<UserShoppingAddress> wrapper = new LambdaUpdateWrapper<>();
//        wrapper.eq(UserShoppingAddress::getId, id).set(UserShoppingAddress::getDeleteFlag, DeleteFlagEnum.DELETE_FLAG.getValue());
//        System.out.println(DeleteFlagEnum.DELETE_FLAG.getValue());
        LambdaQueryWrapper<UserShoppingAddress> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(UserShoppingAddress::getId, id);
        UserShoppingAddress address = baseMapper.selectOne(wrapper);
        address.setDeleteFlag(DeleteFlagEnum.OPEN_DELETE_FLAG.getValue());
        updateById(address);
        return address.getId();
    }
}
