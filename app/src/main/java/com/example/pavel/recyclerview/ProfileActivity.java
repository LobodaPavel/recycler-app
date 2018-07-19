package com.example.pavel.recyclerview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

public class ProfileActivity extends AppCompatActivity {

    private TextView username;
    public static final String TAG = "ProfileActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        
        username = (TextView) findViewById(R.id.text_view);

        Log.d(TAG, "Profile Activity started");
        Intent intent = getIntent();
        Log.d(TAG, "get intent : completed");
        username.setText(intent.getStringExtra("username"));
        Log.d(TAG, "PText changed");
    }
}
