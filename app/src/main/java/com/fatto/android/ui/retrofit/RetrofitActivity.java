package com.fatto.android.ui.retrofit;

import android.view.MenuItem;

import com.fatto.android.R;
import com.fatto.android.base.BaseActivity;

/**
 * TODO retrofit框架学习 demo
 *
 * @author fattoliu
 * @version V 1.0
 * @date 17/1/17 00:25.
 */

public class RetrofitActivity extends BaseActivity {
    @Override
    protected int getContentViewResource() {
        return R.layout.act_retrofit;
    }

    @Override
    protected String getTitleResource() {
        return getString(R.string.title_retrofit);
    }

    @Override
    protected void init() {

    }

    @Override
    protected int getMenuResource() {
        return 0;
    }

    @Override
    protected void onMenuItemSelected(MenuItem item) {

    }

    @Override
    protected void onFinish() {

    }
}
