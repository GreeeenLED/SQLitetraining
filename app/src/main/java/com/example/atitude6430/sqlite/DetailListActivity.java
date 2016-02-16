package com.example.atitude6430.sqlite;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class DetailListActivity extends AppCompatActivity {

    ListView listView;
    SQLiteDatabase sqLiteDatabase;
    TableOperations tableOperations;

    Cursor cursor;

    ListDataAdapter listDataAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_list);

        listView = (ListView) findViewById(R.id.listView);

        tableOperations = new TableOperations(getApplicationContext());
        sqLiteDatabase = tableOperations.getReadableDatabase();

        listDataAdapter = new ListDataAdapter(getApplicationContext(),R.layout.single_row_view);
        listView.setAdapter(listDataAdapter);

        cursor = tableOperations.getInformations(sqLiteDatabase);
        if (cursor.moveToFirst()){
            do {
                String name, mobile,email;
                name = cursor.getString(0);
                mobile = cursor.getString(1);
                email = cursor.getString(2);
                DataProvider dataProvider = new DataProvider(name,mobile,email);

                //adding object to addpter
                listDataAdapter.add(dataProvider);

            }while (cursor.moveToNext());
        }
    }
}
