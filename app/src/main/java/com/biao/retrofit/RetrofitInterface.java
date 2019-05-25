package com.biao.retrofit;

import com.biao.retrofit.model.RoomStatus;
import com.biao.retrofit.model.TestAppModel;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

/**
 * Created by benxiang on 2019/4/9.
 */

public interface RetrofitInterface {
    @GET("home/NewBase/get_room_type")
    Observable<RoomStatus> getRoomStatus(@QueryMap Map<String, String> map);
    @GET("/Test2/login")
    Observable<TestAppModel> testAppInterface(@QueryMap Map<String, String> map);
}
