package com.example.cours4hw1

import android.app.Application
import androidx.room.Room
import com.example.cours4hw1.data.local.room.TaskDatabase

class App: Application() {

    override fun onCreate() {
        super.onCreate()
        db= Room.databaseBuilder(this, TaskDatabase::class.java, "database")
            .allowMainThreadQueries()
        .build();
    }
    companion object{
         lateinit var db: TaskDatabase
    }
}