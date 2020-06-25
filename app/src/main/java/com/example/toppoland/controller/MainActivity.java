package com.example.toppoland.controller;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.toppoland.ItemAdapter;
import com.example.toppoland.R;
import com.example.toppoland.api.Client;
import com.example.toppoland.api.Service;
import com.example.toppoland.model.Item;
import com.example.toppoland.model.ItemReponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private Item item;
    private TextView tx;
    private ImageView prueba;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        tx = findViewById(R.id.titleTop);

    }

    private void initViews() {
         recyclerView = (RecyclerView) findViewById(R.id.recycler);
         recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
         recyclerView.smoothScrollToPosition(0);
         loadJSON();

    }

    private void loadJSON() {
        try
        {
            Client client = new Client();
            Service apiService = client.getClient().create(Service.class);
            Call<ItemReponse> call = apiService.getItems();


            call.enqueue(new Callback<ItemReponse>() {
                @Override
                public void onResponse(Call<ItemReponse> call, Response<ItemReponse> response) {
                    List<Item> items = response.body().getItems();

                    recyclerView.setAdapter(new ItemAdapter(getApplicationContext(), items));
                    recyclerView.smoothScrollToPosition(0);



                }

                @Override
                public void onFailure(Call<ItemReponse> call, Throwable t) {

                }
        });
        }catch (RuntimeException e){


    }
}
}
