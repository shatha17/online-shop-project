package com.example.shopforeveryone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ForgetPassword extends AppCompatActivity {
    EditText code,repassword;
    Button send;
    TextView text1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_password);

        send=findViewById(R.id.send);
        code=findViewById(R.id.code);
        repassword=findViewById(R.id.repassword);
        text1=findViewById(R.id.text1);

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(send.getText().toString().equals("Send Code"))
                    SendCode();
                else if(send.getText().toString().equals("Check"))
                    Check();
                else if(send.getText().toString().equals("Change"))
                    Change();
            }
        });
    }

    private void Change() {
        //change the password in database

        if(!code.getText().toString().isEmpty() && code.getText().toString().equals(repassword.getText().toString())){
            if(!UserData.getPassword().equals(""))
                UserData.setPassword(code.getText().toString());
            Toast.makeText(getApplicationContext(),"changed successfully!",Toast.LENGTH_SHORT).show();
            startActivity(new Intent(ForgetPassword.this, Login.class));
        }
        else{
            code.setError("required!");
            repassword.setError("required!");
        }
    }

    private void Check() {
        //check the code with entering code

        //if its true
        code.setText("");
        code.setHint("Password");
        send.setText("Change");
        text1.setText("Enter your new password.");
        repassword.setVisibility(View.VISIBLE);
    }

    private void SendCode() {
        //send code to the User Email
        //needs database

        //after sending the code to the email
        code.setText("");
        code.setHint("Code");
        send.setText("Check");
        text1.setText("Enter verification code.");
    }
}