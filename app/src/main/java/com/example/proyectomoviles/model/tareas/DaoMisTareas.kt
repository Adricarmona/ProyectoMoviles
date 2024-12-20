package com.example.proyectomoviles.model.tareas

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface MyFriendsDao {
    @Query("SELECT * FROM sample")
    fun getAll(): Flow<List<MyFriend>>

    @Insert
    suspend fun insertFriend(myFriend: MyFriend)

    @Delete
    suspend fun deleteAllMyFriends(allMyFriends: List<MyFriend>)
}