package com.fatto.android.ui.retrofit.api;

import com.fatto.android.ui.retrofit.api.model.TngouCook;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
/**
 * TODO 天狗菜谱分类列表 接口
 *
 * @author fattoliu
 * @version V 1.0
 * @date 17/2/8 14:42.
 */

public interface TngouService {

    @GET("api/cook/list")
    Call<TngouCook> getCookList(@Query("page")int page,
                                @Query("page")int rows,
                                @Query("page")int id);
}
