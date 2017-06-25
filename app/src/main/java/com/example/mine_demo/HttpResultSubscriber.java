package com.example.mine_demo;

import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;

import okhttp3.Response;
import rx.Subscriber;


/**
 * @author ryujin
 * @version $Rev$
 * @time 2017/6/9 23:23
 * @updateAuthor $Author$
 * @updateDate $Date$
 */

public abstract class HttpResultSubscriber<T> extends Subscriber<T> {

    public HttpResultSubscriber() {

    }

    @Override
    public void onStart() {

    }

    @Override
    public void onCompleted() {

    }

    @Override
    public void onError(Throwable e) {

        Log.e("error",e.getMessage());

        if (e instanceof ApiException) {
            ApiException apiException = (ApiException) e;
            handleApiException(apiException);
        } else {
            handleError(e);
        }
    }

    /**
     * ck_code异常处理
     * @param apiException
     */
    private void handleApiException(ApiException apiException) {
        switch (apiException.getCkCode()) {
            case 1001:
                break;
        }

    }

    /**
     * Error处理
     * @param e
     */
    protected void handleError(Throwable e) {

    }

    @Override
    public void onNext(T tResponse) {
        onSuccess(tResponse);
    }

    public abstract void onSuccess(T t);

    public void onFail(String returnMsg) {

    }

}
