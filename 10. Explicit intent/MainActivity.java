package com.example.s3mca55;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText name,age;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = findViewById(R.id.textName);
        age = findViewById(R.id.textAge);
    }


    public void switchActivity(View view){
        Intent intent = new Intent(MainActivity.this, MainActivity2.class);
        intent.putExtra("user",name.getText().toString());
        intent.putExtra("age",age.getText().toString());
        startActivity(intent);
    }
}