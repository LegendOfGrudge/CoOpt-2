package com.example.coopt_1

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Book::class], version = 1)
abstract class BookDatabase : RoomDatabase() {
    abstract fun bookDao(): BookDao

    companion object {
        private var instance: BookDatabase? = null
        fun getInstance(context: Context): BookDatabase {
            if (instance == null) {
                instance = Room.databaseBuilder(context,BookDatabase::class.java,"books_database.db")
                    .allowMainThreadQueries()
                    .build()
            }
            return instance as BookDatabase
        }
    }
}