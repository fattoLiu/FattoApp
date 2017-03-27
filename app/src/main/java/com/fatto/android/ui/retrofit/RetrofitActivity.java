package com.fatto.android.ui.retrofit;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.MenuItem;
import android.widget.TextView;

import com.fatto.android.R;
import com.fatto.android.base.BaseActivity;
import com.fatto.android.ui.retrofit.api.TngouService;
import com.fatto.android.ui.retrofit.api.model.TngouCook;

import java.util.List;

import butterknife.BindView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * TODO retrofit框架学习 demo
 *
 * @author fattoliu
 * @version V 1.0
 * @date 17/1/17 00:25.
 */

public class RetrofitActivity extends BaseActivity implements Callback<TngouCook> {

    @BindView(R.id.tv_baidu_html)
    TextView tv_baidu_html;
    private List<TngouCook.TngouBean> resultList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setDisplayHomeAsUpEnabled();
        setTitle("切换标题");
    }

    @Override
    protected int getContentViewResource() {
        return R.layout.act_retrofit;
    }

    @Override
    protected String getTitleName() {
        return getString(R.string.title_retrofit);
    }

    @Override
    protected void initViewsAndDatas() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://www.tngou.net/")
                .addConverterFactory(GsonConverterFactory.create()).build();
        TngouService service = retrofit.create(TngouService.class);
        Call<TngouCook> call = service.getCookList(1, 20, 0);
        call.enqueue(this);
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

    }

    @Override
    public void onResponse(Call<TngouCook> call, Response<TngouCook> response) {
        resultList = response.body().getTngou();
        tv_baidu_html.setText(resultList.toString());
    }

    @Override
    public void onFailure(Call<TngouCook> call, Throwable t) {
        t.printStackTrace();
    }
}
