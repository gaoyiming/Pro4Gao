package com.pro4gao.utils.netutil;

import java.net.UnknownHostException;
import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.functions.Func1;

/**
 * Created by gaoyiming on 2016/2/20.
 */
public class RetryWhenProcess implements Func1<Observable<? extends Throwable>, Observable<?>> {

    private long mInterval;

    public RetryWhenProcess(long interval) {

        mInterval = interval;
    }

    @Override
    public Observable<?> call(final Observable<? extends Throwable> observable) {
        return observable.flatMap(throwable -> observable.flatMap(throwable1 -> {
            if (throwable instanceof UnknownHostException) {
                return Observable.error(throwable);
            }
            return Observable.just(throwable).zipWith(Observable.range(1, 5), (Throwable ithrowable, Integer i) -> i)
                    .flatMap((Integer retryCount) -> Observable.timer((long) Math.pow(mInterval, retryCount), TimeUnit.SECONDS));
        }));
    }


}