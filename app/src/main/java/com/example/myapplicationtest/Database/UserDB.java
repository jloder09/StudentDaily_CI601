package com.example.myapplicationtest.Database;


import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.myapplicationtest.UserTable;

@Database(entities = {UserTable.class}, version = 1)
public abstract class UserDB extends RoomDatabase {
    public abstract UserDAO getDao();

}
