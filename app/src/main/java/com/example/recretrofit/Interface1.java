package com.example.recretrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Interface1 {


        @GET("posts")
        Call<List<model>> getUser();


    }

