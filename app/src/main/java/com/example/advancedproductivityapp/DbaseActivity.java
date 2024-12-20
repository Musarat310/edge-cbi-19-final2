package com.example.advancedproductivityapp;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.database.sqlite.SQLiteDatabase;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class DbaseActivity extends AppCompatActivity {
    Button btnm;
    EditText name, sname, cname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_dbase);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        name = findViewById(R.id.dbname);
        sname = findViewById(R.id.dbsname);
        cname = findViewById(R.id.dbcname);
        btnm = findViewById(R.id.btndbname);
        btnm.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String dataname = name.getText().toString();
                String studentname = sname.getText().toString();
                String coursename = cname.getText().toString();
                DatabaseHelper dbhelper = new DatabaseHelper(DbaseActivity.this);
                SQLiteDatabase db1 = dbhelper.getWritableDatabase();
                dbhelper.addStudent(studentname, coursename);
            }
        });

    }
}