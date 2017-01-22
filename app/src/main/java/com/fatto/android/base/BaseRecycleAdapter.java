package com.fatto.android.base;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO 基础recyclerview适配器
 *
 * @author fattoliu
 * @version V 1.0
 * @date 16/11/2 16:07.
 */

public abstract class BaseRecycleAdapter<T extends BaseViewHolder, K> extends RecyclerView.Adapter<T> {

    private List<K> mDatas;
    public BaseRecycleAdapter(List<K> datas) {
        this.mDatas = (datas == null) ? new ArrayList<K>() : datas;
    }

    @Override
    public T onCreateViewHolder(ViewGroup parent, int viewType) {

        return createVH(parent, viewType);
    }

    @Override
    public void onBindViewHolder(T holder, int position) {
        bindVH(holder, mDatas, position);
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }
    protected abstract T createVH(ViewGroup parent, int viewType);
    protected abstract void bindVH(T holder, List<K> datas, int position);

}

