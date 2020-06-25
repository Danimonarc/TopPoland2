package com.example.toppoland.api;

import com.example.toppoland.model.ItemReponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Service {
    @GET("/search/users?q=language:java+location:wroclaw+sort:repositories")
    Call<ItemReponse> getItems();
}
