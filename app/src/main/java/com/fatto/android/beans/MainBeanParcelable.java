package com.fatto.android.beans;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * TODO
 *
 * @author fattoliu
 * @version V 1.0
 * @date 17/1/21 00:19.
 */

public class MainBeanParcelable implements Parcelable {
    private String title;
    private String content;
    protected MainBeanParcelable(Parcel in) {

    }

    public static final Creator<MainBeanParcelable> CREATOR = new Creator<MainBeanParcelable>() {
        @Override
        public MainBeanParcelable createFromParcel(Parcel in) {
            return new MainBeanParcelable(in);
        }

        @Override
        public MainBeanParcelable[] newArray(int size) {
            return new MainBeanParcelable[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
    }
}
