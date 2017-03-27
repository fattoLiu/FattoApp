package com.fatto.android.ui.main;

import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;

import com.fatto.android.R;
import com.fatto.android.base.BaseActivity;
import com.fatto.android.beans.MainBean;
import com.fatto.android.common.Constants;
import com.fatto.android.ui.https.HTTPSHttpsURLConnectionActivity;
import com.fatto.android.ui.retrofit.RetrofitActivity;
import com.fatto.android.utils.MyQueue;
import com.fatto.android.utils.SendThread;
import com.fatto.android.widget.recyclerview.DividerItemDecoration;
import com.fatto.android.widget.recyclerview.OnRecyclerItemClickListener;

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
    private MainRecycleAdapter adapter;
    private LinearLayoutManager llm;
    private List<MainBean> function = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setDisplayHomeAsUpEnabled();
    }

    @Override
    protected void initViewsAndDatas() {
        addFunction();
        adapter = new MainRecycleAdapter(function);
        llm = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        ryv_main.setLayoutManager(llm);
        //设置Item增加、移除动画
        ryv_main.setItemAnimator(new DefaultItemAnimator());
        //添加分割线
        ryv_main.addItemDecoration(new DividerItemDecoration(
                this, DividerItemDecoration.VERTICAL_LIST));
        ryv_main.setAdapter(adapter);
        ryv_main.addOnItemTouchListener(new OnRecyclerItemClickListener(ryv_main) {
            @Override
            public void onItemClick(RecyclerView.ViewHolder vh, int position) {
                toastShort("onItemClick: " + position);
                itemClick(position);
            }

            @Override
            public void onItemLongClick(RecyclerView.ViewHolder vh, int position) {
            }
        });
    }

    @Override
    protected int getContentViewResource() {
        return R.layout.act_main;
    }

    @Override
    protected String getTitleName() {
        return getString(R.string.app_name);
    }

    @Override
    protected int getMenu() {
        return R.menu.menu_main;
    }

    @Override
    protected void onMenuItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_search:
                toastShort("搜索");
                ryv_main.setLayoutManager(new GridLayoutManager(this, 4));
                adapter.notifyDataSetChanged();
                break;
        }
    }

    @Override
    protected void onBackKeyPressed() {

    }

    private void itemClick(int position) {
        switch (position) {
            case Constants.ITEM_THREAD_QUEUE:   // 线程队列
                 MyQueue queue = new MyQueue();
                int i = 0;
                while (i < 100) {
                    queue.pushFile(i++ + "");
                }
                SendThread thread = new SendThread(queue);
                thread.start();
                break;

            case Constants.ITEM_RETROFIT_BASE:  // retrofit
                toActivity(RetrofitActivity.class);
                break;

            case Constants.ITEM_HTTPS_URL_CONNECTION:   //HttpsUrlConnection实现HTTPS
                toActivity(HTTPSHttpsURLConnectionActivity.class);
                break;

            case Constants.ITEM_NDK:   //NDK开发
                break;
        }
    }

    private void addFunction() {
        function.add(new MainBean("线程、队列测试", "消息队列测试"));
        function.add(new MainBean("retrofit 学习", "retrofit 框架学习"));
        function.add(new MainBean("HttpsUrlConnection实现HTTPS 通信 学习", "https 通信、证书..."));
    }
}
