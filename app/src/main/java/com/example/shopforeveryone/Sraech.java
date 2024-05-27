package com.example.shopforeveryone;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Sraech extends AppCompatActivity {
    String textSearch;
    List<ItemData> list=new ArrayList<>();

    RecyclerView view;
    List<ItemData> list2=new ArrayList<>();
    ItemListAdapter adapter;
    ImageButton back;

    RelativeLayout searchView_layout;
    TextView text,text1,text2;
    ImageView simg;
    EditText find;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sraech);

        view=findViewById(R.id.view);
        back=findViewById(R.id.back);
        searchView_layout=findViewById(R.id.searchView_layout);
        text=findViewById(R.id.text);
        text1=findViewById(R.id.text1);
        text2=findViewById(R.id.text2);
        simg=findViewById(R.id.simg);
        find=findViewById(R.id.find);

        textSearch=getIntent().getExtras().getString("text");
        PutInList();

        for(ItemData data:list){
            if(data.getTitle().toLowerCase().contains(textSearch.toLowerCase()))
                list2.add(data);
        }

        text1.setText(textSearch);
        if(!list2.isEmpty()){
            simg.setVisibility(View.GONE);
            text1.setVisibility(View.GONE);
            text2.setVisibility(View.GONE);

            searchView_layout.setVisibility(View.VISIBLE);
            text.setVisibility(View.VISIBLE);
            view.setVisibility(View.VISIBLE);
            find.setText(textSearch);

            text.setText("Found "+list2.size()+" results");
            LinearLayoutManager layoutManager=new GridLayoutManager(this,2);
            view.setLayoutManager(layoutManager);
            adapter=new ItemListAdapter(list2,this);
            view.setAdapter(adapter);
        }

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Sraech.this,Home.class));
            }
        });
    }

    private void PutInList() {
        list.add(new ItemData("woman",R.drawable.woman_items1,"Woman jacket",15,1,String.valueOf(R.string.description)));
        list.add(new ItemData("woman",R.drawable.woman_items2,"Woman dress",10,4,String.valueOf(R.string.description)));
        list.add(new ItemData("woman",R.drawable.woman_items3,"Woman jacket",20,2,String.valueOf(R.string.description)));
        list.add(new ItemData("woman",R.drawable.woman_items4,"Woman dress",10,7,String.valueOf(R.string.description)));
        list.add(new ItemData("men",R.drawable.man_items1,"man jacket",15,3,String.valueOf(R.string.description)));
        list.add(new ItemData("men",R.drawable.man_items2,"man jacket",10,6,String.valueOf(R.string.description)));
        list.add(new ItemData("men",R.drawable.man_items3,"man jacket",20,8,String.valueOf(R.string.description)));
        list.add(new ItemData("kids",R.drawable.kids_items1,"kids jacket",10,1,String.valueOf(R.string.description)));
        list.add(new ItemData("kids",R.drawable.kids_items2,"kids dress",5,4,String.valueOf(R.string.description)));
        list.add(new ItemData("kids",R.drawable.kids_items3,"kids jacket",20,2,String.valueOf(R.string.description)));
    }
}