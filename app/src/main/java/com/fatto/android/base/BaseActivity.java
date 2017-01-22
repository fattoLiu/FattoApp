package com.fatto.android.base;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.fatto.android.R;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.fatto.android.R.id.tv_title;


/**
 * TODO 基础Activity 所有activity都应继承该类
 *
 * @author fattoliu
 * @version V 1.0
 * @date 16/11/1 14:03.
 */

public abstract class BaseActivity extends AppCompatActivity {

    protected final String TAG = "FATTO_APP";

    /**
     * 标题
     */
    @BindView(tv_title)
    TextView mTitle;
    /**
     * 工具栏
     */
    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    //*********************************** 抽象方法,子类去实现 ***********************************

    /**
     * 获取布局资源
     *
     * @return
     */
    protected abstract int getContentViewResource();

    /**
     * 获取标题资源
     *
     * @return
     */
    protected abstract String getTitleResource();

    /**
     * 初始化操作(布局和数据)
     */
    protected abstract void init();

    /**
     * 获取菜单资源
     *
     * @return
     */
    protected abstract int getMenuResource();

    /**
     * 菜单选中事件回调
     */
    protected abstract void onMenuItemSelected(MenuItem item);

    /**
     * 关闭界面事件回调
     */
    protected abstract void onFinish();


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 初始化布局
        setContentView(getContentViewResource());
        ButterKnife.bind(this);
        if (mToolbar != null) {
            setSupportActionBar(mToolbar);
            getSupportActionBar().setDisplayShowTitleEnabled(false);
        }

        // 初始化标题
        if (mTitle != null) {
            mTitle.setText(TextUtils.isEmpty(getTitleResource()) ? "" : getTitleResource());
        }

        init();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (getMenuResource() != 0) {
            getMenuInflater().inflate(getMenuResource(), menu);
        }
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        onMenuItemSelected(item);
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        onFinish();
    }


    /**
     * 设置toolbar显示返回按钮
     */
    protected void setDisplayHomeAsUpEnabled() {
        setNavigation(R.drawable.ic_arrow_back, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    /**
     * 设置toolbar显示navigation
     * @param iconRes     图标资源
     * @param listener    图标点击事件
     */
    protected void setNavigation(int iconRes, View.OnClickListener listener) {
        if (mToolbar != null) {
            mToolbar.setNavigationIcon(iconRes);
            mToolbar.setNavigationOnClickListener(listener == null ? new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onBackPressed();
                }
            } : listener);
        }
    }

    /**
     * 设置标题
     * @param title
     */
    protected void setTitle(String title) {
        if (mTitle != null) mTitle.setText(title);
    }

    /**
     * 弹出toast
     * @param msg   toast要显示的文本
     * @param isShort   true:短toast false:长toast
     */
    protected void toast(String msg, boolean isShort) {
        Toast.makeText(this, msg, isShort ? Toast.LENGTH_SHORT : Toast.LENGTH_LONG).show();
    }

    /**
     * 跳转Activity
     * @param targetClass   目标activity
     */
    protected void toActivity(Class targetClass) {
        toActivity(targetClass, new Intent(), false);
    }



    /**
     * 跳转Activity
     * @param targetClass    目标 activity
     * @param intent       intent 意图
     * @param finish    是否关闭当前 activity
     */
    protected void toActivity(Class targetClass, Intent intent, boolean finish) {
        if (intent != null) {
            intent.setClass(this, targetClass);
        } else {
            throw new NullPointerException("Intent is null");
        }
        startActivity(intent);
        if (finish) finish();
    }

    /**
     * 跳转Activity
     * @param targetClass      目标 activity
     * @param bundle     数据对象
     * @param finish    是否关闭当前 activity
     */
    protected void toActivity(Class targetClass, Bundle bundle, boolean finish) {
        Intent intent = new Intent(this, targetClass);
        intent.putExtras(bundle);
        startActivity(intent);

        if (finish) finish();
    }


}
