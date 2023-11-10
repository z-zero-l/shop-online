package com.shop.shoponline.common.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.shop.shoponline.common.constant.Constant;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class FieldMetaObjectHandler implements MetaObjectHandler {

    // 在执行插入操作时，自动填充对应字段
    @Override
    public void insertFill(MetaObject metaObject) {
        // 创建时间
        strictInsertFill(metaObject, Constant.CREATE_TIME, LocalDateTime.class, LocalDateTime.now());
        // 更新时间
        strictInsertFill(metaObject, Constant.UPDATE_TIME, LocalDateTime.class, LocalDateTime.now());
        // 逻辑删除
        strictInsertFill(metaObject, Constant.DELETE_FLAG, Integer.class, 0);
    }

    // 在执行更新操作时，自动填充对应字段
    @Override
    public void updateFill(MetaObject metaObject) {
        // 更新时间
        strictUpdateFill(metaObject, Constant.UPDATE_TIME, LocalDateTime.class, LocalDateTime.now());
    }
}