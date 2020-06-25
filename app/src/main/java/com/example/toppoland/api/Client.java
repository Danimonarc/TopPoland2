package com.example.toppoland.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Client {
    public static final String BASE_URL ="https://api.github.com";
    public static Retrofit retrofit = null;
    public static Retrofit getClient()
    {
        if (retrofit == null)
        {
            return new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        }else
            {
                return retrofit;
            }
    }
    public Client() {

    }
}
