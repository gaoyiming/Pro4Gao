package com.pro4gao.api;

import com.pro4gao.bean.Root;

import java.util.Map;

import retrofit.Call;
import retrofit.Response;
import retrofit.http.FormUrlEncoded;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.QueryMap;

/**
 * Created by gaoyiming on 2016/1/4
 */
public interface RetroApi {
//    @FormUrlEncoded
//    @POST("index.php?act=goods&op=goods_list")
//    Call<String> login(@QueryMap Map<String, String> info);

    @GET("index.php?act=services_class")
    Call<BaseBean> HotWord();


}
