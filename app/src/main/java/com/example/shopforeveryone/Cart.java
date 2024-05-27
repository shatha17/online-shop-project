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

public class Cart extends AppCompatActivity {

    RecyclerView view;
    List<ItemData> orders;
    CartAdapter adapter;

    ImageView cart_img;
    TextView text1,text2;
    Button button;
    ImageButton back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        view=findViewById(R.id.view);
        cart_img=findViewById(R.id.cart_img);
        text1=findViewById(R.id.text1);
        text2=findViewById(R.id.text2);
        button=findViewById(R.id.button);
        back=findViewById(R.id.back);

        orders=OrderList.getList();
        if(!orders.isEmpty()){
            cart_img.setVisibility(View.GONE);
            text1.setVisibility(View.GONE);
            text2.setVisibility(View.GONE);
            button.setText("Check-Out");
            view.setVisibility(View.VISIBLE);

            LinearLayoutManager layoutManager=new GridLayoutManager(this,2);
            view.setLayoutManager(layoutManager);
            adapter=new CartAdapter(orders,this);
            view.setAdapter(adapter);
        }
        else{
            cart_img.setVisibility(View.VISIBLE);
            text1.setVisibility(View.VISIBLE);
            text2.setVisibility(View.VISIBLE);
            button.setText("Order Now");
            view.setVisibility(View.GONE);
        }

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(button.getText().toString().equals("Check-Out")){
                    startActivity(new Intent(Cart.this,CheckOut.class));
                }
                else{
                    startActivity(new Intent(Cart.this,Home.class));
                }
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Cart.this,Home.class));
            }
        });
    }
}