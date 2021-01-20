package com.bignerdranch.android.networkrequest;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

//创建接受服务器返回数据的类
public class Reception extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        request();
    }

    public void request(){
        Retrofit retrofit= new Retrofit
                .Builder().baseUrl("http://fy.iciba.com/").addConverterFactory(GsonConverterFactory.create()).build();

        API request=retrofit.create(API.class);

        Call<Translation> call = request.getCall();

        call.enqueue(new Callback<Translation>() {
            //请求成功时回调
            @Override
            public void onResponse(Call<Translation> call, Response<Translation> response) {
                // 步骤7：处理返回的数据结果
                response.body().show();
            }

            //请求失败时回调
            @Override
            public void onFailure(Call<Translation> call, Throwable throwable) {
                System.out.println("连接失败");
            }
        });

    }
}