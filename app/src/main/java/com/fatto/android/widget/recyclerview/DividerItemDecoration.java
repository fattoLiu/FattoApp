package com.fatto.android.widget.recyclerview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * TODO recyclerview分割线
 *
 * @author fattoliu
 * @version V 1.0
 * @date 16/11/4 16:31.
 */

public class DividerItemDecoration extends RecyclerView.ItemDecoration {

    /**
     * 分割线属性
     */
    private static final int[] ATTRS = new int[] {android.R.attr.listDivider};

    /**
     * 水平方向
     */
    public static final int HORIZONTAL_LIST = LinearLayoutManager.HORIZONTAL;
    /**
     * 垂直方向
     */
    public static final int VERTICAL_LIST = LinearLayoutManager.VERTICAL;
    /**
     * 分割线
     */
    private Drawable mDivider;
    /**
     * 方向
     */
    private int mOrientation;


    public DividerItemDecoration(Context context, int orientation) {
        TypedArray array = context.obtainStyledAttributes(ATTRS);
        mDivider = array.getDrawable(0);
        array.recycle();
        setOrientation(orientation);
    }

    /**
     *
     * 在Item绘制之前被调用，该方法主要用于绘制间隔样式
     * @param c
     * @param parent
     * @param state
     */
    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        super.onDraw(c, parent, state);
        if (mOrientation == VERTICAL_LIST) {
            drawVerticalDivider(c, parent);
        } else if (mOrientation == HORIZONTAL_LIST){
            drawHorizontalDivider(c, parent);
        }

    }

    /**
     * 在Item绘制之前被调用，该方法主要用于绘制间隔样式
     *
     * @param c
     * @param parent
     * @param state
     */
    @Override
    public void onDrawOver(Canvas c, RecyclerView parent, RecyclerView.State state) {
        super.onDrawOver(c, parent, state);
    }

    /**
     * 设置item的偏移量，偏移的部分用于填充间隔样式，在RecyclerView的onMesure()中会调用该方法
     *
     * @param outRect
     * @param view
     * @param parent
     * @param state
     */
    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        if (mOrientation == VERTICAL_LIST) {
            outRect.set(0,0,0, mDivider.getIntrinsicHeight());
        }
    }

    /**
     * 设置列表的排列方向
     * @param orientation
     */
    public void setOrientation(int orientation) {
        if (orientation != HORIZONTAL_LIST && orientation != VERTICAL_LIST) {
            throw new IllegalArgumentException("invalid orientation");
        }
        this.mOrientation = orientation;
    }

    /**
     * 绘制垂直方向列表的分割线
     * @param c
     * @param parent
     */
    public void drawVerticalDivider(Canvas c, RecyclerView parent) {
        // 从以父布局的左内边距值为起点开始绘制
        int left = parent.getPaddingLeft();
        // right 即为该分割线的宽度：父布局的宽度-父布局的右内边距
        int right = parent.getWidth() - parent.getPaddingRight();

        int childCount = parent.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View child = parent.getChildAt(i);
            RecyclerView.LayoutParams lp = (RecyclerView.LayoutParams) child.getLayoutParams();
            // 获取到当前子view的 bottom值（）
            int top = child.getBottom() + lp.bottomMargin;
            int bottom = top + mDivider.getIntrinsicHeight();
            mDivider.setBounds(left,top, right, bottom);
            mDivider.draw(c);
        }
    }

    /**
     * 绘制水平方向列表的分割线
     * @param c
     * @param parent
     */
    public void drawHorizontalDivider(Canvas c, RecyclerView parent) {
        // 从以父布局的上内边距值为起点开始绘制
        int top = parent.getPaddingTop();
        // right 即为该分割线的宽度：父布局的高度-父布局的下内边距
        int  bottom = parent.getHeight() - parent.getPaddingBottom();

        int childCount = parent.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View child = parent.getChildAt(i);
            RecyclerView.LayoutParams lp = (RecyclerView.LayoutParams) child.getLayoutParams();
            // 获取到当前子view的 right值（）
            int left = child.getLeft() + lp.rightMargin;
            int right = left + mDivider.getIntrinsicHeight();
            mDivider.setBounds(left,top, right, bottom);
            mDivider.draw(c);
        }
    }


}
