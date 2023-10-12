package com.example.netflixcustomadapters;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements RecyclerContactAdapter.OnNoteListener {
    ArrayList<TvShowModel> tvShowModels = new ArrayList<>();
    ImageView imageView;

    Button tvShowBtn , movieBtn , categoryBtn , mylist;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView = findViewById(R.id.recycler);
        imageView = findViewById(R.id.imageView);
        tvShowBtn = findViewById(R.id.tvShowBtn);
        mylist = findViewById(R.id.mylist);

        mylist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this , "Added to Your List" , Toast.LENGTH_SHORT).show();
            }
        });
        tvShowBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this , "Scroll Down to view",Toast.LENGTH_SHORT).show();
            }
        });

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Currently Unavailable", Toast.LENGTH_SHORT).show();
            }
        });


        RecyclerView recyclerView1 = findViewById(R.id.recycler1);

        //Layout Manager
        recyclerView.setLayoutManager(new LinearLayoutManager(this , LinearLayoutManager.HORIZONTAL , false));

        recyclerView1.setLayoutManager(new LinearLayoutManager(this , LinearLayoutManager.HORIZONTAL , false));


        tvShowModels.add(new TvShowModel(R.drawable.atypical));
        tvShowModels.add(new TvShowModel(R.drawable.hellbound));
        tvShowModels.add(new TvShowModel(R.drawable.lupin));
        tvShowModels.add(new TvShowModel(R.drawable.squid_games));
        tvShowModels.add(new TvShowModel(R.drawable.beef));
        tvShowModels.add(new TvShowModel(R.drawable.society));
        tvShowModels.add(new TvShowModel(R.drawable.wednesday));
        tvShowModels.add(new TvShowModel(R.drawable.you));


        RecyclerContactAdapter adapter = new RecyclerContactAdapter(this , tvShowModels , this);

        recyclerView.setAdapter(adapter);
        recyclerView1.setAdapter(adapter);







    }

    @Override
    public void onNoteClick(View v,int position) {
        Intent inext = new Intent(this, NewActivity.class);

        Toast.makeText(this , "Currently Unavailable"  , Toast.LENGTH_SHORT).show();
//        startActivity(inext);
    }
}