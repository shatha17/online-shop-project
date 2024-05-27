package com.example.shopforeveryone;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;

public class Profile extends AppCompatActivity {
    Button save;
    EditText full_name,email,password,phoneNumber,address;
    TextView change;
    CircleImageView profile_image;
    private static final int PICK_FROM_GALLERY = 1;
    private Uri mImageUri;
    ImageButton bell,back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        full_name=findViewById(R.id.full_name);
        email=findViewById(R.id.email);
        password=findViewById(R.id.password);
        phoneNumber=findViewById(R.id.phoneNumber);
        address=findViewById(R.id.address);
        change=findViewById(R.id.change);
        profile_image=findViewById(R.id.profile_image);
        save=findViewById(R.id.save);
        bell=findViewById(R.id.bell);
        back=findViewById(R.id.back);

        FillUserInfo();

        change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    if (ActivityCompat.checkSelfPermission(Profile.this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                        ActivityCompat.requestPermissions(Profile.this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE}, PICK_FROM_GALLERY);
                    } else {
                        Intent galleryIntent = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                        startActivityForResult(galleryIntent, PICK_FROM_GALLERY);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SaveUserInfo();
            }
        });

        bell.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Notifications();
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Profile.this,Home.class));
            }
        });
    }

    private void Notifications() {
        LayoutInflater factory = LayoutInflater.from(Profile.this);
        final View DialogView = factory.inflate(R.layout.notifications_dialog, null);
        final AlertDialog dialog = new AlertDialog.Builder(Profile.this).create();
        dialog.setView(DialogView);

        DialogView.findViewById(R.id.close).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.cancel();
            }
        });

        dialog.show();
    }

    private void SaveUserInfo() {
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
        if (phoneNumber.getText().toString().isEmpty()) {
            phoneNumber.setError("Enter valid phoneNumber!");
            return;
        }
        if (address.getText().toString().isEmpty()) {
            address.setError("address required!");
            return;
        }

        UserData.setName(full_name.getText().toString());
        UserData.setEmail(email.getText().toString());
        UserData.setPassword(password.getText().toString());
        UserData.setProfileImage(mImageUri.toString());
        UserData.setPhoneNumber(phoneNumber.getText().toString());
        UserData.setAddress(address.getText().toString());
        Toast.makeText(getApplicationContext(), "saved successfully!", Toast.LENGTH_SHORT).show();
    }

    private void FillUserInfo() {
        if(!UserData.getName().equals("")) {
            full_name.setText(UserData.getName());
            email.setText(UserData.getEmail());
            password.setText(UserData.getPassword());
        }
        if(!UserData.getProfileImage().equals("")){
            Picasso.get().load(UserData.getProfileImage()).placeholder(R.drawable.userprofile).into(profile_image);
        }
        if(!UserData.getPhoneNumber().trim().equals("")){
            phoneNumber.setText(UserData.getPhoneNumber());
        }
        if(!UserData.getAddress().trim().equals("")){
            address.setText(UserData.getAddress());
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {
            if (requestCode == PICK_FROM_GALLERY) {
                Uri selectedImageUri = data.getData();
                if (null != selectedImageUri) {
                    //profile_image.setImageURI(selectedImageUri);
                    //UserInfo.setProfile_image(selectedImageUri);
                    mImageUri = data.getData();
                    Picasso.get().load(mImageUri).placeholder(R.drawable.userprofile).into(profile_image);
                }
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        switch (requestCode) {
            case PICK_FROM_GALLERY:
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Intent galleryIntent = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                    startActivityForResult(galleryIntent, PICK_FROM_GALLERY);
                } else {
                    Toast.makeText(getApplicationContext(), "the permissions NOT GRANTED", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }
}