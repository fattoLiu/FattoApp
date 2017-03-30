package com.fatto.android.ui.pulltorefresh;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.view.MenuItem;

import com.fatto.android.R;
import com.fatto.android.base.BaseActivity;
import com.fatto.android.utils.LogUtil;
import com.fatto.android.widget.pulltorefresh.PullToRefreshLayout;
import com.fatto.android.widget.pulltorefresh.PullableListView;

import java.lang.ref.WeakReference;
import java.util.ArrayList;

import butterknife.BindView;


/**
 * TODO
 *
 * @author fattoliu
 * @version V 1.0
 * @date 2017/3/30 10:13.
 */

public class PullToRefreshActivity extends BaseActivity {
    @BindView(R.id.content_view)
    PullableListView contentView;
    @BindView(R.id.refresh_view)
    PullToRefreshLayout refreshView;
    private MyHandler handler;
    private  PullToRefreshListAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setDisplayHomeAsUpEnabled();

        refreshView.setOnRefreshListener(mListener);
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            list.add("测试条目" + i);
        }
       adapter = new PullToRefreshListAdapter(this, list);
        contentView.setAdapter(adapter);
        contentView.setRefreshEnable(false);
    }

    private static class MyHandler extends Handler {
        private final WeakReference<PullToRefreshLayout> pullToRefreshLayout;

        MyHandler(PullToRefreshLayout activity) {
            pullToRefreshLayout = new WeakReference<>(activity);
        }
        @Override
        public void handleMessage(Message msg)
        {
            // 千万别忘了告诉控件加载完毕了哦！
            pullToRefreshLayout.get().loadmoreFinish(PullToRefreshLayout.SUCCEED);
        }
    }

    private PullToRefreshLayout.OnRefreshListener mListener = new PullToRefreshLayout.OnRefreshListener() {
        @Override
        public void onRefresh(final PullToRefreshLayout pullToRefreshLayout)
        {
//                // 下拉刷新操作
//                new Handler()
//                {
//                    @Override
//                    public void handleMessage(Message msg)
//                    {
//                        // 千万别忘了告诉控件刷新完毕了哦！
//                        pullToRefreshLayout.refreshFinish(PullToRefreshLayout.SUCCEED);
//                    }
//                }.sendEmptyMessageDelayed(0, 5000);
        }

        @Override
        public void onLoadMore(PullToRefreshLayout pullToRefreshLayout)
        {
            LogUtil.LOGE("onLoadMore onLoadMore onLoadMore onLoadMore onLoadMore onLoadMore onLoadMore onLoadMore");
            // 加载操作
            handler = new MyHandler(pullToRefreshLayout);
            handler.sendEmptyMessageDelayed(0, 5000);
        }
    };

    @Override
    protected int getContentViewResource() {
        return R.layout.act_pulltorefresh;
    }

    @Override
    protected String getTitleName() {
        return null;
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
        if (handler != null) {
            handler.removeMessages(0);
            handler = null;
        }
        mListener = null;
        adapter = null;

    }






}
