package com.pro4gao.api;

import android.util.Log;

import com.pro4gao.utils.UIUtils;
import com.squareup.okhttp.Cache;
import com.squareup.okhttp.CacheControl;
import com.squareup.okhttp.Interceptor;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.File;
import java.io.IOException;

import retrofit.GsonConverterFactory;
import retrofit.Retrofit;
import retrofit.RxJavaCallAdapterFactory;

/**
 * Created by gaoyiming on 2016/2/17.
 */
public class APIUtil {
    private static APIUtil mInstance;
    //此前定义的接口的实例
    private RetroApi Retroapi;
    //我们的主域名
    private static final String BASE_URL = "http://124.207.115.50:8011/mobile/";
    private OkHttpClient client;
    private  Cache cache;

    //构造函数
    private APIUtil() {
        client = new OkHttpClient();
        client.networkInterceptors().add(interceptor);

//setup cache
        File httpCacheDirectory = new File(UIUtils.getContext().getCacheDir(), "responses");

        Cache cache = null;
        try {
            cache = new Cache(httpCacheDirectory, 10 * 1024 * 1024);
        } catch (Exception e) {
            Log.e("OKHttp", "Could not create http cache", e);
        }


//add cache to the client
        client.setCache(cache);
        //在构造函数中我们要通过实例化RestAdapter拿到我们的ZhixueApi
        //注: setRequestInterceptor()在这里是为了在请求头中加入设备信息, 方便我们后台的调试
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();
        Retroapi = retrofit.create(RetroApi.class);
    }

    //一个简单的单例
    public static APIUtil getInstance() {
        if (mInstance == null) {
            mInstance = new APIUtil();
        }
        return mInstance;
    }

    public RetroApi getZhixueApi() {
        return Retroapi;
    }

    public Interceptor interceptor = new Interceptor() {
        @Override
        public Response intercept(Chain chain) throws IOException {
            Request request = chain.request();
            if (!AppUtil.isNetworkReachable(UIUtils.getContext())) {
                request = request.newBuilder()
                        .cacheControl(CacheControl.FORCE_CACHE)
                        .url(BASE_URL).build();

            }

            Response response = chain.proceed(request);
            if (AppUtil.isNetworkReachable(UIUtils.getContext())) {
                int maxAge = 60 * 60; // read from cache for 1 minute
                response.newBuilder()
                        .removeHeader("Pragma")
                        .header("Cache-Control", "public, max-age=" + maxAge)
                        .build();
            } else {
                int maxStale = 60 * 60 * 24 * 28; // tolerate 4-weeks stale
                response.newBuilder()
                        .removeHeader("Pragma")
                        .header("Cache-Control", "public, only-if-cached, max-stale=" + maxStale)
                        .build();
            }
            return response;
        }
    };
    //在这里我们还定义了一个RequestInterceptor, 作用是在请求头中拼入一些信息方便我们后台的调试
    //否则请求头中就只会出现okhttp 2.2.0的字样(Retrofit默认是直接使用OkhttpClient的)
//    RequestInterceptor defaultInterceptor = new RequestInterceptor() {
//        @Override
//        public void intercept(RequestFacade request) {
//            request.addHeader("User-Agent", "some code here");
//        }
//    };
}
