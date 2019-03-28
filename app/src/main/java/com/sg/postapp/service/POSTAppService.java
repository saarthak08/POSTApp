package com.sg.postapp.service;

import com.sg.postapp.model.User;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface POSTAppService {
    @POST("posts")
    Call<User> getResutls(@Body User user);
}
