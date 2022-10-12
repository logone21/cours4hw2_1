package com.example.cours4hw1.data.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.cours4hw1.ui.Task


@Database(entities =[Task::class],version=1 )
    abstract class TaskDatabase : RoomDatabase () {
    abstract fun dao():TaskDao
}