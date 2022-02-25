package com.example.sql.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.sql.dao.BookDao
import com.example.sql.dao.genreDao
import com.example.sql.entities.Book
import com.example.sql.entities.Genre

@Database(entities = [Book::class, Genre::class], version = 3)
abstract class AppDatabase : RoomDatabase() {
    abstract fun bookDao(): BookDao
    abstract fun genreDao(): genreDao



}