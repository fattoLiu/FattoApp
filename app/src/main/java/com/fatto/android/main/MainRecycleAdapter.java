package com.fatto.android.main;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.fatto.android.R;
import com.fatto.android.base.BaseRecycleAdapter;
import com.fatto.android.base.BaseViewHolder;
import com.fatto.android.beans.MainBean;

import java.util.List;

import butterknife.BindView;

/**
 * TODO 主界面recyclerView列表适配器
 *
 * @author fattoliu
 * @version V 1.0
 * @date 16/11/2 16:07.
 */

public class MainRecycleAdapter extends BaseRecycleAdapter<MainRecycleAdapter.MainViewHolder, MainBean> {

    public MainRecycleAdapter(List<MainBean> datas) {
        super(datas);
    }

    @Override
    protected MainViewHolder createVH(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_main, parent, false);
        return new MainViewHolder(itemView);
    }

    @Override
    protected void bindVH(MainViewHolder holder, List<MainBean> datas, int position) {
        holder.tv_title.setText(datas.get(position) != null ? datas.get(position).getTitle() : "");
        holder.tv_content.setText(datas.get(position) != null ? datas.get(position).getContent() : "");
    }


    public static class MainViewHolder extends BaseViewHolder {
        @BindView(R.id.tv_title)
        TextView tv_title;
        @BindView(R.id.tv_content)
        TextView tv_content;

        public MainViewHolder(View itemView) {
            super(itemView);
        }
    }
}

