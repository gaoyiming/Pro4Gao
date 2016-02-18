package com.pro4gao.api;

import retrofit.http.GET;
import retrofit.http.Header;
import retrofit.http.Headers;
import rx.Observable;

/**
 * Created by gaoyiming on 2016/1/4
 */
public interface RetroApi {
//    @FormUrlEncoded
//    @POST("index.php?act=goods&op=goods_list")
//    Call<String> login(@QueryMap Map<String, String> info);


    //Call<BaseBean> HotWord();
   @Headers("Cache-Control: public, max-age=3600")
     @GET("index.php?act=services_class")
     Observable<BaseBean> HotWord();


}
