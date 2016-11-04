package com.fatto.android.beans;

import java.io.Serializable;

/**
 * TODO 主界面列表信息Bean
 *
 * @author fattoliu
 * @version V 1.0
 * @date 16/11/3 09:03.
 */

public class MainBean implements Serializable {

    /**
     * 序列化ID
     */
    private static final long serialVersionUID = -3289380916273456040L;
    /**
     * 标题
     */
    private String title;
    /**
     * 内容
     */
    private String content;

    public MainBean(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
