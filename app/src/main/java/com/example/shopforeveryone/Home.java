package com.example.shopforeveryone;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;

public class Home extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    SearchView searchView;

    TabLayout tabLayout;
    ViewPager viewPager;

    EditText find;
    ImageButton cart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        bottomNavigationView = findViewById(R.id.bottomNavigationView);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.order:
                        startActivity(new Intent(Home.this,Orders.class));
                        break;
                    case R.id.profile:
                        startActivity(new Intent(Home.this,Profile.class));
                        break;
                    case R.id.notification:
                        startActivity(new Intent(Home.this,Home.class));
                        break;
                }
                return true;
            }
        });

        find=findViewById(R.id.find);
        find.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == EditorInfo.IME_ACTION_DONE && textView.getText().toString() != null) {
                    Intent intent=new Intent(Home.this,Sraech.class);
                    intent.putExtra("text",textView.getText().toString());
                    startActivity(intent);
                    return true;
                } else
                    Toast.makeText(getApplicationContext(), "something went wrong!", Toast.LENGTH_SHORT).show();

                return false;
            }
        });

        tabLayout=findViewById(R.id.tab_layout);
        viewPager=findViewById(R.id.pager);

        final LoginAdapter adapter=new LoginAdapter(getSupportFragmentManager(),this,tabLayout.getTabCount());
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        cart=findViewById(R.id.cart);
        cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Home.this,Cart.class));
            }
        });
    }
}