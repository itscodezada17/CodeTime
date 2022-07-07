package com.example.codetime;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity {

    ApiInterface apiInterface;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        apiInterface = InstanceApi.getRetrofit().create(ApiInterface.class);
        recyclerView = findViewById(R.id.recyclerView);


        apiInterface.getContest().enqueue(new Callback<List<Pojo>>() {
            @Override
            public void onResponse(Call<List<Pojo>> call, Response<List<Pojo>> response) {
                  if(response.body().size()>0){
                      List<Pojo> contestList = response.body();
                      Adapter adapter = new Adapter(MainActivity.this , contestList);
                      LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MainActivity.this);

                      recyclerView.setLayoutManager(linearLayoutManager);
                      recyclerView.setAdapter(adapter);
                  }
                  else
                      Toast.makeText(MainActivity.this,"empty",Toast.LENGTH_SHORT).show();

            }


            @Override
            public void onFailure(Call<List<Pojo>> call, Throwable t) {
                Toast.makeText(MainActivity.this,t.getLocalizedMessage(),Toast.LENGTH_LONG).show();
            }
        });

    }
}