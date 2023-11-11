package com.shop.shoponline.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

import static com.shop.shoponline.constant.APIConstant.APP_TOKEN_EXPIRE_TIME;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserTokenVO {
    private long expires;

    private long loginAt;

    private Integer userId;

    public UserTokenVO(Integer userId) {
        this.userId = userId;
        this.loginAt = System.currentTimeMillis();
        this.expires = APP_TOKEN_EXPIRE_TIME;
    }

    public Map toMap() {
        Map map = new HashMap();
        map.put("userId", this.userId);
        map.put("expires", this.expires);
        map.put("loginAt", this.loginAt);
        return map;
    }


    public UserTokenVO fromMap(Map map) {
        UserTokenVO userToken = new UserTokenVO();
        userToken.expires = Long.parseLong(String.valueOf(map.get("expires")));
        userToken.userId = Integer.parseInt(String.valueOf(map.get("userId")));
        userToken.loginAt = Long.parseLong(String.valueOf(map.get("loginAt")));
        return userToken;
    }
}