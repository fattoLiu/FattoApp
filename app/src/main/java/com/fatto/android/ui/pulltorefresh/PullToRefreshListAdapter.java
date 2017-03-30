package com.fatto.android.ui.pulltorefresh;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.fatto.android.R;
import com.fatto.android.base.BaseCommonAdapter;

import java.util.ArrayList;

/**
 * TODO
 *
 * @author fattoliu
 * @version V 1.0
 * @date 2017/3/30 14:45.
 */

public class PullToRefreshListAdapter extends BaseCommonAdapter {
    public PullToRefreshListAdapter(Context context, ArrayList mDatas) {
        super(context, mDatas);
    }

    @Override
    protected View getConvertView(Object context, ArrayList mDatas, int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = LayoutInflater.from((Context) context).inflate(R.layout.item_main, null);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.tv_title = (TextView) convertView.findViewById(R.id.tv_title);

        initializeViews(position, getItem(position), holder);
        return convertView;
    }

    @Override
    protected void initializeViews(int position, Object data, Object holder) {

        ((ViewHolder) holder).tv_title.setText(((String) data));
    }

    class ViewHolder {
       private TextView tv_title;
    }
}
