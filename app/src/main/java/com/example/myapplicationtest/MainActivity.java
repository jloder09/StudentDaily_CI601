package com.example.myapplicationtest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import com.example.myapplicationtest.Database.UserDAO;
import com.example.myapplicationtest.Database.UserDB;
import com.example.myapplicationtest.databinding.ActivityMainBinding;
import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    UserDB userDb;
    UserDAO userDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        userDb = Room.databaseBuilder(this, UserDB.class, "usertable").allowMainThreadQueries().fallbackToDestructiveMigration().build();
        userDAO = userDb.getDao();

        binding.loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userName = binding.username.getText().toString();
                String password = binding.password.getText().toString();

                if (userDAO.login(userName, password)){
                    startActivity(new Intent(MainActivity.this, MainPage.class));
                }
                else{
                    Toast.makeText(MainActivity.this, "Invalid Username or Password", Toast.LENGTH_SHORT).show();
                }
            }
        });

        binding.signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, signUp.class));
            }
        });



    }
}