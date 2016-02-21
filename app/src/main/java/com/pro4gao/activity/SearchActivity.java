package com.pro4gao.activity;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.Toolbar;
import android.util.Property;

import com.pro4gao.R;
import com.pro4gao.base.BaseActivity;

import rx.Observable;
import rx.Subscriber;

public class SearchActivity extends BaseActivity {

    public static final String BASE_URL = "http://www.kanglt.com/mobile/";
    private Property<Object, Object> Stream;

    @Override
    public void initWidget() {
        setContentView(R.layout.activity_search);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);

//        fab.setOnClickListener(view -> {
////                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
////                        .setAction("Action", null).show();
//            Retrofit retrofit = new Retrofit.Builder()
//                    .baseUrl(BASE_URL)
//                    .build();
//
//            RetroApi service = retrofit.create(RetroApi.class);
//            //  Call<BaseBean> stringCall = service.HotWord();
//
//        });

        Observable<String> text = Observable.create(new Observable.OnSubscribe<String>() {

            @Override
            public void call(Subscriber<? super String> subscriber) {

            }
        });

        String[] strings = {"test1", "test1", "test1", "test1"};
        Observable<String> from = Observable.from(strings);
        Observable<String> test1 = Observable.just("test1");
       // Observable<String> String = test1.map((String s)->s);
        String[] array = {"a", "b", "c"};

     

    }

    @Override
    public void initData() {

    }

    @Override
    public void widgetClick() {

    }


}
