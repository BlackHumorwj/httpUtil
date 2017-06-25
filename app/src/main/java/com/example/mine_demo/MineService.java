package com.example.mine_demo;

import java.util.Map;

import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import rx.Observable;



/**
 * @author ryujin
 * @version $Rev$
 * @time 2017/6/9 22:12
 * @updateAuthor $Author$
 * @updateDate $Date$
 */

public interface MineService {

    String BASE_URL = "http://uattigeruc.cash360.cn";

   //坑一
    @FormUrlEncoded
    @POST(MainActivity.VERSION)
    Observable<User> getAndroidData(@FieldMap Map<String,String> fields);
}
