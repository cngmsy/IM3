package com.example.administrator.huanxin.base;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Administrator on 2017/7/27 0027.
 */

public class OkhttpUtils implements Ihttp{
   private static OkhttpUtils okhttpUtils;
    private  OkHttpClient okHttpClient;

    public OkhttpUtils(){
        okHttpClient = new OkHttpClient();
    }
    public static OkhttpUtils getInstance(){
        if (okhttpUtils==null){
            synchronized (OkhttpUtils.class){
                okhttpUtils=new OkhttpUtils();
            }
        }
        return okhttpUtils;
    }

    @Override
    public void get(String url, final NetCallback callback) {
        Request request=new Request.Builder().url(url).build();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                App.mBaseActivity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        callback.onError("失败");
                    }
                });
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String string = response.body().string();
                App.mBaseActivity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        callback.onSuccess(string);
                    }
                });
            }
        });
    }
}
