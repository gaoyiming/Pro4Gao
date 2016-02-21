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
    public RetroApi getZhixueApi() {
        return Retroapi;
    }
    //我们的主域名
    private static final String BASE_URL = "http://124.207.115.50:8011/mobile/";


    private OkHttpClient client;

    //构造函数
    private APIUtil() {
        //setup cache
        File httpCacheDirectory = new File(UIUtils.getContext().getCacheDir(), "responses");


        Cache cache = null;
        try {
            cache = new Cache(httpCacheDirectory, 10 * 1024 * 1024);
        } catch (Exception e) {
            Log.e("OKHttp", "Could not create http cache", e);
        }



        client = new OkHttpClient();
        client.setCache(cache);
        client.interceptors().add(LoggingInterceptor);
        client.networkInterceptors().add(interceptor);
        client.interceptors().add(interceptor);

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

    private final Interceptor LoggingInterceptor = new Interceptor() {
        @Override
        public Response intercept(Chain chain) throws IOException {
            Request request = chain.request();
            long t1 = System.nanoTime();
            Log.e("okhttp", String.format("Sending request %s on %s%n%s", request.url(), chain.connection(), request.headers()));
            Response response = chain.proceed(request);
            long t2 = System.nanoTime();
            Log.e("okhttp", String.format("Received response for %s in %.1fms%n%s", response.request().url(), (t2 - t1) / 1e6d, response.headers()));
            return response;
        }
    };
    private final   Interceptor interceptor = new Interceptor() {
        @Override
        public Response intercept(Chain chain) throws IOException {
            Request request = chain.request();
            if (!AppUtil.isNetworkReachable(UIUtils.getContext())) {
                request = request.newBuilder()
                        .cacheControl(CacheControl.FORCE_CACHE)
                        .build();
                Log.e("OKHttp", "noNet");
            }

            Response response = chain.proceed(request);
            if (AppUtil.isNetworkReachable(UIUtils.getContext())) {
                int maxAge = 60 * 60; // read from cache for 1 minute
                return  response.newBuilder()
                        .header("Cache-Control", "public, max-age=" + maxAge)
                        .removeHeader("Pragma")
                        .build();
            } else {
                for (int i = 0; i <5 ; i++) {
                    System.out.print(i);
                }
                int maxStale = 60 * 60 * 24 * 28; // tolerate 4-weeks stale
                return  response.newBuilder()
                        .header("Cache-Control", "public, only-if-cached, max-stale=" + maxStale)
                        .removeHeader("Pragma")
                        .build();
            }

        }
    };

}
