package com.shop.shoponline.convert;

import com.shop.shoponline.entity.User;
import com.shop.shoponline.vo.LoginResultVO;
import com.shop.shoponline.vo.UserVO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Mapper
public interface UserConvert {

    UserConvert INSTANCE = Mappers.getMapper(UserConvert.class);

    @Mapping(expression = "java(MapStruct.transferTimeStamp(entity.getBirthday()))", target = "birthday")
    User convert(UserVO entity);

    @Mapping(expression = "java(MapStruct.transferTime(user.getBirthday()))", target = "birthday")
    UserVO convertToUserVO(User user);

    LoginResultVO convertToLoginResultVO(User user);

    class MapStruct {
        public static Timestamp transferTime(LocalDateTime value) {
            return Timestamp.valueOf(value);
        }

        public static LocalDateTime transferTimeStamp(Timestamp time) {
            return time.toLocalDateTime();
        }
    }
}