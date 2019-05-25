package com.biao.retrofit.Utils;


import com.biao.retrofit.BuildConfig;

import java.util.HashMap;

/**
 * Created by benxiang on 2019/4/9.
 */

public class GetMap {

    public static HashMap<String, String> getRoomMap(String startTime, String endTime) {
        HashMap<String, String> map = new HashMap<>();
        map.put("hotel_id", String.valueOf(BuildConfig.HOTEL_ID));
        map.put("mch_no", BuildConfig.MAC);
        map.put("start_time", startTime);
        map.put("end_time", endTime);
        return map;
    }
    public static HashMap<String, String> testAppInterface() {
        HashMap<String, String> map = new HashMap<>();
        map.put("name", "liyuanbiao");
        map.put("pwd", "123456");
        return map;
    }

}
