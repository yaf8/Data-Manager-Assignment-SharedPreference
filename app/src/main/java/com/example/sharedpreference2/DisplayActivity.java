package com.example.sharedpreference2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class DisplayActivity extends AppCompatActivity {

    Button btnBack;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        textView = findViewById(R.id.textView);
        btnBack = findViewById(R.id.btnBack);

        loadData();

        btnBack.setOnClickListener(v -> {
            Intent i = new Intent(this, MainActivity.class);
            startActivity(i);
        });

}

    public void loadData() {

        SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("Students_List", MODE_PRIVATE);
        Gson gson = new Gson();

        String json = sharedPreferences.getString("StudentsList", null);

        Type type = new TypeToken<ArrayList<Student>>() {}.getType();

        MainActivity.studentsList = gson.fromJson(json, type);
        if (MainActivity.studentsList == null) {
            MainActivity.studentsList = new ArrayList<>();
            textView.setText("Empty");
        } else {
            for (int i = 0; i < MainActivity.studentsList.size(); i++) {
                textView.setText(textView.getText().toString() + "\n" + (i + 1) + ". " + MainActivity.studentsList.get(i).ID + " " + MainActivity.studentsList.get(i).FirstName + " " + MainActivity.studentsList.get(i).LastName + "\n");
            }
        }
    }
}