package com.example.proyectomoviles.model.tareas

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [MyFriend::class], version = 1)
abstract class MyFriendsDatabase: RoomDatabase() {
    abstract fun myFriendsDao(): MyFriendsDao

    companion object {
        @Volatile
        private var Instance: MyFriendsDatabase? = null

        fun getMyFriendsDatabase(context: Context): MyFriendsDatabase {
            return Instance ?: synchronized(this) {
                Room.databaseBuilder(
                    context = context,
                    klass = MyFriendsDatabase::class.java,
                    name = "sample"
                )
                    .build()
                    .also { Instance = it }
            }
        }
    }
}