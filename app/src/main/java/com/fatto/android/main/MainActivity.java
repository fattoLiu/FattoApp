package com.fatto.android.main;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;

import com.fatto.android.R;
import com.fatto.android.base.BaseActivity;
import com.fatto.android.beans.MainBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * TODO 主界面
 *
 * @author fattoliu
 * @version V 1.0
 * @date 16/11/1 14:00.
 */
public class MainActivity extends BaseActivity {

    @BindView(R.id.ryv_main)
    RecyclerView ryv_main;
    private List<MainBean> list;
    private MainRecycleAdapter adapter;
    private LinearLayoutManager llm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setDisplayHomeAsUpEnabled();
    }

    @Override
    protected int getContentViewResource() {
        return R.layout.act_main;
    }

    @Override
    protected String getTitleResource() {
        return getString(R.string.app_name);
    }

    @Override
    protected int getMenuResource() {
        return R.menu.menu_main;
    }

    @Override
    protected void init() {
        list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            list.add(new MainBean("标题" + i, "内容" + i));
        }
        adapter = new MainRecycleAdapter(list);
        llm = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        ryv_main.setLayoutManager(llm);
        ryv_main.setAdapter(adapter);

    }

    @Override
    protected void onMenuItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_search:
                toastShort("搜索", true);
                break;
        }
    }

    @Override
    protected void onActFinish() {

    }
}
