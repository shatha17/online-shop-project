package com.example.shopforeveryone;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class LoginTabFragment extends Fragment {
    Button login_bn;
    EditText email,password;
    TextView forget_pass;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup root=(ViewGroup) inflater.inflate(R.layout.login_tab_fragment,container,false);

        login_bn=root.findViewById(R.id.login_bn);
        email=root.findViewById(R.id.email_lg);
        password=root.findViewById(R.id.password_lg);
        forget_pass=root.findViewById(R.id.forget_pass);

        login_bn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CheckUserInfo();
            }
        });

        forget_pass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginTabFragment.super.getContext(),ForgetPassword.class));
            }
        });

        return root;
    }

    private void CheckUserInfo() {
        if (email.getText().toString().isEmpty()) {
            email.setError("Enter valid email!");
            return;
        }
        if (password.getText().toString().isEmpty()) {
            password.setError("password required!");
            return;
        }

        if(!UserData.getName().isEmpty() || !UserData.getName().equals(null)){
            if(email.getText().toString().equals(UserData.getEmail())
                    && password.getText().toString().equals(UserData.getPassword()))
                startActivity(new Intent(LoginTabFragment.super.getContext(),Home.class));
            else
                Toast.makeText(LoginTabFragment.super.getContext(),"Wrong password or email!",Toast.LENGTH_SHORT).show();
        }
        else
            Toast.makeText(LoginTabFragment.super.getContext(),"Wrong password or email!",Toast.LENGTH_SHORT).show();
    }
}
