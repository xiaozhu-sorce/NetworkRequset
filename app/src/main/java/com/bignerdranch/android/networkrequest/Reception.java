package com.bignerdranch.android.networkrequest;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

//创建接受服务器返回数据的类
public class Reception extends AppCompatActivity {

    private Button mButton;

    private TextView mTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mButton=(Button)findViewById(R.id.btn_get);
        mTextView=(TextView)findViewById(R.id.text);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                request();
            }
        });
    }

    public void request(){
        Retrofit retrofit= new Retrofit
                .Builder().baseUrl("http://fanyi.youdao.com/").addConverterFactory(GsonConverterFactory.create()).build();

        API request=retrofit.create(API.class);

        Call<Translation> call = request.getCall("I Love You");

        call.enqueue(new Callback<Translation>() {
            //请求成功时回调
            @Override
            public void onResponse(Call<Translation> call, Response<Translation> response) {
                // 步骤7：
                Toast.makeText(Reception.this,"get回调成功：异步执行",Toast.LENGTH_SHORT).show();
                mTextView.setText(response.body().getTranslateResult().get(0).get(0).getTgt());
            }

            //请求失败时回调
            @Override
            public void onFailure(Call<Translation> call, Throwable throwable) {
                mTextView.setText("连接失败");
                System.out.println(throwable.getMessage());
            }
        });

    }
}