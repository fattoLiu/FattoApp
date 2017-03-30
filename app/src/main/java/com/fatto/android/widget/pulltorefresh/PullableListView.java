package com.fatto.android.widget.pulltorefresh;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ListView;

public class PullableListView extends ListView implements Pullable
{
	private boolean refreshEnable = true;
	private boolean loadEnable = true;

	public PullableListView(Context context)
	{
		super(context);
	}

	public PullableListView(Context context, AttributeSet attrs)
	{
		super(context, attrs);
	}

	public PullableListView(Context context, AttributeSet attrs, int defStyle)
	{
		super(context, attrs, defStyle);
	}

	public boolean isRefreshEnable() {
		return refreshEnable;
	}

	public void setRefreshEnable(boolean refreshEnable) {
		this.refreshEnable = refreshEnable;
	}

	public boolean isLoadEnable() {
		return loadEnable;
	}

	public void setLoadEnable(boolean loadEnable) {
		this.loadEnable = loadEnable;
	}

	@Override
	public boolean canPullDown()
	{
		if (isRefreshEnable()) {
			if (getCount() == 0)
			{
				// 没有item的时候也可以下拉刷新
				return true;
			} else if (getFirstVisiblePosition() == 0
					&& getChildAt(0).getTop() >= 0)
			{
				// 滑到ListView的顶部了
				return true;
			} else
				return false;
		}

		return false;
	}

	@Override
	public boolean canPullUp()
	{
		if (isLoadEnable()) {
			if (getCount() == 0)
			{
				// 没有item的时候也可以上拉加载
				return true;
			} else if (getLastVisiblePosition() == (getCount() - 1))
			{
				// 滑到底部了
				if (getChildAt(getLastVisiblePosition() - getFirstVisiblePosition()) != null
						&& getChildAt(
						getLastVisiblePosition()
								- getFirstVisiblePosition()).getBottom() <= getMeasuredHeight())
					return true;
			}
			return false;
		}
		return false;
	}
}
