package com.example.imageapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ImageAdapter adapter;
    private ArrayList<String> imageUrlList;
    private RecyclerView recyclerView;
    private Button loadImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        adapter = new ImageAdapter(this);

        imageUrlList = new ArrayList<>();
        adapter.setList(imageUrlList);

        recyclerView.setAdapter(adapter);

        loadImage = findViewById(R.id.load_image_button);
        loadImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://picsum.photos/";
                long random = Math.round(Math.random() * 1000);
                url += String.valueOf(random);
                imageUrlList.add(url);
                adapter.notifyDataSetChanged();
            }
        });

    }

}