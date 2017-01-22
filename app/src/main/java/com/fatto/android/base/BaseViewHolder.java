package com.fatto.android.base;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import butterknife.ButterKnife;

/**
 * TODO 基础RecyclerView 中的ViewHolder
 *
 * @author fattoliu
 * @version V 1.0
 * @date 16/11/3 09:10.
 */

public abstract class BaseViewHolder extends RecyclerView.ViewHolder {
    public BaseViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }
}
