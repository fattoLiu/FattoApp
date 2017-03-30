package com.fatto.android.base;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;

/**
 * TODO 通用适配器
 *
 * @author fattoliu
 * @version V 1.0
 * @date 2016/8/1 10:41.
 */
public abstract class BaseCommonAdapter<T> extends BaseAdapter {
private static final int TYPE_ACTIVITY = 1;
    private static final int TYPE_FRAGMENT = 2;
    private int type = TYPE_ACTIVITY;
    /**
     * 上下文
     */
    private Context mContext;

    private Fragment mFragment;
    /**
     * 数据源
     */
    private ArrayList<T> mDatas = new ArrayList<>();

    public BaseCommonAdapter(Context context, ArrayList<T> mDatas) {
        this.mContext = context;
        this.mDatas = mDatas;
        type = TYPE_ACTIVITY;
    }

    public BaseCommonAdapter(Fragment fragment, ArrayList<T> mDatas) {
        this.mFragment = fragment;
        this.mDatas = mDatas;
        type = TYPE_FRAGMENT;
    }

    protected ArrayList<T> getDatas() {
        return mDatas == null ? null : mDatas;
    }
    @Override
    public int getCount() {
        return mDatas == null ? 0 : mDatas.size();
    }

    @Override
    public Object getItem(int position) {
        return mDatas == null ? null : mDatas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return mDatas == null ? 0 : position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return getConvertView(type == TYPE_ACTIVITY ? mContext : mFragment, mDatas, position, convertView, parent);
    }

    protected abstract View getConvertView(Object context, ArrayList<T> mDatas, int position, View convertView, ViewGroup parent);
    protected abstract void initializeViews(int position, T data, Object holder);
}
