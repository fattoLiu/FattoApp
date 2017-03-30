package com.fatto.android.ui.okhttp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.MenuItem;
import android.view.View;

import com.fatto.android.R;
import com.fatto.android.base.BaseActivity;

import java.io.IOException;

import butterknife.OnClick;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * TODO okhttp3学习 demo
 *
 * @author fattoliu
 * @version V 1.0
 * @date 2017/3/28 21:54.
 */

public class OkhttpActivity extends BaseActivity {

    private OkHttpClient mOkHttpClient = new OkHttpClient();
    private String mBaseUrl = "http://192.168.1.102:8080/AndroidFattoServer/";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setDisplayHomeAsUpEnabled();
    }

    @Override
    protected int getContentViewResource() {
        return R.layout.act_okhttp3;
    }

    @Override
    protected String getTitleName() {
        return getString(R.string.okhttp);
    }

    @Override
    protected void initViewsAndDatas() {

    }

    @Override
    protected int getMenu() {
        return 0;
    }

    @Override
    protected void onMenuItemSelected(MenuItem item) {

    }

    @Override
    protected void onBackKeyPressed() {
        finish();
    }

    @OnClick({R.id.tv_get, R.id.tv_post})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_get:
                doGet();
                break;
            case R.id.tv_post:
                break;
        }
    }

    private void doGet() {
        Request.Builder builder = new Request.Builder();
        Request request = builder.get().url(mBaseUrl + "login?username=fatolu&password=666666").build();
        Call call = mOkHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                toastShort(e.getMessage());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
               final String result = response.body().string();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        toastShort(result);
                    }
                });
            }
        });
    }

    private void doPost() {
        Request.Builder builder = new Request.Builder();
    }

}
