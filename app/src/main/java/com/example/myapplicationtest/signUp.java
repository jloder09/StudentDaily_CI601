package com.example.myapplicationtest;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.room.Room;

import com.example.myapplicationtest.Database.UserDAO;
import com.example.myapplicationtest.Database.UserDB;
import com.example.myapplicationtest.databinding.ActivitySignUpBinding;

public class signUp extends AppCompatActivity {
    ActivitySignUpBinding binding;
    UserDB userDb;
    UserDAO userDAO;
    public static  boolean isAllowed = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySignUpBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        userDb = Room.databaseBuilder(this, UserDB.class, "usertable").allowMainThreadQueries().fallbackToDestructiveMigration().build();
        userDAO = userDb.getDao();

        binding.username.addTextChangedListener(new TextWatcher(){

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                String userName = editable.toString();
                if (userDAO.is_taken(userName)){
                    isAllowed=false;
                    Toast.makeText(signUp.this, "Username Already Taken", Toast.LENGTH_SHORT).show();
                }
                else{
                    isAllowed = true;
                }

            }
        });

        binding.signupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isAllowed){
                    UserTable userTable = new UserTable(0, binding.username.getText().toString(), binding.password.getText().toString());
                    userDAO.insertUser(userTable);
                    Toast.makeText(signUp.this, "Account Created", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(signUp.this, "Username Already Taken", Toast.LENGTH_SHORT).show();
                }
            }
        });

        Button backLoginBtn = (Button) findViewById(R.id.backLoginBtn);
        backLoginBtn.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v){
                startActivity(new Intent(signUp.this, MainActivity.class));
            }
        });

    }
}