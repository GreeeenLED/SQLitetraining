package com.example.atitude6430.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText new_name, new_mobile, new_email;
    Context context= this;
    TableOperations tableOperations;
    SQLiteDatabase sqLiteDatabase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new_name = (EditText) findViewById(R.id.editText);
        new_mobile = (EditText) findViewById(R.id.editText2);
        new_email = (EditText) findViewById(R.id.editText3);
    }
    public void AddNew(View view){
        String name = new_name.getText().toString();
        String mobile = new_mobile.getText().toString();
        String email = new_email.getText().toString();

        tableOperations = new TableOperations(context);
        sqLiteDatabase = tableOperations.getWritableDatabase();
        tableOperations.addInformations(name,mobile,email,sqLiteDatabase);
        Toast.makeText(getBaseContext(),"Row added",Toast.LENGTH_SHORT).show();
        tableOperations.close();

    }
}
