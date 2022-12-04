package com.example.sharedpreference2;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Button btnSave, btnDelete, btnDeleteAll, btnUpdate, btnSearch, btnDisplay;
    private EditText edtID, edtFname, edtLname;
    private TextView blueToastMessage, redToastMessage;
    private LayoutInflater liBlue, liRed;
    private View blueToastLayout, redToastLayout;
    public static ArrayList<Student> studentsList;
    private Toast toast;



    @SuppressLint("MissingInflatedId")
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
        loadData();////////////////////\\\\\\\\\\\\\\\\\\\\\\\

        edtID = findViewById(R.id.EditTextID);
        edtFname = findViewById(R.id.EditTextFirstName);
        edtLname = findViewById(R.id.EditTextLastName);


        liBlue = getLayoutInflater();
        liRed = getLayoutInflater();


        blueToastLayout = liBlue.inflate(R.layout.blue_toast, findViewById(R.id.blue_toast_layout));
        redToastLayout = liRed.inflate(R.layout.red_toast,  findViewById(R.id.red_toast_layout));

        blueToastMessage = blueToastLayout.findViewById(R.id.blueToastMessage);
        redToastMessage = redToastLayout.findViewById(R.id.redToastMessage);






        btnSave.setOnClickListener(v -> {
            String id = edtID.getText().toString(), fName = edtFname.getText().toString(), lName = edtLname.getText().toString();
            Save(id, fName, lName);

            Toast.makeText(this, "Save Passed", Toast.LENGTH_SHORT).show();
        });

        btnDelete.setOnClickListener(v -> {
            Delete();
        });

        btnDeleteAll.setOnClickListener(v -> {
            deleteAll();
        });

        btnUpdate.setOnClickListener(v -> {
            Update();
        });

        btnSearch.setOnClickListener(v -> {
            Search();
        });

        btnDisplay.setOnClickListener(v -> {
            Display();
        });


    }



    private void InititalizeController() {


    }

    private void Display() {
        Intent i = new Intent(this, DisplayActivity.class);
        startActivity(i);
    }

    private void Search() {
    }

    private void Update() {
    }

    private void deleteAll() {
    }

    private void Delete() {
        redToastMessage.setText("Deleted Successfully");

        Toast toast = new Toast(getApplicationContext());
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER_HORIZONTAL|Gravity.TOP, 0, 150);
        toast.setView(redToastLayout);
        toast.show();
    }

    private void loadData() {
        SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("Student_List", MODE_PRIVATE);
        Gson gson = new Gson();

        String json = sharedPreferences.getString("StudentsList", null);
        Type type = new TypeToken<ArrayList<Student>>(){}.getType();

        studentsList = gson.fromJson(json, type);

        if(studentsList == null)
            studentsList = new ArrayList<>();
    }

    private void Save(String id, String fName, String lName) {

            SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("Students_List", MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();

            Gson gson = new Gson();
            studentsList.add(new Student(id, fName, lName));

            String json = gson.toJson(studentsList);
            editor.putString("StudentsList", json);
            editor.apply();
            loadData();

    }
}