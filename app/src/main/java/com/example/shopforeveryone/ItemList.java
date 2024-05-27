package com.example.shopforeveryone;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ItemList extends AppCompatActivity {
    RecyclerView view;
    List<ItemData> list=new ArrayList<>();
    ItemListAdapter adapter;
    TextView itemtype;
    ImageButton back,cart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_list);

        view=findViewById(R.id.view);
        itemtype=findViewById(R.id.itemtype);
        back=findViewById(R.id.back);
        cart=findViewById(R.id.cart);

        String type=getIntent().getExtras().getString("type");
        SetInList(type);

        LinearLayoutManager layoutManager=new GridLayoutManager(this,2);
        view.setLayoutManager(layoutManager);
        adapter=new ItemListAdapter(list,this);
        view.setAdapter(adapter);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ItemList.this,Home.class));
            }
        });

        cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ItemList.this,Cart.class));
            }
        });
    }

    private void SetInList(String type) {
        if(type.equals("woman")){
            itemtype.setText("Woman");
            list.add(new ItemData("woman",R.drawable.woman_items1,"Woman jacket",15,1,String.valueOf(R.string.description)));
            list.add(new ItemData("woman",R.drawable.woman_items2,"Woman dress",10,4,String.valueOf(R.string.description)));
            list.add(new ItemData("woman",R.drawable.woman_items3,"Woman jacket",20,2,String.valueOf(R.string.description)));
            list.add(new ItemData("woman",R.drawable.woman_items4,"Woman dress",10,7,String.valueOf(R.string.description)));
        }
        else if(type.equals("men")){
            itemtype.setText("Men");
            list.add(new ItemData("men",R.drawable.man_items1,"man jacket",15,3,String.valueOf(R.string.description)));
            list.add(new ItemData("men",R.drawable.man_items2,"man jacket",10,6,String.valueOf(R.string.description)));
            list.add(new ItemData("men",R.drawable.man_items3,"man jacket",20,8,String.valueOf(R.string.description)));
            list.add(new ItemData("men",R.drawable.man_items1,"man jacket",15,3,String.valueOf(R.string.description)));
            list.add(new ItemData("men",R.drawable.man_items2,"man jacket",10,6,String.valueOf(R.string.description)));
        }
        else if(type.equals("kids")){
            itemtype.setText("Kids");
            list.add(new ItemData("kids",R.drawable.kids_items1,"kids jacket",10,1,String.valueOf(R.string.description)));
            list.add(new ItemData("kids",R.drawable.kids_items2,"kids dress",5,4,String.valueOf(R.string.description)));
            list.add(new ItemData("kids",R.drawable.kids_items3,"kids jacket",20,2,String.valueOf(R.string.description)));
            list.add(new ItemData("kids",R.drawable.kids_items1,"kids jacket",10,1,String.valueOf(R.string.description)));
            list.add(new ItemData("kids",R.drawable.kids_items2,"kids dress",5,4,String.valueOf(R.string.description)));
        }
        else{
            itemtype.setText("All");
            list.add(new ItemData("all",R.drawable.woman_items1,"Woman jacket",15,1,String.valueOf(R.string.description)));
            list.add(new ItemData("all",R.drawable.woman_items2,"Woman dress",10,4,String.valueOf(R.string.description)));
            list.add(new ItemData("all",R.drawable.woman_items3,"Woman jacket",20,2,String.valueOf(R.string.description)));
            list.add(new ItemData("all",R.drawable.woman_items4,"Woman dress",10,7,String.valueOf(R.string.description)));
            list.add(new ItemData("all",R.drawable.man_items1,"man jacket",15,3,String.valueOf(R.string.description)));
            list.add(new ItemData("all",R.drawable.man_items2,"man jacket",10,6,String.valueOf(R.string.description)));
            list.add(new ItemData("all",R.drawable.man_items3,"man jacket",20,8,String.valueOf(R.string.description)));
            list.add(new ItemData("all",R.drawable.kids_items1,"kids jacket",10,1,String.valueOf(R.string.description)));
            list.add(new ItemData("all",R.drawable.kids_items2,"kids dress",5,4,String.valueOf(R.string.description)));
            list.add(new ItemData("all",R.drawable.kids_items3,"kids jacket",20,2,String.valueOf(R.string.description)));
        }
    }
}