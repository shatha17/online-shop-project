package com.example.shopforeveryone;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewSwitcher;

public class ViewItem extends AppCompatActivity {
    ImageView image;
    ImageButton bt1, bt2;

    String type, title, price;
    int image1;
    TextView item_name, item_price, item_type, number;

    Button add_tocart,buy_now;
    ImageButton back,cart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_item);

        image = findViewById(R.id.image);
        item_name = findViewById(R.id.item_name);
        item_price = findViewById(R.id.item_price);
        item_type = findViewById(R.id.item_type);
        number = findViewById(R.id.number);

        bt1 = findViewById(R.id.bt1);
        bt2 = findViewById(R.id.bt2);

        type = getIntent().getExtras().getString("type");
        image1 = getIntent().getExtras().getInt("image");
        title = getIntent().getExtras().getString("title");
        price = getIntent().getExtras().getString("price");

        item_name.setText(title);
        item_price.setText(price+" JD");
        item_type.setText(type);
        image.setBackgroundResource(image1);

        add_tocart=findViewById(R.id.add_tocart);
        add_tocart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int p=Integer.parseInt(price);
                int n=Integer.parseInt(number.getText().toString());
                ItemData data=new ItemData(type,image1,title,p,n,"");
                OrderList.setList(data);
                Toast.makeText(getApplicationContext(),"Add Successfully!",Toast.LENGTH_SHORT).show();
            }
        });

        buy_now=findViewById(R.id.buy_now);
        buy_now.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int p=Integer.parseInt(price);
                int n=Integer.parseInt(number.getText().toString());
                ItemData data=new ItemData(type,image1,title,p,n,"");
                OrderList.setList(data);
                startActivity(new Intent(ViewItem.this,Cart.class));
            }
        });

        cart=findViewById(R.id.cart);
        cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ViewItem.this,Cart.class));
            }
        });

        back=findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //startActivity(new Intent(ViewItem.this,Home.class));
                finish();
            }
        });
    }

    public void left(View v) {
        image.setBackgroundResource(image1);
        bt1.setBackgroundResource(R.drawable.circlered);
        bt2.setBackgroundResource(R.drawable.circlegray);
    }

    public void right(View v) {
        image.setBackgroundResource(R.drawable.woman_items4);
        bt2.setBackgroundResource(R.drawable.circlered);
        bt1.setBackgroundResource(R.drawable.circlegray);
    }

    public void plus(View v) {
        int num = Integer.parseInt(number.getText().toString()) + 1;
        number.setText(num + "");

    }

    public void minus(View v) {
        if (!number.getText().toString().equals("0")) {
            int num = Integer.parseInt(number.getText().toString()) - 1;
            number.setText(num + "");
        }
    }

}