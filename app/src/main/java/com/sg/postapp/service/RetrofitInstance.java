package com.sg.postapp.service;

import android.graphics.PostProcessor;

import com.google.gson.Gson;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstance {
    private static Retrofit retrofit=null;
    private static String BASE_URL="https://jsonplaceholder.typicode.com/";
    public static POSTAppService getService()
    {
        if(retrofit==null)
        {
            retrofit=new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        }
        return retrofit.create(POSTAppService.class);

    }
}
