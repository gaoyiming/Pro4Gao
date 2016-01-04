package com.pro4gao.api;

import retrofit.Callback;
import retrofit.http.POST;
import retrofit.http.Part;

/**
 * Created by gaoyiming on 2016/1/4.
 */
public interface RetroApi {

    @POST("/index.php?act=login&op=index")
    void login(@Part("info") String info, @Part("passwd") String passwd, Callback callback);



}
