package com.example.myapplicationtest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainPage extends AppCompatActivity {

    private TextView DateText;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);

        DateText = findViewById(R.id.currentDate);
        SimpleDateFormat sdf = new SimpleDateFormat("dd / MM / yyyy");
        String currentDate = sdf.format(new Date());
        DateText.setText(currentDate);

        Button calendar_button = (Button) findViewById(R.id.calendar_button);
        calendar_button.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v){
                startActivity(new Intent(MainPage.this, Calendar.class));
            }
        });

        Button map_button = (Button) findViewById(R.id.map_button);
        map_button.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v){
                startActivity(new Intent(MainPage.this, Map.class));
            }
        });

        Button notes_button = (Button) findViewById(R.id.notes_button);
        notes_button.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v){
                startActivity(new Intent(MainPage.this, NotesPage.class));
            }
        });

        };




    }
