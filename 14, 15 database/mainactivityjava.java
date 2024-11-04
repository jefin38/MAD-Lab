package com.example.dbtry;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText name,contact,dob;
    Button insert,update,delete,view;
    DBHelper DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = findViewById(R.id.Name);
        contact = findViewById(R.id.contact);
        dob = findViewById(R.id.dob);
        insert = findViewById(R.id.btnInsert);
        update = findViewById(R.id.btnUpdate);
        delete = findViewById(R.id.btnDelete);
        view = findViewById(R.id.btnView);
        DB=new DBHelper(this);
        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nameTXT=name.getText().toString();
                String contactTXT=contact.getText().toString();
                String dobTXT=dob.getText().toString();
                Boolean checkinsertdata=DB.insertuserdata(nameTXT,contactTXT,dobTXT);
                if(checkinsertdata==true)
                    Toast.makeText(MainActivity.this, "New Entry Inserted", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(MainActivity.this, "Not Inserted", Toast.LENGTH_SHORT).show();
            }
        });
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nameTXT=name.getText().toString();
                String contactTXT=contact.getText().toString();
                String dobTXT=dob.getText().toString();
                Boolean checkupdatedata=DB.updateuserdata(nameTXT,contactTXT,dobTXT);
                if (checkupdatedata==true)
                    Toast.makeText(MainActivity.this, "Entry Updated!!!", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(MainActivity.this, "Not Updated", Toast.LENGTH_SHORT).show();
            }
        });
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nameTXT=name.getText().toString();
                Boolean checkdeletedata=DB.deletedata(nameTXT);
                if (checkdeletedata)
                    Toast.makeText(MainActivity.this, "Entry Deleted", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(MainActivity.this, "Not Deleted", Toast.LENGTH_SHORT).show();
            }
        });
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor result=DB.getdata();
                if (result.getCount()==0){
                    Toast.makeText(MainActivity.this, "No Entry Found!!", Toast.LENGTH_SHORT).show();
                }
                else{
                    StringBuffer buffer=new StringBuffer();
                    while(result.moveToNext()){
                        buffer.append("Name:"+result.getString(0)+"\n");
                        buffer.append("Contact:"+result.getString(1)+"\n");
                        buffer.append("DOB:"+result.getString(2)+"\n");
                    }
                    AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);
                    builder.setCancelable(true);
                    builder.setTitle("User Entries");
                    builder.setMessage(buffer.toString());
                    builder.show();

                }
            }
        });
    }
}