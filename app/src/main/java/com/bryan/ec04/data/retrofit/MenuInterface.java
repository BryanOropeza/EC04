package com.bryan.ec04.data.retrofit;

import com.bryan.ec04.data.retrofit.response.ShowResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MenuInterface {
    @GET("d4c911e2-7d54-41ca-a762-44adecca3fda")
    Call<ShowResponse> getMenus();
}
