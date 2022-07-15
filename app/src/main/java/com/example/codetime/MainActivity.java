package com.example.codetime;


import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
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
    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(false);
        builder.setMessage("Do you want to Exit?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //if user pressed "yes", then he is allowed to exit from application
                finish();
            }
        });
        builder.setNegativeButton("No",new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //if user select "No", just cancel this dialog and continue with app
                dialog.cancel();
            }
        });
        AlertDialog alert=builder.create();
        alert.show();
    }

}
