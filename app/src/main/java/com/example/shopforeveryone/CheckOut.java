package com.example.shopforeveryone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class CheckOut extends AppCompatActivity {
    EditText username,address,phone;
    TextView change,totalPrice;
    Button payment;
    ImageButton back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_out);

        username=findViewById(R.id.username);
        address=findViewById(R.id.address);
        phone=findViewById(R.id.phone);
        change=findViewById(R.id.change);
        totalPrice=findViewById(R.id.totalPrice);
        payment=findViewById(R.id.payment);
        back=findViewById(R.id.back);

        username.setText(UserData.getName());
        address.setText(UserData.getAddress());
        phone.setText(UserData.getPhoneNumber());

        change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                username.setEnabled(true);
                address.setEnabled(true);
                phone.setEnabled(true);
            }
        });

        int num=0;
        for (ItemData data:OrderList.getList()){
            num+=data.getNumber()*data.getPrice();
        }
        OrderList.setTotalPrice(num);
        totalPrice.setText(num+"");

        payment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Completed just for task 15 part 1",Toast.LENGTH_SHORT).show();
                OrderList.setState("Completed");
                //OrdersData.setOrderLists(OrderList);
                OrdersData.setOrderLists(OrderList.getList());
                OrdersData.setStates(OrderList.getState());
                OrdersData.setTotals(OrderList.getTotalPrice());
                List<ItemData> list = new ArrayList<>();
                OrderList.setAllList(list);
                OrderList.setState("hold");
                OrderList.setTotalPrice(0);
                startActivity(new Intent(CheckOut.this,Orders.class));
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CheckOut.this,Cart.class));
            }
        });
    }
}