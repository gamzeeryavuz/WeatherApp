package com.example.weatherapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.weatherapp.Adapter.FutureAdapter;
import com.example.weatherapp.Domains.FutureDomain;

import java.util.ArrayList;

public class FutureActivity extends AppCompatActivity {
    private RecyclerView.Adapter adapterTomorrow;
    public RecyclerView recyclerView ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_future);

        initRecyclerView();
        setVariable();

    }

    private void setVariable() {
        ConstraintLayout backBtn=findViewById(R.id.backBtn);
        backBtn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                startActivity(new Intent(FutureActivity.this,MainActivity.class));

            }
        }  );
    }

    private void initRecyclerView() {
        ArrayList<FutureDomain> items=new ArrayList<>();

        items.add(new FutureDomain("Sat","storm","Storm",25,10));
        items.add(new FutureDomain("Sun","cloudy","Cloudy",23,16));
        items.add(new FutureDomain("Mon","windy","Windy",18,15));
        items.add(new FutureDomain("Tue","cloudy_sunny","Cloud_sunny",25,13));
        items.add(new FutureDomain("Wen","Sunny","Sunny",27,11));
        items.add(new FutureDomain("Thu","Rainy","Rainy",23,12));

        recyclerView=findViewById(R.id.view2) ;
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));

        adapterTomorrow=new FutureAdapter(items);
        recyclerView.setAdapter(adapterTomorrow);






    }
}