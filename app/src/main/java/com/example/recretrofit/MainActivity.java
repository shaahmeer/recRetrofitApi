package com.example.recretrofit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;


import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    public static final String BASE_URL = "https://jsonplaceholder.typicode.com/";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recview);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));



        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Interface1 interface1 =  retrofit.create(Interface1.class);

        Call<List<model>> lulu = interface1.getUser();

       lulu.enqueue(new Callback<List<model>>() {
           @Override
           public void onResponse(Call<List<model>> call, Response<List<model>> response) {
               List<model> modelList = response.body();
               recadapter recadapter1 = new recadapter(modelList);
               recyclerView.setAdapter(recadapter1);
           }

           @Override
           public void onFailure(Call<List<model>> call, Throwable t) {
               System.out.println(call+" "+t);

           }
       });



    }
}