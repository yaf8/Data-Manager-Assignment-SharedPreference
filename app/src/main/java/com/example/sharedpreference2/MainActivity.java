package com.example.sharedpreference2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button btnSave, btnDelete, btnDeleteAll, btnUpdate, btnSearch, btnDisplay;
    EditText edtID, edtFname, edtLname;

    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSave = findViewById(R.id.btnSave);
        btnDelete = findViewById(R.id.btnDelete);
        btnDeleteAll = findViewById(R.id.btnDeleteAll);
        btnUpdate = findViewById(R.id.btnUpdate);
        btnSearch = findViewById(R.id.btnSearch);
        btnDisplay = findViewById(R.id.btnDisplay);
        edtID = findViewById(R.id.EditTextID);
        edtFname = findViewById(R.id.EditTextFirstName);
        edtLname = findViewById(R.id.EditTextLastName);

        btnSave.setOnClickListener(v -> {

        });

        btnDelete.setOnClickListener(v -> {

        });

        btnDeleteAll.setOnClickListener(v -> {

        });

        btnUpdate.setOnClickListener(v -> {

        });

        btnSearch.setOnClickListener(v -> {

        });

        btnDisplay.setOnClickListener(v -> {

        });


    }
}