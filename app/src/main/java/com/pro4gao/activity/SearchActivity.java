package com.pro4gao.activity;

import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.pro4gao.R;
import com.pro4gao.api.BaseBean;
import com.pro4gao.api.RetroApi;
import com.pro4gao.base.BaseActivity;

import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;
import rx.Observable;
import rx.Subscriber;

public class SearchActivity extends BaseActivity {

    public static final String BASE_URL = "http://www.kanglt.com/mobile/";

    @Override
    public void initWidget() {
        setContentView(R.layout.activity_search);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl(BASE_URL)
                        .build();

                RetroApi service = retrofit.create(RetroApi.class);
                Call<BaseBean> stringCall = service.HotWord();
                stringCall.enqueue(new Callback<BaseBean>() {
                    @Override
                    public void onResponse(Response<BaseBean> response, Retrofit retrofit) {
                        String s = response.toString();
                    }

                    @Override
                    public void onFailure(Throwable t) {

                    }
                });
            }
        });

        Observable<String> text = Observable.create(new Observable.OnSubscribe<String>() {

            @Override
            public void call(Subscriber<? super String> subscriber) {

            }
        });

        String[] strings = {"test1","test1","test1","test1"};
        Observable<String> from = Observable.from(strings);
        Observable<String> test1 = Observable.just("test1");
    }

    @Override
    public void initData() {

    }

    @Override
    public void widgetClick() {

    }



}
