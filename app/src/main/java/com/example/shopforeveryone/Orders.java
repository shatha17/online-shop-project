package com.example.shopforeveryone;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class Orders extends AppCompatActivity {
    RecyclerView view;
    List<List<ItemData>> orders;
    List<String> states;
    List<Integer> totals;
    OrdersAdapter adapter;

    ImageView order_img;
    TextView text1,text2;
    Button button;

    ImageButton back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orders);

        view=findViewById(R.id.view);
        order_img=findViewById(R.id.order_img);
        text1=findViewById(R.id.text1);
        text2=findViewById(R.id.text2);
        button=findViewById(R.id.button);
        back=findViewById(R.id.back);

        orders=OrdersData.getOrderLists();
        states=OrdersData.getStates();
        totals=OrdersData.getTotals();
        if(!orders.isEmpty()){
            order_img.setVisibility(View.GONE);
            text1.setVisibility(View.GONE);
            text2.setVisibility(View.GONE);
            button.setVisibility(View.GONE);
            view.setVisibility(View.VISIBLE);

            LinearLayoutManager layoutManager=new LinearLayoutManager(this);
            view.setLayoutManager(layoutManager);
            adapter=new OrdersAdapter(orders,states,totals,this);
            view.setAdapter(adapter);
        }
        else{
            order_img.setVisibility(View.VISIBLE);
            text1.setVisibility(View.VISIBLE);
            text2.setVisibility(View.VISIBLE);
            button.setVisibility(View.VISIBLE);
            view.setVisibility(View.GONE);

            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    startActivity(new Intent(Orders.this,Home.class));
                }
            });
        }

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Orders.this,Home.class));
            }
        });
    }
}