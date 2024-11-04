package com.example.s3mca55;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView selctdfgmt = findViewById(R.id.selectedFrgmnt);
        Button frgmntbtn1 = findViewById(R.id.frgmnt1);
        Button frgmntbtn2 = findViewById(R.id.frgmnt2);

        frgmntbtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction().replace(R.id.frgmntcontainer, new FirstFragment()).commit();
                selctdfgmt.setText("Selected: fragment-1");
            }
        });
        frgmntbtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction().replace(R.id.frgmntcontainer, new SecondFragment()).commit();
                selctdfgmt.setText("Selected: fragment-2");
            }
        });

    }

}