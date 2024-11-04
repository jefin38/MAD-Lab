package com.example.s3mca55;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    TextView text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent intent = getIntent();
        String user = intent.getStringExtra("user");
        String age = intent.getStringExtra("age");
        text = findViewById(R.id.textView);
        text.setText("Welcome "+user+" age "+age);
    }

}