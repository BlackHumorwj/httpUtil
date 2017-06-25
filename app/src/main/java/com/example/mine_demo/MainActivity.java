package com.example.mine_demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import java.util.HashMap;

import retrofit2.Response;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    //tigerUC接口:处理非账本信息时调用
    public static final String BASE_AS_URL = "http://uattigeruc.cash360.cn";
    //tiger接口:处理账本信息调用
    public static final String BASE_ZX_URL = "http://uattiger.cash360.cn";


    public static final String VERSION = "/mobile/version!last.do";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        HashMap<String, String> hashMap = new HashMap<>();

        ServiceFactory.getInstance().createService(MineService.class)
                .getAndroidData(hashMap)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new HttpResultSubscriber<User>() {
                    @Override
                    public void onSuccess(User user) {
                        Toast.makeText(MainActivity.this, "成功了", Toast.LENGTH_SHORT).show();
                    }
                });


    }
}
