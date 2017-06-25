package com.example.mine_demo;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.FormBody;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;

/**
 * @author ryujin
 * @version $Rev$
 * @time 2017/6/9 22:20
 * @updateAuthor $Author$
 * @updateDate $Date$
 * <p>
 * 添加请求头
 */

public class MyInterceptor<T> implements Interceptor {

    private Gson mGson = new Gson();
    public MyInterceptor(){

    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request original = chain.request();

        Request.Builder header = original.newBuilder()
                //添加头信息
                .header("Cookie", "zxSessionId");

        //请求体定制：统一添加token参数
        if (original.body() instanceof FormBody) {
            FormBody.Builder newFormBody = new FormBody.Builder();
            FormBody oidFormBody = (FormBody) original.body();
            for (int i = 0; i < oidFormBody.size(); i++) {
                newFormBody.addEncoded(oidFormBody.encodedName(i), oidFormBody.encodedValue(i));
            }

            newFormBody.add("token", "");
            header.method(original.method(), newFormBody.build());
        }
        Request request = header.build();

        Response response = chain.proceed(request);

        //获取ck_code 和 returnCode
        String ckCode = response.header("ck_code");
        Log.e("dddd--ck_code","ck_code="+ckCode);

        ResponseBody body = response.body();
        String string = body.string();

        Log.e("dddd",string);






        //坑三
        try {
            JSONObject jsonObject = new JSONObject(string);
            int code = jsonObject.getInt("code");
            int ck_code = Integer.parseInt(ckCode);
            if (ck_code==9999){
                if (code==1){
                    throw new ApiException(code,jsonObject.getString("returnMsg"));
                }
            }else {
                throw new ApiException(ck_code,response.header("ck_msg"));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }


        //        String json = response.body().toString();
//        BaseData<T> baseData =  mGson.fromJson(json,BaseData.class);
//        if (baseData==null){
//            baseData = new BaseData<>();
//        }
//        baseData.setReturnMsg(response.header("ck_msg"));



        //坑二
        return  response.newBuilder()
                .body(ResponseBody.create(response.body().contentType(), string))
                .build();
    }
}
