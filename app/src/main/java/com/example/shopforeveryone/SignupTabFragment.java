package com.example.shopforeveryone;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class SignupTabFragment extends Fragment {
    Button signup;
    EditText full_name,email,password,repassword;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup root=(ViewGroup) inflater.inflate(R.layout.signup_tab_fragment,container,false);

        signup=root.findViewById(R.id.signup);
        full_name=root.findViewById(R.id.full_name);
        email=root.findViewById(R.id.email);
        password=root.findViewById(R.id.password);
        repassword=root.findViewById(R.id.repassword);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SaveInfo();
            }
        });

        return root;
    }

    private void SaveInfo() {
        if (full_name.getText().toString().isEmpty()) {
            full_name.setError("full name required!");
            return;
        }
        if (email.getText().toString().isEmpty()) {
            email.setError("Enter valid email!");
            return;
        }
        if (password.getText().toString().isEmpty()) {
            password.setError("password required!");
            return;
        }
        if (repassword.getText().toString().isEmpty()) {
            repassword.setError("re-password required!");
            return;
        }
        if(!repassword.getText().toString().equals(password.getText().toString())){
            password.setError("not matched!");
            repassword.setError("not matched!");
            return;
        }

        UserData.setName(full_name.getText().toString());
        UserData.setEmail(email.getText().toString());
        UserData.setPassword(password.getText().toString());
        UserData.setProfileImage("");
        UserData.setPhoneNumber("");
        UserData.setAddress("");
        startActivity(new Intent(SignupTabFragment.super.getContext(),Home.class));
    }
}
