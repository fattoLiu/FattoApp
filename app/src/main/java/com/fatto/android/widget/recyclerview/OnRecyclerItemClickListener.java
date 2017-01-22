package com.fatto.android.widget.recyclerview;

import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

/**
 * TODO recyclerview item 点击/长按事件
 *
 * @author fattoliu
 * @version V 1.0
 * @date 17/1/16 22:40.
 */

public abstract class OnRecyclerItemClickListener extends RecyclerView.SimpleOnItemTouchListener {
    private GestureDetectorCompat mGestureDetector;

    public OnRecyclerItemClickListener(final RecyclerView recyclerView) {
        mGestureDetector = new GestureDetectorCompat(recyclerView.getContext(), new GestureDetector.SimpleOnGestureListener() {

            @Override
            public boolean onSingleTapUp(MotionEvent e) {
                View itemView = recyclerView.findChildViewUnder(e.getX(), e.getY());
                if (itemView != null) {
                    RecyclerView.ViewHolder holder = recyclerView.getChildViewHolder(itemView);
                    onItemClick(holder, holder.getAdapterPosition());
                }
                return true;
            }

            @Override
            public void onLongPress(MotionEvent e) {
                View itemView = recyclerView.findChildViewUnder(e.getX(), e.getY());
                if (itemView != null) {
                    RecyclerView.ViewHolder holder = recyclerView.getChildViewHolder(itemView);
                    onItemLongClick(holder, holder.getAdapterPosition());
                }
            }
        });
    }


    @Override
    public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
        //点击事件交给mGestureDetector处理
        mGestureDetector.onTouchEvent(e);
        return false;
    }

    /**
     * 点击回调
     * @param vh
     */
    public abstract void onItemClick(RecyclerView.ViewHolder vh, int position);

    /**
     * 长按回调
     * @param vh
     */
    public abstract void onItemLongClick(RecyclerView.ViewHolder vh, int position);

}
